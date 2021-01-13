package com.kwq.algorithm.algorithmics.sum;

import com.kwq.algorithm.model.ListNode;
import com.kwq.algorithm.model.TreeNode;

import java.util.*;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/7/21
 * @DESC :
 */
public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        /*
        int sum = 9;
        int[] result = main.twoSum2(new int[]{2, 7, 11, 15}, sum);
        System.out.println(result[0] + " + " + result[1] + " --> " + sum);
        */

        int[] arr = {2,7,11,15};
       //int[] arrs = {-1, 0, 1, 2, -1, -4};
        int[] arrs = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        int sum = 9;
        //int [] twoSum = main.twoSum(arr,sum);
        List result = main.threeSum(arrs,0);
        List result2 = main.threeSum2(arrs,0);
        //System.out.println(twoSum[0]+"+"+twoSum[1]);
        System.out.println();

        /*
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        node1.next.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        ListNode listNode = solution.addTwoNumbersSuffix(node1, node2);
        System.out.println(listNode);
        */
        /*
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3,n2,n4);
        TreeNode n6 = new TreeNode(6,null,n7);
        TreeNode n5 = new TreeNode(5,n3,n6);
        System.out.println(main.findTarget(n5, 9));//true
        System.out.println(main.findTarget(n5, 28));//false
        TreeNode n1 = new TreeNode(1);
        n3 = new TreeNode(3,null,null);
        n2 = new TreeNode(2,n1,n3);
        System.out.println(main.findTarget(n2, 4));//true
        System.out.println(main.findTarget(n1, 2));//false
        */
    }

    public String multiply(String num1, String num2) {
        int sum = 0;
        String n = "0";
        if( n.equals(num1) || n.equals(num2)){
            return n;
        }
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {

            }
        }
        return ""+sum;
    }

    /**
     * 两数之和
     * @number 1
     * @alayse 用map存储遍历的数据做缓存,map在for循环后续添加元素
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] solution = {0,0};
        for(int i= 0 ;i<nums.length;i++){
            if(!map.isEmpty() && map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return solution;
    }

    /** 两数之和
     * @number 167
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0) return null;
        int l = 0,r = numbers.length - 1;
        while(l <= r){
            if(numbers[l] + numbers[r] == target){
                break;
            }else if(numbers[l] + numbers[r] > target){
                r--;
            }else{
                l++;
            }
        }
        return new int[]{l,r};
    }

    /** 两数之和
     * @number 653
     * @param root 树
     * @param k 数和
     * @return 是否存在两数之和
     * @eg
     *  [2, 1, 3] 4 ----> true
     *  [1] 2 ----> false
     */
    public Set<Integer> set = new TreeSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        boolean left = findTarget(root.left, k);
        if(set.contains(k - root.val)) return true;
        set.add(root.val);
        boolean right = findTarget(root.right,k);
        return left || right;
    }

    /**
     * 三数之和
     * @number 15
     * @alayse 用map存储遍历的数据做缓存,map在for循环后续添加元素
     * @param nums
     * @param sum
     * @desc 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = sum ？请你找出所有满足条件且不重复的三元组。注意：答案中不可以包含重复的三元组
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums,int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length<3){
            return list;
        }
        //排序使得已获得的答案不重复
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap();
        // 初始化map
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            // 有序数组相邻的相等元素跳过防止重复
            if(i > 0 && nums[i] == nums[i-1] && map.containsKey(nums[i])){
                continue;
            }
            // 有序数组相邻的相等元素跳过防止重复
            for (int j = i+1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                if(!map.isEmpty() && map.containsKey(sum - nums[i] - nums[j]) && map.get( sum - nums[i] - nums[j]) > j){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(sum - nums[i] - nums[j]);
                    list.add(temp);
                }
            }
        }
        return list;
    }

    public List<List<Integer>> threeSum2(int[] nums,int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length<3){
            return result;
        }
        //排序使得已获得的答案不重复
        Arrays.sort(nums);
        int target = 0,left = 0,right = nums.length - 1;
        while(left < right){
            if( left > 0 && nums[left - 1] == nums[left]){
                left++;
                continue;
            }
            target = sum - nums[left];
            int mid = left + 1;
            while(mid < right){
                if(mid > left + 1 && nums[mid - 1] == nums[mid]){
                    mid++;
                    continue;
                }
                if (nums[mid] + nums[right] == target) {
                    result.add(new ArrayList<>(Arrays.asList(nums[left],nums[mid++],nums[right])));
                }else if(nums[mid] + nums[right] > target){
                    right--;
                }else{
                    mid++;
                }
            }
            left++;
        }
        return result;
    }

    /**
     * 两个非空链表表示非负整数,节点代表每一位且位数逆序存储:求链表表示的两数和
     * @number 2
     * @eg (2 -> 4 -> 3) + (5 -> 6 -> 4)     7 -> 0 -> 8     342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        // 此处不能返回最终被add递归函数处理的结果,因为是递归处理,result引用指向的内存地址是最后一个next的引用 递归后result!=result
        this.add(l1, l2, result, 0);
        System.out.println(result.next);
        return result.next;
    }

    /**
     *  递归
     * @param l1
     * @param l2
     * @param result 储存结果
     * @param flag 表示是否进位
     * @return
     */
    private ListNode add(ListNode l1,ListNode l2,ListNode result,int flag){
        // 递归出口
        if(l1 == null && l2 == null && flag ==0){
            //最后一位的链表要对进位单独处理,处理末位两数相加正好为十的场景
//            if(flag == 1){
//                result.next = new ListNode(1);
//            }
            return result;
        }
        int sum = (l1==null?0:l1.data) + (l2==null?0:l2.data) + flag;
        flag = 0;
        //取余 标记进位
        if(sum>=10){
            flag = 1;
            sum = Math.floorMod(sum,10);
        }
        result.next = new ListNode(sum);
        //递归处理记录结果
        return add(l1 == null ? null:l1.next,l2 == null ? null:l2.next,result.next,flag);
    }

    /** 两数之和
     * @desc (9-> 2 -> 4 -> 3) + (5 -> 6 -> 4)    9 -> 8 -> 0 -> 7
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersSuffix(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode r = new ListNode(0);
        Stack<ListNode> node1 = new Stack<>();
        Stack<ListNode> node2 = new Stack<>();
        Stack<ListNode> rs = new Stack<>();
        do {
            node1.push(l1);
            l1 = l1.next;
        }while(l1!= null);
        do {
            node2.push(l2);
            l2 = l2.next;
        }while(l2 != null);

        // 此处不能返回最终被add递归函数处理的结果,因为是递归处理,result引用指向的内存地址是最后一个next的引用 递归后result!=result
        this.add(node1, node2, result, 0);
        System.out.println(result.next);
        ListNode reverse = result.reverse(result.next);
        System.out.println(reverse);
        return reverse;
    }

    private ListNode add(Stack<ListNode> l1,Stack<ListNode> l2,ListNode result,int flag){
        // 递归出口
        if(l1 == null && l2 == null && flag ==0){
            return result;
        }
        int sum = (l1 == null || l1.peek()==null?0:l1.peek().data) + (l2 == null || l2.peek()==null?0:l2.peek().data) + flag;
        flag = 0;
        //取余 标记进位
        if(sum>=10){
            flag = 1;
            sum = Math.floorMod(sum,10);
        }
        result.next = new ListNode(sum);
        if(l1!=null){
            l1.pop();
        }
        if(l2!=null){
            l2.pop();
        }
        //递归处理记录结果
        return add(l1==null || l1.empty() ? null:l1,l2 == null ||l2.empty() ? null:l2,result.next,flag);
    }
}
