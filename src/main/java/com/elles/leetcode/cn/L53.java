package com.elles.leetcode.cn;

import com.elles.common.TreeNode;
import org.testng.annotations.Test;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L53 {

    @Test
    public void testOk() {

        int[] a = new int[]{11, 1, 1, 2, 2, 2, 33, 3, 3, 3, 3, 3, 1, 1, 1, 1, 4, 4};

        int[] a2 = new int[]{-3, -2, -3, -4, -4};

        System.out.println(temp(a));
        System.out.println(temp(a2));
        System.out.println(new Method3().maxSum(a));
        System.out.println(new Method3().maxSum(a2));
    }


    public int temp(int[] temp) {
        if (temp == null || temp.length == 0) {
            return 0;
        }
        int preSum = temp[0];
        int maxSum = preSum;
        for (int i = 1; i < temp.length; i++) {
            preSum = preSum > 0 ? preSum + temp[i] : temp[i];
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }

    public static class Method2 {
        //使用线性树完成构建
        //TODO
        public static int maxSum(int[] temp) {

            return 0;
        }

        public TreeNode buildTree(int start, int end, int sum) {
            if (start == end) {
                return new TreeNode(start, end, sum, null, null);
            }

            int mid = (start + end) / 2;
            TreeNode left = buildTree(start, mid, sum);
            TreeNode right = buildTree(mid + 1, end, sum);


            return new TreeNode(start, end, left.getParentNum() + right.getParentNum(), left, right);
        }


    }


    public static class Method3 {
        //分治发
        public int maxSum(int[] temp) {

            return buildTree(0, temp.length - 1, temp);
        }

        public int buildTree(int start, int end, int[] sum) {
            if (start == end) {
                return sum[start];
            }

            int mid = (start + end) / 2;
            int left = buildTree(start, mid, sum);
            int right = buildTree(mid + 1, end, sum);

            int maxLeftSum = Integer.MIN_VALUE;
            int leftSumTemp = 0;


            for (int i = mid; i >=start; i--) {
                leftSumTemp = leftSumTemp + sum[i];
                maxLeftSum = Math.max(maxLeftSum, leftSumTemp);
            }

            int maxRightSum =sum[ mid + 1];
            int rightSumTemp = 0;


            for (int i = mid + 1; i <= end; i++) {
                rightSumTemp = rightSumTemp + sum[i];
                maxRightSum = Math.max(maxRightSum, rightSumTemp);
            }


            return Math.max(maxRightSum + maxLeftSum, Math.max(left, right));


        }


    }

}
