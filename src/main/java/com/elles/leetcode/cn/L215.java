package com.elles.leetcode.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 */
public class L215 {

    //quick sort

    @Test
    public void testOk() {
//        int[] temp = new int[]{3, 2, 1, 5, 6, 4};
        int [] temp =new int []{3,2,3,1,2,4,5,5,6};// [1,2,2,3,3,4,5,5,6]

        //R1: left=0;right=5; index=4 ,target:3  result:[3,2,1,4,6,5]
        //R2: left=4;right=5;index=4,target  result:[3,2,1,4,5,6]

        int left = 0;
        int right = temp.length - 1;
        int index = 1;

        System.out.println(kthTop(temp, left, right, temp.length - index));
        System.out.println(sort(temp, index));

        System.out.println(heapSort(temp, index));


    }

    public int sort(int a[],int target){
        Arrays.sort(a);

        return a[a.length-target];
    }

    public int kthTop(int[] a, int left, int right, int index) {


        int target = quickSortSelect(a, left, right);

        if (target == index) {
            return a[index];
        } else {
            return target < index ? kthTop(a, target+1, right, index) : kthTop(a, left, right-1, index);
        }
    }


    public int quickSortSelect(int[] a, int left, int right) {
        int i = left;
//        int j=right-1;
        int x = a[right];//6
        for (int j = left; j < right; j++) {
            if (a[j] < x) {
                swap(a, i++, j);
            }
        }
        swap(a, i, right);

        return i ;
    }


    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    //*堆排序/java实现

    public int heapSort(int []a ,int k){
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue()>o2.intValue()?1:-1;//这里构建小堆顶，需要注意返回值
            }
        });
        for (int tempInt:a){
            priorityQueue.add(tempInt);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }

        return  priorityQueue.poll();
    }
}
