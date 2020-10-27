package com.kwq.algorithm.algorithmics.btree;

import com.kwq.algorithm.model.TreeNode;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/12
 * @DESC :
 */
public class MergeTree {


    /** 617. 合并二叉树
     * @num 617. 合并二叉树
     * @param t1
     * @param t2
     * @desc 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     *       需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }

    /** BST插入元素
     * @num 701.二叉搜索树中的插入操作
     * @desc 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。返回插入后二叉搜索树的根节点。输入数据保证，新值和原始二叉搜索树中的任意节点值都不同
     * @param root
     * @param val
     * @return
     */
   public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;
   }

    public static void main(String[] args) {
        MergeTree mergeTree = new MergeTree();
        TreeNode root4 = new TreeNode(4);
        TreeNode root2 = new TreeNode(2);
        TreeNode root1 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        TreeNode root7 = new TreeNode(7);
        root4.left = root2;
        root4.right = root7;
        root2.left = root1;
        root2.right = root3;
        //BST插入新元素
        TreeNode treeNode = mergeTree.insertIntoBST(root4, 5);
        System.out.println(treeNode);
    }

}
