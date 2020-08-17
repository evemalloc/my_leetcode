package com.elles.leetcode.cn;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 *出现频次 最多的K个元素
 *
 */
public class L347 {

    @Test
    public  void testOk() {
        int [] a=new int[]{11,1,1,2,2,2,33,3,3,3,3,3,1,1,1,1,4,4};
        System.out.println(JSONObject.toJSON(Method2.topFrequency( a ,3)));

        System.out.println(JSONObject.toJSON(topKFrequency2( a ,3)));
    }

    //桶排序
    public int[]   topKFrequency2(int [] a,int k){
        List<Integer> result=topKFrequency(a,k);
        int [] tempInt=new int[result.size()];
        int i=0;
        for(Integer integer:result){
            tempInt[i++]=integer.intValue();
        }

        return tempInt;
    }

    public List<Integer> topKFrequency(int [] a,int k){
        if(k<=0){
            return null;
        }
        Map<Integer,Integer> tempMap=new HashMap<Integer,Integer>();
        for(int intTemp:a){
            tempMap.put(intTemp,tempMap.getOrDefault(intTemp,0)+1);
        }
        List<Integer>[]  listArray=new ArrayList[a.length+1];
        for(int temp:tempMap.keySet()){
            int frequency=tempMap.get(temp);
            if(listArray[frequency]==null){
                listArray[frequency]=new ArrayList<>();
            }
            listArray[frequency].add(temp);
        }
        List result=new ArrayList();
        for(int i=listArray.length-1;i>=0&&result.size()<k;i--){
            if(listArray[i]==null){
                continue;
            }
            if(listArray[i].size()<k-result.size()){
                result.addAll(listArray[i]);
            }else {
                result.addAll(listArray[i].subList(0,k-result.size()));
            }
        }

        return  result;
    }


    public static   class  Method2{
        //堆排序，维护一个K 大小的 小堆
        public static int[] topFrequency(int [] a,int k){
            Map<Integer,Integer>  tempMap=new HashMap<>();
            for(int tempInt:a){
                tempMap.put(tempInt,tempMap.getOrDefault(tempInt,0)+1);
            }
            //堆顶为0元素
            PriorityQueue<Integer> priorityQueue=new PriorityQueue(k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return tempMap.get(o1.intValue())>tempMap.get(o2.intValue())?1:-1;
                }
            });
            List<Integer> result=new ArrayList<>();
            for(Integer key:tempMap.keySet()){

                if(priorityQueue.size()<k){
                    priorityQueue.add(key);
                }else {
                    Integer frequency=tempMap.get(key);
                    Integer top=tempMap.get(priorityQueue.peek());
                    if(frequency>top){
                        priorityQueue.remove();
                        priorityQueue.add(key);
                    }
                }
            }
            while(!priorityQueue.isEmpty()){
                result.add(priorityQueue.poll());
            }
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }


    }
}