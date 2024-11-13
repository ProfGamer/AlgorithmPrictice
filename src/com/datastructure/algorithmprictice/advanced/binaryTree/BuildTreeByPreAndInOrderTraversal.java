package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

import java.util.HashMap;

/**
 * 通过二叉树的前序和中序遍历结果重新构建二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTreeByPreAndInOrderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        int size = inorder.length;
        for (int i = 0 ; i < size ; i++) {
            valueIndexMap.put(inorder[i],i);
        }
        return buildTreeByPreInOrder(preorder, 0, size - 1, inorder, 0, size - 1, valueIndexMap);
    }

    /***
     * 递归方法, 给定一颗二叉树的前序, 中序遍历arr, 和对饮的范围, 以及每个值在inOrder中的索引位置, 返回树的头节点
     * @param pre
     * @param preStart
     * @param preEnd
     * @param in
     * @param inStart
     * @param inEnd
     * @param map
     * @return
     */
    private TreeNode buildTreeByPreInOrder(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, HashMap<Integer,Integer> map){
        // 前序遍历的preStart索引位置就是头节点, 如果索引无效 则为空
        if (preStart > preEnd) return null;
        // 如果该范围上只有一个索引, 那么直接返回他作为head
        TreeNode treeHead = new TreeNode(pre[preStart]);
        if (preStart == preEnd) return treeHead;
        // 找到头节点在map中的索引位置, 即他在中序遍历中的位置
        int index = map.get(treeHead.val);
        // pre [1,2,4,3,5,6] preStart 0 end 5
        // in  [4,2,1,5,3,6] inStart 0  end 5
        // 找到1 为 头, 1在in中的index 为 2 index
        // 所以在in中, inStart ~ index - 1 位置为该头节点的左树 节点数位 index - inStart
        // 在in中     index + 1 ~ inEnd位置为该节点的右树 节点数为 inEnd - index
        // 在Pre中,   preStart + 1 ~ preStart + index - inStart 为该节点的左树
        // 在Pre中    preStart + index - inStart + 1 ~ preEnd  为该节点的右树
        treeHead.left = buildTreeByPreInOrder(pre, preStart + 1, preStart + index - inStart, in ,inStart, index - 1, map);
        treeHead.right = buildTreeByPreInOrder(pre, preStart + index - inStart + 1, preEnd, in, index + 1, inEnd, map);
        return treeHead;
    }
}
