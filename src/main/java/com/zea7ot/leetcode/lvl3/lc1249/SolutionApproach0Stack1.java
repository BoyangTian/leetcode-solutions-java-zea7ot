/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/419402/JavaC%2B%2B-Stack
 */
package com.zea7ot.leetcode.lvl3.lc1249;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack1 {
    private static final char PLACE_HOLDER = '*';

    public String minRemoveToMakeValid(String s) {
        final int L = s.length();
        StringBuilder builder = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < L; i++) {
            char ch = builder.charAt(i);
            if (ch == '(') {
                stack.add(i);
            }

            if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    builder.setCharAt(i, PLACE_HOLDER);
                }
            }
        }

        while (!stack.isEmpty()) {
            builder.setCharAt(stack.pop(), PLACE_HOLDER);
        }

        return builder.toString().replaceAll("\\*", "");
    }
}