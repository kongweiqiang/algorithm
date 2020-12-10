package com.kwq.algorithm.algorithmics.btree;

import com.kwq.algorithm.model.Node;
import com.kwq.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/12/8
 * @DESC :
 */
public class Tree_431 {
    /**
     * 一颗多叉树序列化为二叉树,同时支持利用二叉树,反序列化(还原)为多叉树
     */
    public static void main(String[] args) {

    }

    /**
     * 将一颗多叉树的某个节点的所有子节点放在该节点在二叉树的位置的左树右边界/右树左边界上
     * @return
     */
    public TreeNode encode(Node root){
        if(root == null) return null;
        TreeNode head = new TreeNode(root.val);
        head.left = en(root.children);
        return  head;
    }

    public Node decode(TreeNode root){

        return  null;
    }

    private TreeNode en(List<Node> children){
        TreeNode head = null;
        TreeNode cur = null;
        //深度优先
        for (Node child : children) {
            TreeNode tmp = new TreeNode(child.val);
            if(head == null){
                head = tmp;
            }else{
                cur.right = tmp;
            }
            cur = tmp;
            cur.left = en(child.children);
        }
        return head;
    }

    private List<Node> de(TreeNode root){
        List<Node> children = new ArrayList<>();
        while(root != null){
            Node cur = new Node(root.val,de(root.left));
            children.add(cur);
            root = root.right;
        }
        return children;
    }
}
