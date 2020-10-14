package com.kwq.algorithm.algorithmics.btree;

import com.kwq.algorithm.model.TreeNode;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/14
 * @DESC :
 */
public class Tree_98 {

    public static void main(String[] args) {
        Tree_98 tree = new Tree_98();
        TreeNode root10 = new TreeNode(10);
        TreeNode root5 = new TreeNode(5);
        TreeNode root15 = new TreeNode(15);
        TreeNode root6 = new TreeNode(6);
        TreeNode root20 = new TreeNode(20);
        root10.left = root5;
        root10.right = root15;
        root15.left = root6;
        root15.right = root20;
        System.out.println(tree.isValidBST(root10));
    }

    /**  98. 验证二叉搜索树
     * @num 98. 验证二叉搜索树
     *
     * @desc 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * 假设一个二叉搜索树具有如下特征：
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * @case
     *  true:[2,1,3]
     *  false: [5,1,4,null,null,3,6]
     *  false: [10,5,15,null,null,6,20]
     */
    //以pre节点保存上一个中序遍历到的满足搜索二叉树性质的节点值
    private TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        //空节点也是二叉搜索树 null可以进入递归
        if(root == null) return true;
        //中序遍历:二叉搜索树中序自增的特性
        boolean left = isValidBST(root.left);
        //单层递归逻辑:以pre节点保存上一个节点值
        //以pre节点保存上一个中序遍历到的满足搜索二叉树性质的节点值
        if(pre != null && pre.val >= root.val) {//不满足性质直接返回
            return false;
        }else{//上一个节点比当前节点小则满足性质,记录更新pre
            pre = root;
        }
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
