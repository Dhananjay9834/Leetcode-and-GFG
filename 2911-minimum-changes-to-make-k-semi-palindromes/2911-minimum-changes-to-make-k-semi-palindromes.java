
import java.util.*;

class Solution {

    public int minimumChanges(String s, int k) {

        int n = s.length();

        // Part 1: Precompute cost of every substring
        int[][] cost = new int[n][n];

        for(int left = 0; left < n; left++) {

            for(int right = left + 1; right < n; right++) {

                int length = right - left + 1;
                int minimumChanges = n;

                // Try every proper divisor
                for(int d = 1; d < length; d++) {

                    if(length % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Compare characters in each modulo group
                    for(int offset = 0; offset < d; offset++) {

                        int first = left + offset;
                        int last = right - d + 1 + offset;

                        while(first < last) {

                            if(s.charAt(first) != s.charAt(last)) {
                                changes++;
                            }

                            first += d;
                            last -= d;
                        }
                    }

                    minimumChanges = Math.min(
                        minimumChanges, changes
                    );
                }

                cost[left][right] = minimumChanges;
            }
        }

        // Part 2: Dynamic Programming

        int INF = 1000000;

        int[][] dp = new int[n + 1][k + 1];

        for(int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        // end = number of characters considered
        for(int end = 2; end <= n; end++) {

            // Number of semi-palindromes
            for(int parts = 1; parts <= k; parts++) {

                // Try every possible starting position
                // of the last substring
                for(int start = 2 * (parts - 1);
                    start <= end - 2; start++) {

                    if(dp[start][parts - 1] == INF) {
                        continue;
                    }

                    int totalChanges =
                        dp[start][parts - 1] +
                        cost[start][end - 1];

                    dp[end][parts] = Math.min(
                        dp[end][parts],
                        totalChanges
                    );
                }
            }
        }

        return dp[n][k];
    }
}
