package com.kwq.algorithm.algorithmics.btree;

import com.kwq.algorithm.model.BTree;
import com.kwq.algorithm.model.TreeNode;

import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/7/13
 * @DESC :
 */
public class BTreeSearch {
    //前序遍历
    public List<BTree> preSearch(BTree bTree, List<BTree> list){
        if(bTree== null){
            return null;
        }
        list.add(bTree);
        System.out.println(bTree.getData());
        if(bTree.hasLeft()) {
            preSearch(bTree.getLeft(),list);
        }
        if(bTree.hasRight()){
            preSearch(bTree.getRight(),list);
        }
        return list;
    }
    //中序遍历
    public List<BTree> midSearch(BTree bTree, List<BTree> list){
        if(bTree== null){
            return null;
        }
        if(bTree.hasLeft()) {
            midSearch(bTree.getLeft(),list);
        }
        list.add(bTree);
        System.out.println(bTree.getData());
        if(bTree.hasRight()) {
            midSearch(bTree.getRight(),list);
        }
        return list;
    }
    //后序遍历
    public List<BTree> postSearch(BTree bTree, List<BTree> list){
        if(bTree== null){
            return null;
        }
        list.add(bTree);
        if(bTree.hasLeft()) {
            postSearch(bTree.getLeft(),list);
        }
        if(bTree.hasRight()) {
            postSearch(bTree.getRight(),list);
        }
        System.out.println(bTree.getData());
        return list;
    }



    //最大深度
    public int maxDepth(BTree bTree){
        if(bTree == null) {
            return 0;
        }
        int leftCount = maxDepth(bTree.getLeft());
        int rightCount = maxDepth(bTree.getRight());
        return Math.max(leftCount,rightCount)+1;
    }

    //最小深度
    public int minDepth(BTree bTree){
        if(bTree == null) {
            return 0;
        }
        if(!bTree.hasLeft() && !bTree.hasRight()) {
            return 1;
        }
        int leftCount = minDepth(bTree.getLeft());
        System.out.println(bTree.getData()+":"+leftCount);
        int rightCount = minDepth(bTree.getRight());
        if(!(bTree.hasLeft() || bTree.hasRight())){
            return Math.max(leftCount,rightCount)+1;
        }
        return Math.min(leftCount,rightCount)+1;
    }

    public int nodeCount(BTree bTree){
        if(bTree == null){
            return 0;
        }
        if(!bTree.hasLeft() && !bTree.hasRight()){
            return 1;
        }
        int leftNodeCount = nodeCount(bTree.getLeft());
        int rightNodeCount = nodeCount(bTree.getRight());
        return leftNodeCount+rightNodeCount+1;
    }

    /**
     * @number 687. 最长同值路径
     * @desc 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点
     * @param tree
     * @return
     */
    public int count = 0;
    public int longestUnivaluePath(BTree tree){
        if(null == tree){
            return 0;
        }
        int leftPath = 0,rightPath = 0;
        int left = longestUnivaluePath(tree.getLeft());
        if(tree.hasLeft() && tree.getData().equals(tree.getLeft().getData())){
            leftPath = left + 1;
        }
        int right = longestUnivaluePath(tree.getRight());
        if(tree.hasRight() && tree.getData().equals(tree.getRight().getData())){
            rightPath = right + 1;
        }
        count = Math.max(count,leftPath + rightPath);
        return Math.max(leftPath,rightPath);
    }

    /**
     *513.找树左下角的值
     *
     * 给定一个二叉树，在树的最后一行找到最左边的值
     */
    public int maxDepth;
    public BTree left;
    public void tranval(BTree root, int depth){
        if(!root.hasLeft() && !root.hasRight()){
            if(depth > maxDepth) {
                maxDepth = depth;
                left = root;
            }
            return;
        }
        if(root.hasLeft()){
            tranval(root.getLeft(),depth++);
        }
        if(root.hasRight()){
            tranval(root.getRight(),depth++);
        }
    }


    /**
     * @number 783 二叉搜索树节点最小距离
     * @desc 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值
     * @param root
     * @idea 二叉树中序遍历排序后递增有序,递归计算相邻差值
     * @return
     */
    public BTree pre = null;
    public int min = Integer.MAX_VALUE;
    //中序遍历
    public int  minDiffInBST(BTree root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }
        minDiffInBST(root.getLeft());
        System.out.println(root.getData());
        //从第二个节点开始算
        if(pre != null){
            min = Math.min(parse(root.getData()) - parse(pre.getData()),min);
        }
        //记录上一个节点
        pre = root;
        minDiffInBST(root.getRight());
        return min;
    }

    public int parse(String s){
        return s==null ? 0:Integer.parseInt(s);
    }

    /** 530. 二叉搜索树的最小绝对差
     * @num 530 任意两节点差的绝对值的最小值
     * @desc 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     * 输入：
     *
     *    1
     *     \
     *      3
     *     /
     *    2
     *
     * 输出：
     * 1
     *
     * 解释：
     * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     */
    private int result = Integer.MAX_VALUE;
    private TreeNode preNode = new TreeNode(result);
    public int getMinimumDifference(TreeNode root){
        if(root == null) return result;
        getMinimumDifference(root.left);
        result = Math.min(result, Math.abs(preNode.val-root.val));
        preNode = root;
        getMinimumDifference(root.right);
        return result;
    }

    public static void main(String[] args) {
        BTreeSearch bTreeSearch = new BTreeSearch();
        TreeNode root = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        root.left = null;
        root.right = treeNode3;
        treeNode3.left = treeNode2;
        int minimumDifference = bTreeSearch.getMinimumDifference(root);
        System.out.println(minimumDifference);
    }

}
