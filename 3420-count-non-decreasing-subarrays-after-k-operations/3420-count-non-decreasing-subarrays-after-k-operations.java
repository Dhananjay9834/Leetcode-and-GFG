
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        Deque<Integer> deque = new ArrayDeque<>();

        int j = n - 1;

        long cost = 0;
        long answer = 0;

        // Process the array from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove smaller elements from the back
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] < nums[i]) {

                int left = deque.pollLast();

                int right;

                if (deque.isEmpty()) {
                    right = j + 1;
                } else {
                    right = deque.peekLast();
                }

                // Calculate additional operations
                cost += (long) (right - left)
                        * (nums[i] - nums[left]);
            }

            // Insert current index
            deque.offerLast(i);

            // Shrink window if cost exceeds k
            while (cost > k) {

                cost -= nums[deque.peekFirst()] - nums[j];

                if (deque.peekFirst() == j) {
                    deque.pollFirst();
                }

                j--;
            }

            // Count valid subarrays
            answer += j - i + 1;
        }

        return answer;
    }
}
