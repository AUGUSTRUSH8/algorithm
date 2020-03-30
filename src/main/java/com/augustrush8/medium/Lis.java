package com.augustrush8.medium;

//最长上升子序列，leetcode中文版上有详细原理阐述
public class Lis {
    public static int lis(int[] serials){
        if (serials.length == 0) {
            return 0;
        }
        int[] dp = new int[serials.length];
        dp[0]=1;
        int maxincrease=0;
        for (int i = 0; i < serials.length; i++) {
            int maxval=0;
            for (int j = 0; j < i; j++) {
                if (serials[j] < serials[i]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i]=maxval+1;
            maxincrease = Math.max(maxincrease, dp[i]);
        }
        return maxincrease;
    }
}
