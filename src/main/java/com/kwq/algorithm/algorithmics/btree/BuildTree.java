package com.kwq.algorithm.algorithmics.btree;

import com.kwq.algorithm.model.TreeNode;

import java.util.HashMap;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/10
 * @DESC :
 */
public class BuildTree {

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        int [] max = {3,2,1,6,0,5};
        TreeNode root = buildTree.buildTree(preorder, inorder);
        TreeNode root1 = buildTree.buildTrees(preorder, inorder);
        System.out.println(root);
        System.out.println(root1);
        TreeNode treeNode = buildTree.constructMaximumBinaryTree(max);
        System.out.println(treeNode);
    }

    /**  剑指 Offer 07. 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * eg:
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int [] preorder, int [] inorder){
        if (inorder.length == 0 || preorder.length == 0) return null;
        HashMap <Integer,Integer> dict = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            dict.put(inorder[i],i);
        }
        return traversal(dict, preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode traversal(HashMap <Integer,Integer> dict ,int [] preorder,int preStart,int preEnd,int [] inorder,int inStart,int inEnd){
        //临近点
        if(preEnd == preStart) return null;
        //找到割接点:中序的割接点-->中序切割值:index - inStart 是中序数组左区间大小切割值
        int index = dict.get(preorder[preStart]);
        //分隔数组
        TreeNode root = new TreeNode(preorder[preStart]);
        //叶子节点返回
        if (preEnd - preStart == 1) return root;
        //index - inStart 是中序数组左区间大小范围值
        //左区间值给left:    前序左区间 中序左区间
        root.left =  traversal(dict, preorder, preStart + 1, preStart + 1 + (index - inStart),inorder, inStart, index);
        //右区间值给right:   前序右区间 中序右区间
        root.right = traversal(dict, preorder, preStart + 1 + (index - inStart), preEnd,inorder, index + 1, inEnd);
        return root;
    }

    /**  剑指 Offer 07. 重建二叉树
     */
    int preindex = 0;
    int inindex = 0;
    public TreeNode buildTrees(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, null);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, TreeNode finish){
        if(preindex == preorder.length || (finish != null && inorder[inindex] == finish.val)) return null;
        TreeNode root = new TreeNode(preorder[preindex++]);
        root.left = dfs(preorder, inorder, root);
        inindex ++;
        root.right = dfs(preorder, inorder, finish);
        return root;
    }

    /**
     * @num 654.最大二叉树
     * @desc  给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
     *
     * 二叉树的根是数组中的最大元素。
     * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
     * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
     * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
     */
    public TreeNode constructMaximumBinaryTree(int [] nums){
        TreeNode root = doBuildMaxTree(nums, 0, nums.length);
        return root;
    }

    private TreeNode doBuildMaxTree(int [] nums,int pre,int post){
        if(pre == post) return null;
        //分隔点
        int maxValueIndex = pre;
        for (int i = pre; i < post; i++) {
            if (nums[i] > nums[maxValueIndex]) {
                maxValueIndex = i;
            }
        }
        //最大值构建节点
        TreeNode root = new TreeNode(nums[maxValueIndex]);
        //分隔线
        root.left = doBuildMaxTree(nums,pre,maxValueIndex);
        root.right = doBuildMaxTree(nums,maxValueIndex + 1,post);
        return root;
    }

}
