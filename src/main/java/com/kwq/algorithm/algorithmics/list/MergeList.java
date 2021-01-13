package com.kwq.algorithm.algorithmics.list;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @auther : kongweiqiang
 * @DATE : 2021/1/4
 * @DESC : k个有序数组按序合并
 */
public class MergeList {

    /**
     * k个有序数组按序合并
     * @param list
     * @return
     */
    public List<Integer> mergeList(List<List<Integer>> list){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (List<Integer> itemList : list) {
            for (Integer item : itemList) {
                priorityQueue.offer(item);
            }
        }
        List<Integer> result = new ArrayList<>();
        priorityQueue.stream().forEach(e -> result.add(e));
        return result;
    }

    public static void main(String[] args) {
        MergeList main = new MergeList();
        List<List<Integer>> list = new ArrayList<>();
        main.load(list);
        List<Integer> result = main.mergeList(list);
        System.out.println(result.toString());
    }

    public void load(List<List<Integer>> list){
        for (int i = 1;i < 10; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 100;j < 150; j++) {
                item.add(i*j);
            }
            list.add(item);
        }
    }

}
