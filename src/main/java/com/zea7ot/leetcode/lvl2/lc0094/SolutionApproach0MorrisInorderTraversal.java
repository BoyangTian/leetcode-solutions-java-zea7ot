/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * pseudocode:
 *  cur = root
 *  while cur is not null
 *      if not exists cur.left
 *          visit(cur)
 *          cur = cur.right
 *      else 
 *          predecessor = findInorderPredecessor(cur)
 *          if not exists predecessor.right
 *              predecessor.right = cur
 *              cur = cur.left
 *          else
 *              predecessor.right = null
 *              visit(cur)
 *              cur = cur.right
 * 
 * References:
 *  https://www.youtube.com/watch?v=wGXB9OWhPTg
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/MorrisTraversal.java
 */
package com.zea7ot.leetcode.lvl2.lc0094;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0MorrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;
        
        TreeNode cur = root;
        while(cur != null){
            /**
             * this step mainly serves:
             *  if the left subtree has been totally traversed,
             *  to go "back" to the `predecessor`.
             */
            if(cur.left == null){
                ans.add(cur.val);
                cur = cur.right;
            }else{
                // to find the rightmost node in the left subtree
                TreeNode predecessor = cur.left;
                while(predecessor.right != cur && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                
                // to build up the relationship,
                // by pointing inorder `predecessor` to `cur`
                if(predecessor.right == null){
                    predecessor.right = cur;
                    cur = cur.left;
                }else{
                    /**
                     * if `predecessor.right != null`,
                     * which means this part has been traversed once before,
                     * now it is safe:
                     *  0. to break the predecessor relationship previously built
                     *  1. to visit the `cur` node
                     *  2. to go to `cur.right`, which is another `predecessor`
                     */
                    predecessor.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        
        return ans;
    }
}