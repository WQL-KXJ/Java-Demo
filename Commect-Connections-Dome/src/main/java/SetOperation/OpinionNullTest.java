package SetOperation;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName Commect-Connections-Dome
 * @PackageName SetOperation
 * @Date 2022/9/26 10:44
 * @Version 1.0
 */
public class OpinionNullTest {

    static List<String> nullary = Arrays.asList(new String[]{null});
    static List<String> ary = Arrays.asList(new String[]{null,"smile","beautiful","yourself","problem","wallpaper"});

    public static void main(String[] args) {
        System.out.println("是否为空集合"+isEmptyTest());
        System.out.println("集合是否不为空"+isNotEmptyTest());
        System.out.println("集合值是否相等"+isEqualCollectionTest());
        System.out.println("两个集合是否有相同元素："+ContainsAnyTest());
        System.out.println("集合1是否为集合2的子集："+isSubCollectionTest());

    }
    //1,判断集合是否为空
    public static boolean isEmptyTest(){
        return CollectionUtils.isEmpty(nullary);
    }

    //2,判断集合是否不为空
    public static boolean isNotEmptyTest(){
        return CollectionUtils.isNotEmpty(ary);
    }

    //3,比较两个集合的值是否相等
    public static boolean isEqualCollectionTest(){
        return CollectionUtils.isEqualCollection(ary,ary);
    }

    //4,判断两个集合是否有相同元素
    public static boolean ContainsAnyTest(){
        return CollectionUtils.containsAny(ary,nullary);
    }

    //5,参数1集合是否为参数2集合的子集
    public static boolean isSubCollectionTest(){
        return CollectionUtils.isSubCollection(ary,nullary);
    }
}
