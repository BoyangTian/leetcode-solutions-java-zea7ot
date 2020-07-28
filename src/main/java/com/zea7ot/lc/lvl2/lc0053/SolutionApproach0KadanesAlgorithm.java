/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  Kadane's Algorithm
 *  https://hackernoon.com/kadanes-algorithm-explained-50316f4fd8a6
 *  https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
 */
package com.zea7ot.lc.lvl2.lc0053;

public class SolutionApproach0KadanesAlgorithm{
    public int maxSubArray(int[] nums) {                       // [-2,1,-3,4,-1,2,1,-5,4]
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        final int N = nums.length;
        int localMax = 0, globalMax = Integer.MIN_VALUE;
        
        for(int i = 0; i < N; i++){
            localMax = Math.max(nums[i], localMax + nums[i]);   // localMax:    -2, -1, -3, 4, 3, 5, 6, 1, 5
            if(localMax > globalMax){                           // true, true, false, true, false, true, true, false, false
                globalMax = localMax;                           // globalMax:   -2, -1, -1, 4, 4, 5, 6, 6, 6
            }
        }
        
        return globalMax;
    }
}