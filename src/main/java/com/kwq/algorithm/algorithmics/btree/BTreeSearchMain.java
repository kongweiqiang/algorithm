package com.kwq.algorithm.algorithmics.btree;

import com.kwq.algorithm.model.BTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/7/13
 * @DESC :
 */
public class BTreeSearchMain {

    public static void main(String[] args) {
        BTree bTree = new BTree();
        bTree.setData("1");
        BTree bTree1 = new BTree();
        bTree1.setData("2");
        BTree bTree2 = new BTree();
        bTree2.setData("3");
        BTree bTree3 = new BTree();
        bTree3.setData("4");
        BTree bTree4 = new BTree();
        bTree4.setData("5");
        BTree bTree5 = new BTree();
        bTree5.setData("6");
        BTree bTree6 = new BTree();
        bTree6.setData("7");
        bTree.setLeft(bTree1);
        bTree.setRight(bTree2);
        bTree1.setLeft(bTree3);
        bTree2.setLeft(bTree4);
        bTree3.setRight(bTree5);
        bTree4.setLeft(bTree6);
        BTreeSearch bTreeSearch = new BTreeSearch();
        ArrayList<BTree> pre = new ArrayList<>();
        ArrayList<BTree> mid = new ArrayList<>();
        ArrayList<BTree> post = new ArrayList<>();
        System.out.println("前序遍历:");
        List<BTree> preSearch = bTreeSearch.preSearch(bTree, pre);
        System.out.println("-----:"+preSearch.size()+"----:"+preSearch);
        System.out.println("中序遍历:");
        List<BTree> midSearch = bTreeSearch.midSearch(bTree, mid);
        System.out.println("-----:"+midSearch.size()+"----:"+midSearch);
        System.out.println("后序遍历:");
        List<BTree> postSearch = bTreeSearch.postSearch(bTree, post);
        System.out.println("-----:"+postSearch.size()+"----:"+postSearch);
        int maxDepth = bTreeSearch.minDepth(bTree);
        System.out.println("maxDepth:"+maxDepth);
        /*
        int count = bTreeSearch.longestUnivaluePath(bTree);
        */
        int min = bTreeSearch.minDiffInBST(bTree);
        System.out.println(min+"----"+bTreeSearch.min);

        // 求左侧路径最大值
        bTreeSearch.tranval(bTree,bTreeSearch.maxDepth);
        System.out.println("max left path value : "+bTreeSearch.left.getData());
    }
}
