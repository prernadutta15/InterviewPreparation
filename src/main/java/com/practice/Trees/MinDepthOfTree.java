package com.practice.Trees;

import java.util.LinkedList;
import java.util.Queue;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 
 * @author prerna.dutta
 *
 */

@AllArgsConstructor @NoArgsConstructor
class TreeNode
{
	int val;
	TreeNode left,right;
	public TreeNode(int val)
	{
		this.val = val;
	}
}
public class MinDepthOfTree {

	public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        int size = 0;
        
        while (!queue.isEmpty()){
            size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode ele = queue.remove();
                if(ele==null)continue;
                if(ele.left==null && ele.right==null) return depth;
                queue.add(ele.left);
                queue.add(ele.right);
            }
            depth++;
        }
        return 0;
    }
}
