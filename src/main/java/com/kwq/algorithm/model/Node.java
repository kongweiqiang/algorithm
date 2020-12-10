package com.kwq.algorithm.model;

import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/12/8
 * @DESC : 多叉树/节点
 */
public class Node {

    public int val;

    public List<Node> children;

    public Node(){}

    public Node(int val){
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
