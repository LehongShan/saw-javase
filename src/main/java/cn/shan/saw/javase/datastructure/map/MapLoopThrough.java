package cn.shan.saw.javase.datastructure.map;

import org.junit.Test;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by shanlehong on 2017/4/1.
 */
public class MapLoopThrough {
    Map<String,String> map;
    @Test
    public void testMapLoop(){
        Init();

        loop1(map);
        loop2(map);
        loop3(map);

    }

    void Init(){
        map = new HashMap<>();
        map.put("slh","shanlehong");
        map.put("hjx","huangjianxiong");
        map.put("lb","libin");

    }

    void loop1(Map<String,String> mapParam){
        if (mapParam ==null){
            System.err.print("参数为空");
            return;
        }
        System.out.println("===loop1开始====");
        for (String key:mapParam.keySet()){

            System.out.println("mapParam-->key:"+key+"\nmapParam-->value:"+mapParam.get(key));

        }
        System.out.println("===loop1结束====");
    }

    void loop2(Map<String,String> mapParam){
        if (mapParam ==null){
            System.err.print("参数为空");
            return;
        }
        System.out.println("===loop2开始====");
        for (Map.Entry entry :mapParam.entrySet()){

            System.out.println("mapParam-->key:"+entry.getKey()+"\nmapParam-->value:"+entry.getValue());

        }
        System.out.println("===loop2结束====");
    }

    void loop3(Map<String,String> mapParam){
        if (mapParam ==null){
            System.err.print("参数为空");
            return;
        }
        System.out.println("===loop3开始====");

        Iterator<Map.Entry<String,String>> it = mapParam.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            System.out.println("mapParam-->key:"+entry.getKey()+"\nmapParam-->value:"+entry.getValue());

        }
        System.out.println("===loop3结束====");
    }


}
