package com.elles.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayAndListConvert {

    public void testOk(){
        int [] a=new int[]{1,2,4,5,7};

        //int [] 转List<Integer>
        List<Integer> integerList=Arrays.stream(a).boxed().collect(Collectors.toList());

        //int[] 转 Integer[]
        Integer [] integers=Arrays.stream(a).boxed().toArray(Integer[]::new);

        //List<Integer>  转 Integer[]
        integers=integerList.toArray(new Integer[0]);

        //List<Integer> 转 int[]
        a=integerList.stream().mapToInt(Integer::valueOf).toArray();

        // Integer [] 转 List<Integer>
        integerList=Arrays.asList(integers);
        //Integer [] 转 int[]

        a=Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
    }
}
