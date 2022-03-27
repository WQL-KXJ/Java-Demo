package com.sso.commons;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Date;

//JWT工具类(核心部分)
public class JWTUtils {

    //服务器的key,用于做加解密的key数据,如果可以使用客户端生成的key当前定义可以不使用
    private static final String JWT_SECERT = "test_jwt_secert";

    //ObjectMapper用于java对象和json转化的集合
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //自定义状态码
    private static final int JWT_ERRCODE_EXPRRE = 1000;//Token过期
    private static final int JWT_ERRCODE_FAIL = 1001;//验证不通过

    public static SecretKey generalKey(){
        try{
            //将服务器的key转化为byte数组
            byte[] encodeKey = JWT_SECERT.getBytes("UTF-8");
            //通过服务端key进行加密获取加密的密匙，AES是加密方式
            SecretKeySpec aes = new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
            return aes;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    /*
    * 签发JWT，创建token的方法
    * id：jwt的唯一身份标识，主要用于一次性token，从而回避攻击
    * iss：jwt签发者
    * subject：jwt所面向的用户，pyeload中记录的public Claims 当前环境就是用户登录名
    * ttlMillis：token的有效期(单位：毫秒)
    * token：token是一次性的，是为一个用户的有效登录期准备的一个token，用户退出或者超时，token失效
    * */
    public static String CreateJWT(String id,String iss,String subject,long ttlMillis){
        //加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //当前时间
        long nowMillis = System.currentTimeMillis();
        //当前时间的日期对象
        Date date = new Date(nowMillis);
        //获取服务端加密的密钥
        SecretKey secretKey = generalKey();
        //创建JWT的构建器，就是使用指定信息和加密算法，生成Token令牌
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuer(iss)
                .setSubject(subject)
                .setIssuedAt(date)//token的生成时间
                .signWith(signatureAlgorithm,secretKey);//设置密钥和算法
        if(ttlMillis>=0){
            long expMillis = nowMillis + ttlMillis;//当前时间+失效时间
            Date date1 = new Date(expMillis);
            builder.setExpiration(date1);//token的失效时间
        }
        return  builder.compact();//生成token
    }

    //效验Token
    public static JWTResult validataJWT(String jwsStr){
        JWTResult result  = new JWTResult();
        Claims claims = null;
        try {
            claims = parseJWT(jwsStr);
            result.setCode(200);
            result.setSuccess(true);
            result.setClaims(claims);
        }catch (ExpiredJwtException e){//token超时异常
            result.setCode(JWT_ERRCODE_EXPRRE);
            result.setSuccess(false);
        }catch (SignatureException e){//效验异常
            result.setSuccess(false);
            result.setCode(JWT_ERRCODE_FAIL);
        }catch (Exception e){//其他异常，JWT提供了很多异常，我这里只写了两个
            result.setSuccess(false);
            result.setCode(JWT_ERRCODE_FAIL);
        }
        return result;
    }

    //解析JWT字符串
    public static Claims parseJWT(String jwt){
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();//获取Token中的PyeLoad数据
    }

    //生成subject信息（subObj是要转化的对象 java对象 -> JSON字符串）
    public static String generalSubject(Object subObj){
        try {
            return MAPPER.writeValueAsString(subObj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }}}