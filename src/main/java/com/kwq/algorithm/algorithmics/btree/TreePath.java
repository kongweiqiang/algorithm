package com.kwq.algorithm.algorithmics.btree;

import com.kwq.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/12
 * @DESC :
 */
public class TreePath {

    /** 112. 路径总和
     * @num 112
     * @desc 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     * @param root
     * @param sum
     * @return
     */
    private boolean hasPathSum(TreeNode root,int sum){
        if(root == null) return false;
        if(sum-root.val ==0 && root.right == null && root.left == null) return true;
        boolean left = false,right = false;
        if(root.left != null) {
            left = hasPathSum(root.left, sum - root.val);
        }
        if(root.right != null) {
            right = hasPathSum(root.right, sum - root.val);
        }
        return left || right;
    }

    /** 113. 路径总和
     * @num 113
     * @desc 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     * @param root
     * @param sum
     * @return
     */
    private TreeNode root0 = null;
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private List<Integer> record = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        root0 = root;
        findPath(root,sum,record);
        return result;
    }

    private void findPath(TreeNode root,int sum,List<Integer> record){
        if(root == null) return;
        ArrayList<Integer> sub = new ArrayList<>(record);
        sub.add(root.val);
        if(sum-root.val == 0 && root.right == null && root.left == null){
            result.add(new ArrayList<Integer>(sub));
            return;
        }
        findPath(root.left, sum - root.val,sub);
        findPath(root.right, sum - root.val,sub);
    }

    /*private void findPath(TreeNode root,int sum,List<Integer> record){
        if(root == null) return;
        record.add(root.val);
        if(root.right == null && root.left == null){
            if(sum-root.val == 0) {
                result.add(new ArrayList<Integer>(record));
                record.clear();
                record.add(root0.val);
                return;
            }else {
                record.remove(record.size()-1);
            }
        }
        findPath(root.left, sum - root.val,record);
        findPath(root.right, sum - root.val,record);
    }*/

    public static void main(String[] args) {
        TreeNode root5 = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);
        TreeNode root8 = new TreeNode(8);
        TreeNode root11 = new TreeNode(11);
        TreeNode root7 = new TreeNode(7);
        TreeNode root2 = new TreeNode(2);
        TreeNode root13 = new TreeNode(13);
        TreeNode root0 = new TreeNode(4);
        TreeNode root1 = new TreeNode(1);
        TreeNode root50 = new TreeNode(5);
        root5.left=root4;
        root5.right=root8;
        root4.left = root11;
        root11.left = root7;
        root11.right = root2;
        root8.left = root13;
        root8.right = root0;
        root0.right = root1;
        root0.left = root50;
        TreePath path = new TreePath();
        /*boolean flag = path.hasPathSum(root5, 22);
        System.out.println(flag);*/
        List<List<Integer>> list = path.pathSum(root5, 22);
        System.out.println(list.size());
    }


}
