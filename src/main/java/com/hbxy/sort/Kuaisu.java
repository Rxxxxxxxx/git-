package com.hbxy.sort;

public class Kuaisu {
    public static void main(String[] args) {
        int[] a={0,2,3,6,9,5,8,1,4,7};
        quick(a,1,9);
        for (int i=1;i<10;i++){
            System.out.print(a[i]);
        }
    }
    static void quick(int []a,int i,int j){
        if(i==j){
            return;
        }
        int m=kssort(a,i,j);
        quick(a,i,m);
        quick(a,m+1,j);
    }
    public static int kssort(int[] a,int i,int j){
        a[0]=a[i];
        while(i<j){
            while (a[j]>a[0]&&i<j){
                j--;
            }
            a[i]=a[j];
            while(a[i]<a[0]&&i<j){
                i++;
            }
            a[j]=a[i];
        }
        a[j]=a[0];
        return j;
    }
}
