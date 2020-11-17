package com.kwq.algorithm.algorithmics.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/17
 * @DESC : 46.全排列
 */
public class BackTrack_46 {

    /** 全排列
     * @num 46
     * @param nums
     * @return
     * @desc 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
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
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> item = new ArrayList<>();
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
            if(used[i] == 1 ){
                continue;
            }
            used[i] = 1;
            item.add(nums[i]);
            back(nums,item,result,used);
            item.remove(item.size() - 1);
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        BackTrack_46 main = new BackTrack_46();
        List<List<Integer>> list = main.permute(new int[]{1, 2, 3});
        System.out.println(list);
    }

    /**
     *             1            2           3
     *          2           1       3   1     2
     *        3         3         1      2  1
     *
     */
}
