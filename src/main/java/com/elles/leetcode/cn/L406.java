package com.elles.leetcode.cn;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L406 {

    @Test
    public void testOk() {

        int [][] temp=new int[][]{{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}};

        System.out.println(JSONObject.toJSON(reconstructQueue(temp)));

    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length==0 || people[0].length == 0 ) {
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int []> result=new LinkedList<>();
        for(int[] p:people){
            result.add(p[1],p);
        }

        return result.toArray(new int[result.size()][]);
    }
}