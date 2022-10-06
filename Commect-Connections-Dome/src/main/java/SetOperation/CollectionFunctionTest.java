package SetOperation;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName Commect-Connections-Dome
 * @PackageName SetOperation
 * @Date 2022/9/26 12:37
 * @Version 1.0
 */
public class CollectionFunctionTest {

    static List<String> ary = Arrays.asList(new String[]{"smile","beautiful","yourself","problem","wallpaper"});
    static List<String> ary1 = Arrays.asList(new String[]{"problem","wallpaper"});
    public static void main(String[] args) {

        //1,得到一个镜像集合，不允许修改，否则报错
        System.out.println("镜像集合："+CollectionUtils.unmodifiableCollection(ary).toString());

        //2,统计集合中各元素出现的次数(返回值为Map集合)
        System.out.println("元素出现的次数："+CollectionUtils.getCardinalityMap(ary).toString());

        //3,某元素在集合中出现的次数
        System.out.println("元素出现的次数："+CollectionUtils.cardinality("smile",ary));

        //4,删除集合中的子集合
        System.out.println("删除集合中的子集合："+CollectionUtils.removeAll(ary, ary1));

    }


}
