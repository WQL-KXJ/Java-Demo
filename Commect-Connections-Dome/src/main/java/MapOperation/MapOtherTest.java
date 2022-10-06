package MapOperation;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.MapUtils;



import org.apache.commons.collections.map.*;

import java.util.HashMap;
import java.util.Map;

/*
 * @Author WQL-KXJ
 * @ProjectName Commect-Connections-Dome
 * @PackageName MapOperation
 * @Date 2022/9/26 20:21
 * @Version 1.0
 */
public class MapOtherTest {

    public static void main(String[] args) {
        HashMap hashMap = getHashMap();

        int intValue = MapUtils.getIntValue(hashMap, 1);

        System.out.println(intValue);
    }

    //1，返回一个key与value对调的map
    public static HashMap InvertTest(){
//
//        Map map = getHashMap();
//        // 遍历map,使用MapIterator
//        MapIterator it =
//        while (it.hasNext()) {
//            Object key = it.next();
//            Object value = it.getValue();
//            System.out.println("iterator map key:" + key + ", value: " + value);
//        }
        return null;
    }

    public static HashMap getHashMap(){

        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"smile");
        map.put(2,"dispirited");
        map.put(3,"king");
        return map;
    }

}
