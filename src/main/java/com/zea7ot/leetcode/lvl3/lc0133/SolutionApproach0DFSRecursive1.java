/**
 * https://leetcode.com/problems/clone-graph/
 * 
 * Time Complexity:     O(V + E) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N + (N - 1)) ~ O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zea7ot.utils.data_structure.graph.Vertex;

public class SolutionApproach0DFSRecursive1 {
    private Map<Vertex, Vertex> visited = new HashMap<Vertex, Vertex>();

    public Vertex cloneGraph(Vertex node) {
        // sanity check
        if (node == null)
            return node;

        if (visited.containsKey(node))
            return visited.get(node);

        Vertex cloneNode = new Vertex(node.val, new ArrayList<Vertex>());
        visited.put(node, cloneNode);

        for (Vertex neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}