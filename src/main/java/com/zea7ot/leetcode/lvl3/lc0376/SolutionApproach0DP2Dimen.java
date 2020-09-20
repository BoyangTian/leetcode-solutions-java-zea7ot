/**
 * https://leetcode.com/problems/wiggle-subsequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(2 * N) ~ O(N)
 * 
 * References:
 *  https://youtu.be/FLbqgyJ-70I?t=1383
 */
package com.zea7ot.leetcode.lvl3.lc0376;

public class SolutionApproach0DP2Dimen {
    public int wiggleMaxLength(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[][] dp = new int[N][2];
        // up
        dp[0][0] = 1;
        // down
        dp[0][1] = 1;

        for (int i = 1; i < N; ++i) {
            if (nums[i - 1] > nums[i]) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = dp[i - 1][0];
            } else if (nums[i - 1] < nums[i]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }

        return Math.max(dp[N - 1][0], dp[N - 1][1]);
    }
}
