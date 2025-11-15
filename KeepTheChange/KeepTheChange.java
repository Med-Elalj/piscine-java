import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        // Convert to sorted list (descending helps reconstruction look nicer)
        List<Integer> coinList = new ArrayList<>(coins);
        Collections.sort(coinList);

        // dp[i] = minimum number of coins to make sum i
        int[] dp = new int[amount + 1];
        int[] lastCoin = new int[amount + 1]; // store the coin used to reach i

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coinList) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                    lastCoin[i] = coin;
                }
            }
        }

        // If dp[amount] is still INF, no solution exists
        if (dp[amount] == Integer.MAX_VALUE) {
            return Collections.emptyList();
        }

        // Reconstruct the solution
        List<Integer> result = new ArrayList<>();
        int current = amount;
        while (current > 0) {
            int coin = lastCoin[current];
            result.add(coin);
            current -= coin;
        }

        return result;


    }
}