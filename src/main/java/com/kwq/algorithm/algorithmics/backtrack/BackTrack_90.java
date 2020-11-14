package com.kwq.algorithm.algorithmics.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/13
 * @DESC :
 */
public class BackTrack_90 {

    public List<List<Integer>> subsetsWithDup(int [] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> result1 = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        List<Integer> item = new ArrayList<>();
        //排序保证相同的元素必然相邻从而达到同层去重的目的
        Arrays.sort(nums);
        back(nums,0,item,result);
        item.clear();
        backs(nums,0,new boolean[nums.length],item,result1);
        System.out.println(result1);
        return result;
    }

    /**
     * 子集
     * @num 90
     * @desc 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * @说明 解集不能包含重复的子集
     * @示例
     *   输入: [1,2,2]
     *   输出:
     *   [
     *     [2],
     *     [1],
     *     [1,2,2],
     *     [2,2],
     *     [1,2],
     *     []
     *   ]
     * @param nums 数组
     * @param index 索引开始位置
     * @param item 匹配单项
     * @param result 匹配结果集合
     */
    private void back(int[] nums, int index, List<Integer> item, List<List<Integer>> result) {
        //去重
        boolean flag = result.stream().anyMatch(e -> {
            if(e.toString().equals(item.toString())) return true;
            else return false;
        });
        if(flag) return;
        result.add(new ArrayList<Integer>(item));
        for(int i = index;i < nums.length;i++){
            item.add(nums[i]);
            back(nums,i+1,item,result);
            item.remove(item.size() - 1);
        }
    }

    /**
     *  ** 优化剪枝策略
     * @param nums
     * @param index
     * @param used ** 剪枝策略
     * @param item
     * @param result
     */
    private void backs(int[] nums, int index, boolean [] used, List<Integer> item, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(item));
        for(int i = index;i < nums.length;i++){
            // used[i - 1] == true， 说明同一树支candidates[i - 1]使用过同一个元素值
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过同一个元素值
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            item.add(nums[i]);
            used[i] = true;
            back(nums,i+1,item,result);
            used[i] = false;
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        BackTrack_90 main = new BackTrack_90();
        List<List<Integer>> result = main.subsetsWithDup(new int[]{4,4,4,1,4});
        System.out.println(result);
    }
}
