package com.kwq.algorithm.algorithmics.greedy;

import java.util.Arrays;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/12/25
 * @DESC : 分发饼干
 */
public class Greedy_455 {

    public static void main(String[] args) {
        Greedy_455 main = new Greedy_455();
        System.out.println(main.findContentChildren(new int[]{5,1,8},new int[]{9,7,4,5}));
    }

    /**
     * 分发饼干
     * @param g
     * @param s
     * @return
     * @eg
     * <li>
     * 示例1:输入: g = [1,2,3], s = [1,1]
     * 输出: 1
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1
     * </li>
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int x = 0,y = 0,count = 0;
        while(x < g.length && y < s.length){
            //满足
            if(g[x] <= s[y++]){
                count++;
                x++;
            }
        }
        return count;
    }
}
