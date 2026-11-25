
import java.util.*;

class Solution {

    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;
    static final long BASE = 911_382_323L;

    long[] prefix1, prefix2;
    long[] power1, power2;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        prefix1 = new long[n + 1];
        prefix2 = new long[n + 1];

        power1 = new long[n + 1];
        power2 = new long[n + 1];

        power1[0] = 1;
        power2[0] = 1;

        // Build prefix hashes and powers
        for (int i = 0; i < n; i++) {

            prefix1[i + 1] =
                (prefix1[i] * BASE + nums[i]) % MOD1;

            prefix2[i + 1] =
                (prefix2[i] * BASE + nums[i]) % MOD2;

            power1[i + 1] = (power1[i] * BASE) % MOD1;
            power2[i + 1] = (power2[i] * BASE) % MOD2;
        }

        // Binary search for minimum unique length
        int low = 1;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (hasUniqueSubarray(nums.length, mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean hasUniqueSubarray(int n, int len) {

        HashMap<Long, Integer> map = new HashMap<>();

        // Generate hashes of all windows of length len
        for (int i = 0; i + len <= n; i++) {

            int left = i;
            int right = i + len;

            long hash1 =
                (prefix1[right] -
                (prefix1[left] * power1[len]) % MOD1 + MOD1) % MOD1;

            long hash2 =
                (prefix2[right] -
                (prefix2[left] * power2[len]) % MOD2 + MOD2) % MOD2;

            // Combine both hashes into one key
            long key = (hash1 << 32) | hash2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Check whether any subarray occurs exactly once
        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
