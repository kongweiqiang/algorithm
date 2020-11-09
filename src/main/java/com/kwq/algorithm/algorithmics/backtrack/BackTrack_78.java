package com.kwq.algorithm.algorithmics.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/2
 * @DESC :
 */
public class BackTrack_78 {

    /** 78 .求子集问题
     * @num 78
     * @desc 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集） 解集不能包含重复的子集
     * @param digits
     * @return
     * @eg   示例: 输入: nums = [1,2,3]
     *             输出:
     *              [ [3],
     *                [1],
     *                [2],
     *                [1,2,3],
     *                [1,3],
     *                [2,3],
     *                [1,2],
     *                [] ]
     */
    public List<List<Integer>> subsets(int [] num) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        if(num == null) return null;
        if(num.length == 0) return result;
        back(num,0,item,result);
        return result;
    }

    private void back(int[] num,int index,List<Integer> item,List<List<Integer>> result){
        result.add(new ArrayList<Integer>(item));
        //if(item.size() == num.length) return;
        for(int i = index;i < num.length;i++){
            item.add(num[i]);
            back(num,i + 1,item,result);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        BackTrack_78 back = new BackTrack_78();
        List<List<Integer>> subsets = back.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
