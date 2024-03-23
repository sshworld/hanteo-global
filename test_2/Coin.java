package test_2;

public class Coin {

    public static void main(String[] args) {
        System.out.println(coin(4, new int[]{1, 2, 3}));
        System.out.println(coin(10, new int[]{2, 5, 3, 6}));
    }

    public static int coin(int sum, int[] coins) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[sum];
    }
}
