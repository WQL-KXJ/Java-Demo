package MapOperation;

import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.Map;

/*
 * @Author WQL-KXJ
 * @ProjectName Commect-Connections-Dome
 * @PackageName MapOperation
 * @Date 2022/9/26 19:59
 * @Version 1.0
 */
public class MapUtilsTest {


    public static void main(String[] args) {

        HashMap<Integer,String> map = getHashMap();

        //获取值，参1:集合 参2:key值 参3:默认值
        System.out.println(MapUtils.getString(map, 1, "wq"));

    }

    public static HashMap getHashMap(){

        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"smile");
        map.put(2,"dispirited");
        map.put(3,"king");

        return map;
    }

}
