package com.kwq.algorithm.algorithmics.string;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/12/23
 * @DESC : LintCode.No.8 原地翻转指定偏移量字符串
 */
public class String_Lint_8 {
    public static void main(String[] args) {
        String str = "abccba";
        int offset = 2;
        String_Lint_8 main = new String_Lint_8();
        System.out.println(str);
        main.rotateString(str.toCharArray(),offset);
        System.out.println(str);
    }

    public void rotateString(char[] str, int offset) {
        if(offset <= 0 || offset > str.length -1 ) return;
        rotate(str,0,offset);
        rotate(str,offset+1,str.length-1);
        rotate(str,0,str.length-1);
    }

    private void rotate(char[] str,int start,int end){
        char temp;
        while(start < end){
            temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }
}
