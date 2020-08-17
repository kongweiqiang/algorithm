package com.kwq.algorithm.algorithmics.btree;

import com.kwq.algorithm.model.TreeNode;

import javax.net.ssl.HostnameVerifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/8/17
 * @DESC :
 */
public class TreeAlgorithm {

    /**
     * @number 110. 平衡二叉树
     * @desc 给定一个二叉树，判断它是否是高度平衡的二叉树
     * @dinf 一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        int max = max(root);
        return max != -1;
    }

    private int max(TreeNode root){
        if (null==root) {
            return 0;
        }
        int left = max(root.left);
        //当左右子树高度差为-1,则非平衡树,返回-1
        if (left == -1) return -1;
        int right = max(root.right);
        //当左右子树高度差为-1,则非平衡树,返回-1
        if (right == -1) return -1;
        //左右子树当前最大值+1,计算树深度
        return Math.abs(left - right)<= 1 ? Math.max(left,right) + 1 : -1 ;
    }

    /**
     * @number 17.12. BiNode
     * @desc 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改
     * @param root
     * @return
     */
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode prev = new TreeNode(-1);
        convert(root, prev);
        return prev.right;
    }

    private TreeNode convert(TreeNode root,TreeNode prev){
        if(null != root) {
            prev = convert(root.left, prev);
            root.left = null;
            prev.right = root;
            prev = root;
            prev = convert(root.right, prev);
        }
        return prev;
    }

    /**
     * @number 08.06. 汉诺塔问题
     * @param A
     * @param B
     * @param C
     * @eg input:A = [2, 1, 0], B = [], C = []    output:C = [2, 1, 0]
     */
    public void hanota(List<Integer> a, List<Integer> b, List<Integer> c) {
        move(a.size(),a,b,c);
    }

    private void move(int n,List<Integer> a, List<Integer> b, List<Integer> c){
        if(n == 1){
            c.add(a.remove(a.size()-1));
            return ;
        }
        move(n-1, a,c,b);
        c.add(a.remove(a.size()-1));
        move(n-1,b,a,c);
    }

    public static void main(String[] args) {
        TreeAlgorithm algorithm = new TreeAlgorithm();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(0);
        root.right.right = new TreeNode(6);
        /*TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(3);
        root1.left.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(2);*/
        //boolean balance = algorithm.isBalanced(root);
        //System.out.println(balance);
        /*boolean balance1 = algorithm.isBalanced(root1);
        System.out.println(balance1);*/
        /*boolean balance2 = algorithm.isBalanced(root2);
        System.out.println(balance2);*/
        /*TreeNode treeNode = algorithm.convertBiNode(root);
        System.out.println(treeNode);*/
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(2);
        a.add(1);
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        algorithm.hanota(a,b,c);
        System.out.println("=");
    }
}
