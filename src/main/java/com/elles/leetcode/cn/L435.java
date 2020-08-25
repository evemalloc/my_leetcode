package com.elles.leetcode.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

 注意:

 可以认为区间的终点总是大于它的起点。
 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 输入: [ [1,2], [2,3], [3,4], [1,3] ]

 输出: 1

 解释: 移除 [1,3] 后，剩下的区间没有重叠。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 实际上是找出重叠的个数，然后减去，得出不重叠的个数
 */
public class L435 {

    @Test
    public void testOk() {
        int[] [] tempArray=new int[][]{{1,2}, {2,3}, {3,4}, {1,3} };
        int[] [] tempArray2=new int[][]{{1,2}, {1,2},{1,3} };

        System.out.println(eraseOverlapIntervals(tempArray));

        System.out.println(eraseOverlapIntervals(tempArray2));

    }


    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[1]-o2[1];
            }
        });
        int cnt=0;
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int temp=intervals[i][0];
            if(temp<end){
                cnt++;
            }
            end=intervals[i][1];
        }


        return cnt;
    }
}