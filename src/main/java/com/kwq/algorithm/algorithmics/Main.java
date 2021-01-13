package com.kwq.algorithm.algorithmics;

/**
 * 矩阵快速幂
 */
public class Main {
    public static final int mod = 998244353;
    public static long[][] a= {{1,1},{1,0}};//底数
    public static void main(String[] args) {
        int n = 50;
        long[] result = new long[n];
        for (int i = 1; i < n; i++) {
            result[i] = F(i);
        }
        System.out.println(result.toString());
    }

    public static long F(long n){
        long[][] result= {{1},{1}};
        if(n==1||n==2) {
            return 1;
        }else {
            n-=2;
            //快速幂的知识，可自行搜索
            while(n>0) {
                if((n&1)==1) {//如果n是奇数，就抽出来一个
                    result=Muti(a, result);
                }
                n>>=1;//n缩小两倍
                a=Muti(a, a);//底数扩大为原来的平方
            }
            return result[0][0];
        }
    }
    //两个矩阵相乘
    public static long[][] Muti(long[][] a,long[][] b){

        final int rows=a.length;//第一个矩阵的行数

        final int cols=b[0].length;//第二个矩阵的列数

        final int temp=a[0].length;//第一个矩阵的列数

        long[][] result =new long[rows][cols];//创建一个新的二维数组存储结果

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                for(int k=0;k<temp;k++) {
                    result[i][j]+=a[i][k]*b[k][j];
                    result[i][j]%=mod;
                }
            }
        }
        return result;
    }
}