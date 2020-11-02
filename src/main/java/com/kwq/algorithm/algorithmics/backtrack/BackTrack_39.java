package com.kwq.algorithm.algorithmics.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/2
 * @DESC :
 */
public class BackTrack_39 {

    /** 39.组合总和
     * @desc 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *       candidates 中的数字可以无限制重复被选取
     * @eq  输入：         candidates = [2,3,5], target = 8
     *      所求解集为：   [[2,2,2,2],[2,3,3],[3,5]]
     * @param candidates 数组
     * @param target 总和
     * @return 组合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        back(candidates,target,0,new ArrayList<Integer>(),result);
        return result;
    }

    /**
     * 递归回溯函数
     * @param candidates 入参集合
     * @param target 入参值
     * @param index 位置 : 从这个位置往后开始查找,避免出现 235==523 重复集合,让元素在比他位置靠后(包括自己)的元素集合中查找进行组合
     * @param item 单项结果集
     * @param result 结果集集合
     */
    private void back(int[] candidates, int target, int index, List<Integer> item, List<List<Integer>> result){
        if(target < 0 || index > candidates.length) return;
        if(target == 0){
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            item.add(candidates[i]);
            //i 只做位置定位 从i位置开始往后查找 不是回溯
            back(candidates,target - candidates[i],i,item,result);//回溯:target
            item.remove(item.size()-1);//回溯:元素项集
        }
    }

    public static void main(String[] args) {
        int [] candidates = {2,3,5};
        int target = 8;
        BackTrack_39 back = new BackTrack_39();
        List<List<Integer>> lists = back.combinationSum(candidates, target);
        System.out.println(lists);
    }
}
