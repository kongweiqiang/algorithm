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
        bTree.setData("90");
        BTree bTree1 = new BTree();
        bTree1.setData("69");
        BTree bTree2 = null;
        //bTree2.setData("69");
        BTree bTree3 = new BTree();
        bTree3.setData("49");
        BTree bTree4 = new BTree();
        bTree4.setData("89");
        BTree bTree5 = null;
        //bTree5.setData("89");
        BTree bTree6 = null;
        //bTree6.setData("1");
        BTree bTree7 = new BTree();
        bTree7.setData("52");
        bTree.setLeft(bTree1);
        bTree.setRight(bTree2);
        bTree1.setLeft(bTree3);
        bTree1.setRight(bTree4);
//        bTree3.setLeft(bTree5);
//        bTree3.setRight(bTree6);
        bTree3.setRight(bTree7);
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
    }
}
