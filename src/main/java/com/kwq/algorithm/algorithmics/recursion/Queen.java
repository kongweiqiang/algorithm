package com.kwq.algorithm.algorithmics.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/20
 * @DESC : 皇后问题
 */
public class Queen {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> item = new ArrayList<>();
        back(n,0,item,result);
        return result;
    }

    public void back(int n,int index, List<String> item,List<List<String>> result){
        if(index == n){
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = index; i < n; i++) {
            //判断皇后位置是否合法:不同行/不同列/不同斜线---->f(x,y):\x - y\ = \y - x\
            StringBuilder sb = new StringBuilder();
            sb.append("Q");
            item.add(sb.toString());
            back(n,i + 1,item,result);
            //item.remove(item.lastIndexOf());
        }
    }

}
