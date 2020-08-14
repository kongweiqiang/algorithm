package com.kwq.algorithm.model;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/7/13
 * @DESC :
 */
public class BTree {
    String data;
    BTree left;
    BTree right;
    BTree parent;

    public BTree(String data, BTree left, BTree right, BTree parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public BTree(){};

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BTree getLeft() {
        return left;
    }

    public void setLeft(BTree left) {
        this.left = left;
    }

    public BTree getRight() {
        return right;
    }

    public void setRight(BTree right) {
        this.right = right;
    }

    public BTree getParent() {
        return parent;
    }

    public void setParent(BTree parent) {
        this.parent = parent;
    }

    public boolean hasLeft(){
        return this.getLeft()!=null;
    }

    public boolean hasRight(){
        return this.getRight()!=null;
    }

}
