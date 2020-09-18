package com.elles.common;


/**
 * 线性树，数据结构
 *
 */
public class TreeNode {

    private int parentNum;
    private  int left;
    private  int right;
    private  TreeNode leftTree;

    private  TreeNode rightTree;

    public  TreeNode(int left,int right ,int parentNum,TreeNode leftTree,TreeNode rightTree){
        this.left=left;
        this.right=right;
        this.parentNum=parentNum;
        this.leftTree=leftTree;
        this.rightTree=rightTree;
    }

    public  TreeNode(){

    }


    public int getParentNum() {
        return parentNum;
    }

    public void setParentNum(int parentNum) {
        this.parentNum = parentNum;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public TreeNode getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(TreeNode leftTree) {
        this.leftTree = leftTree;
    }

    public TreeNode getRightTree() {
        return rightTree;
    }

    public void setRightTree(TreeNode rightTree) {
        this.rightTree = rightTree;
    }
}
