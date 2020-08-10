package com.elles.leetcode;

/**
 *
 */
public class Ltemp {

    //quick sort

    public int kthTop(int[] a,int k){

        int index=a.length-k;
        int left=0;
        int right=a.length-1;
        int target=quickSortSelect(a,left,right,index);
        while (true){
            if(target==index){
                break;
            }else {
                return target<index?quickSortSelect(a,left+1,target,index):quickSortSelect(a,target+1,right,index);
            }
        }



        return a[index];
    }
    public int quickSortSelect(int[] a,int left,int right,int index){
        int i=left+1;
//        int j=right-1;
        int x=a[right];
        for (int j=left;j<right;j++){
            if(a[j]<x){
                swap(a,i++,j);
            }
        }
        swap(a,i,right);

        return i+1;
    }

//    public  int partitionSort(int [] a,int left ,int right){
//
//    }

    public  void swap(int [] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
