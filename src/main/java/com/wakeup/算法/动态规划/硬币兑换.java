package com.wakeup.算法.动态规划;

public class 硬币兑换 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1 ) {
            return 0;
        }
        int[] count = new int[amount + 1];
        return recall(coins, amount, count);
    }
    public int recall(int[] coins, int amount, int[] count) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (count[amount] != 0) {
            return count[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = recall(coins, amount - coins[i], count);
            if (res >= 0) {
                min = Math.min(min, res + 1);
            }
        }
        count[amount] = min == Integer.MAX_VALUE ? -1:min;
        return count[amount];
    }
    public int dp(int[] coins, int amount) {
        if (amount < 1 ) {
            return 0;
        }
        int[] count = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && count[i - coins[j]] > 0) {
                    min = Math.min(count[i - coins[j]] + 1, min);
                }
            }
            count[i] = min == Integer.MAX_VALUE ? -1 :min ;
        }
        return count[amount];
    }

}
