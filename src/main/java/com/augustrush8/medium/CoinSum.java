package com.augustrush8.medium;

public class CoinSum {
    public static void main(String[] args) {
        int target =200;
        int[] coins={1, 2, 5, 10, 20, 50, 100, 200};
        int[] res = new int[target + 1];
        res[0]=1;//注意初始化
        solution(target,coins,res);
    }

    public static void solution(int target, int[] coins, int[] res) {
        for (int j = 0; j < coins.length; j++) {
            for (int k = coins[j]; k <= target; k++) {
                res[k] += res[k - coins[j]];
            }
        }
        System.out.println(res[target]);

    }
}
