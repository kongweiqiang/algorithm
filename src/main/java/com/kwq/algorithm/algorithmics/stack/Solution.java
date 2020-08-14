package com.kwq.algorithm.algorithmics.stack;

import java.util.Stack;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/7/20
 * @DESC :
 */
public class Solution {

    /**
     * 接雨水
     * @analyse 双指针法
     * @param height
     * @return
     */
    public int maxAreaSum(int[] height) {
        int sum = 0 ;
        for(int i =0 , j = height.length -1 ;i<j;){
            System.out.print("temp : i=" + i +"* j=" +j+ " sum = "+((j-i)== 0? 1: (j-i))* Math.min(height[j],height[i]));
            System.out.println(" sum := "+((j-i)== 0? 1: (j-i))+"*"+ Math.min(height[j],height[i]) + "(" + height[i] + "*" + height[j] +")");
            sum = Math.max(sum,(j-i)* Math.min(height[j],height[i]));
            if(height[i]<height[j]){
                i++ ;
            }else{
                j-- ;
            }
        }
        return sum;
    }

    /**
     * 接雨水
     * @analyse 单调栈
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum =0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<height.length;i++){
            while(!stack.empty() && height[stack.peek()]<height[i]){
                System.out.println("由于 "+height[stack.peek()] + " < " + height[i]+" 栈顶弹出了数组下标为"+stack.peek()+"的元素:"+height[stack.elementAt(stack.size()-1)]);
                Integer pop = stack.pop();
                if(stack.empty()){
                    break;
                }
                System.out.println("执行弹出数组下标为:" + pop+"的值为:"+height[pop]+"的数据");
                sum += (Math.min(height[stack.peek()],height[i])-height[pop])*(i-stack.peek()-1);
                System.out.println("第"+(i+1)+"个 sum :=" + sum);
            }
            System.out.println("第"+(i+1)+"个 stack push :=" + i);
            stack.push(i);
        }
        return sum;
    }

    public int trapRainWater(int[][] heightMap) {
        int sum =0;
        for(int i =1;i < heightMap.length - 1;i++){
            sum += trap(heightMap[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int sum = 0;
        //int [] height = {1,8,6,2,5,4,8,3,7};
        int [] height = {1,2};
        //int sum = solution.maxAreaSum(height);
        int [] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int [] arr = {2,0,2};
        //sum = solution.trap(arr);
        //System.out.println("SUM : " + sum);
        int [][] arrs = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        sum = solution.trapRainWater(arrs);
        System.out.println("SUM : " + sum);
    }


}
