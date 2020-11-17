package com.kwq.algorithm.algorithmics.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/17
 * @DESC : 47.全排列
 */
public class BackTrack_47 {

    /** 全排列
     * @num 47
     * @param nums
     * @return
     * @desc 给定一个 可包含重复数字的序列，返回其所有不重复的全排列。
     * 示例:
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> item = new ArrayList<>();
        Arrays.sort(nums);
        back(nums,item,result,new int[nums.length]);
        return result;
    }

    private void back(int[] nums,List<Integer> item,List<List<Integer>> result,int[] used) {
        if(item.size() == nums.length){
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //使用过 去重
            // used[i - 1] == true，说明同一树支nums[i - 1]使用过
            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            // 如果同一树层nums[i - 1]使用过则直接跳过
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0){
                continue;
            }
            if(used[i] == 0) {
                used[i] = 1;
                item.add(nums[i]);
                back(nums, item, result, used);
                item.remove(item.size() - 1);
                used[i] = 0;
            }
        } 
    }

    public static void main(String[] args) {
        BackTrack_47 main = new BackTrack_47();
        List<List<Integer>> list = main.permuteUnique(new int[]{1, 1, 2});
        System.out.println(list);
    }

    /**
     *             1            2           3
     *          2           1       3   1     2
     *        3         3         1      2  1
     *
     */
}
