package com.elles.leetcode.cn;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

 注意：

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/assign-cookies
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class L455 {


    public int findContentChildren(int[] g, int[] s) {
        if(g==null||s==null){
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        while(i<g.length-1&&j<s.length-1){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }

        return i;
    }
}
