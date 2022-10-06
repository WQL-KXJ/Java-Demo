package SetOperation;


import org.apache.commons.collections.CollectionUtils;

import javax.security.auth.Subject;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName Commect-Connections-Dome
 * @PackageName SetOperation
 * @Date 2022/9/25 21:04
 * @Version 1.0
 */
public class SetOperationTest {

     static List<String> newary = Arrays.asList(new String[]{"smile","beautiful","ways","problem","wallpaper"});
     static List<String> oldary = Arrays.asList(new String[]{"smile","beautiful","yourself","problem","wallpaper"});

    public static void main(String[] args) {

        //1,并集
        System.out.println("并集："+UnionTest().toString());

        //2,交集
        System.out.println("交集："+IntersectionText().toString());

        //3,补集
        System.out.println("补集："+DisjunctionText().toString());

        //3,补集
        System.out.println("差集："+ SubsractText().toString());
    }

    //1， 交集
    public static List<String> UnionTest(){

       return (List<String>) CollectionUtils.union(newary, oldary);
    }

    //1， 交集
    public static List<String> IntersectionText(){

        return (List<String>) CollectionUtils.intersection(newary, oldary);
    }

    //3，补集
    public static List<String> DisjunctionText(){

        return (List<String>) CollectionUtils.disjunction(newary, oldary);
    }

    //4，差集（newary - oldary)
    public static List<String> SubsractText(){

        return (List<String>) CollectionUtils.subtract(newary, oldary);
    }
}
