/**
 * @author: Leon
 * https://leetcode.com/problems/clone-n-ary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc1490;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0BFS {
    public Node cloneTree(Node root) {
        // sanity check
        if (root == null)
            return root;

        Map<Node, Node> map = new HashMap<>();
        map.put(root, new Node(root.val));

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                Node cur = queue.poll();

                for (Node next : cur.children) {
                    if (!map.containsKey(next)) {
                        map.put(next, new Node(next.val));
                        queue.offer(next);
                    }

                    map.get(cur).children.add(map.get(next));
                }
            }
        }

        return map.get(root);
    }
}
