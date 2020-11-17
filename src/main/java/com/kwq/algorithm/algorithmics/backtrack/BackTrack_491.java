package com.kwq.algorithm.algorithmics.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/17
 * @DESC : 491.递增子序列
 */
public class BackTrack_491 {

    /**
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     * 示例:
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     * 说明:
     * 给定数组的长度不会超过15。
     * 数组中的整数范围是 [-100,100]。
     * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
     * @param nums
     * @return 递增子序列
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        //求递增子序列 不能排序 排序导致数组序列有序而影响子序列的选择决策
        back(nums,0,item,result);
        return result;
    }

    /**
     * 递增子序列
     * @param nums 数组
     * @param index 位置偏移量
     * @param item 单项结果
     * @param result 结果集
     */
    private void back(int[] nums, int index, List<Integer> item, List<List<Integer>> result){
        if(item.size() > 1) {
            result.add(new ArrayList<>(item));
        }
        //每一层去重 当前层是否使用过相同元素 所以是局部变量
        Set<Integer> used = new HashSet<>();
        for(int i = index; i < nums.length; i++){
            //  去重                    第一个子序列中的数放行            递增
            if(!used.contains(nums[i]) && (item.isEmpty() || nums[i] >= item.get(item.size() - 1))) {
                item.add(nums[i]);
                used.add(nums[i]);//不需要回溯 因为是局部去重变量 不是递归中的参数
                back(nums, i + 1, item, result);//递归回溯
                item.remove(item.size() - 1);//回溯
            }//否则继续遍历
        }
    }

    public static void main(String[] args) {
        BackTrack_491 main = new BackTrack_491();
        List<List<Integer>> result = main.findSubsequences(new int[]{4, 7, 6, 7});
        List<List<Integer>> result1 = main.findSubsequences(new int[]{4, 6, 7, 7});
        System.out.println(result);
        System.out.println(result1);
    }
}
