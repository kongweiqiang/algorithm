package com.kwq.algorithm.algorithmics.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/30
 * @DESC :
 */
public class BackTrack_216 {

    /** 216.组合
     * @num 216
     * @desc 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字
     * @eg 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        int [] param = new int[n];
        for (int i = 0; i < param.length && i<9; i++) {
            param[i]=i+1;
        }
        ArrayList<Integer> item = new ArrayList<>(k);
        List<List<Integer>> result = new ArrayList<>();
        back(n,k,0,param,item,result);
        return result;
    }

    private void back(int n,int k,int startIndex,int [] param,ArrayList<Integer> item,List<List<Integer>> result){
        if(item.size() >= k) {
            if(n == 0) {
                result.add(new ArrayList<>(item));
                //item.clear();
            }
            return;
        }
        for (int i = startIndex; i < n && i<10; i++) {
            if(n-param[i]<0)break;
            item.add(param[i]);
            back(n-param[i],k,i+1,param,item,result);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        BackTrack_216 back = new BackTrack_216();
        int n = 45,k =9;
        List<List<Integer>> combine = back.combine(n, k);
        System.out.println(combine);
    }
}
