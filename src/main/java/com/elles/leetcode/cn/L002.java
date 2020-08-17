package com.elles.leetcode.cn;


import com.elles.common.ListNode;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 */
public class L002 {

    @Test
    public void testOk(){


    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode leftNode=l1;
        ListNode rightNode=l2;
        ListNode current=new ListNode(0);
        int carry=0;
        while(leftNode!=null||rightNode!=null){

            int intLeft=leftNode==null?0:leftNode.getVal();
            int intRight=rightNode==null?0:rightNode.getVal();
            int sum=intLeft+intRight+carry;
            carry=sum/10;
            int currentVal=sum%10;
            current.setVal(currentVal);
            current=current.getNext();
            leftNode=leftNode.getNext()!=null?leftNode.getNext():null;
            rightNode=rightNode.getNext()!=null?rightNode.getNext():null;

        }

        if(carry!=0){
            current.getNext().setVal(carry);
        }


        return  current;
    }


}
