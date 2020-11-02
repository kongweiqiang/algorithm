package com.kwq.algorithm.algorithmics.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/30
 * @DESC :
 */
public class BackTrack_77 {

    /** 77.组合
     * @num 77
     * @desc 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
     * @eg 输入: n = 4, k = 2
     * 输出: [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        int [] param = new int[n];
        for (int i = 0; i < n; i++) {
            param[i] = i+1;
        }
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> item = new  ArrayList<>();
        back(n,k,0,param,item,result);
        return result;
    }

    private void back(int n,int k,int startIndex,int [] param,ArrayList<Integer> item,List<List<Integer>> result){
        if(item.size() == k){
            result.add(new ArrayList<>(item));
            return ;
        }
        for (int i = startIndex; i < n; i++) {
        //for (int i = startIndex; i <= n - (k - result.size()) + 1; i++) { // 剪枝: 后面的集合的元素数量不足以查找到结果
            item.add(param[i]);
            back(n,k,i+1,param,item,result);
            item.remove(item.size() - 1);// **** 回溯
        }
    }

    public static void main(String[] args) {
        BackTrack_77 back = new BackTrack_77();
        int n = 4,k =3;
        List<List<Integer>> combine = back.combine(n, k);
        System.out.println(combine);
    }
}
