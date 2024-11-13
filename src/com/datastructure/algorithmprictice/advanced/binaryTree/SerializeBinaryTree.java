package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

/**
 * 序列化和反序列化二叉树
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeBinaryTree {
    /**
     * 先序序列化二叉树
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        levelOrderSerialize(root, builder);
        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] split = data.split(",");
        count = 0;
        return leverOrderDeserialize(split);
    }

    public static TreeNode[] queue = new TreeNode[10001];
    public static int l, r;

    public void levelOrderSerialize(TreeNode root, StringBuilder builder) {
        if (root == null) return;
        // 按层序列化Tree
        l = r = 0;
        // 进队列的时候就序列化
        queue[r++] = root;
        builder.append(root.val).append(",");
        while (l < r) {
            TreeNode node = queue[l++];
            if (node.left != null) {
                queue[r++] = node.left;
                builder.append(node.left.val).append(",");
            } else {
                builder.append("#,");
            }

            if (node.right != null) {
                queue[r++] = node.right;
                builder.append(node.right.val).append(",");
            } else {
                builder.append("#,");
            }
        }
    }

    public TreeNode leverOrderDeserialize(String[] arr) {
        // 还是要用一个队列
        l = r = 0;
        int index = 0;
        // 头节点

        TreeNode root = generateNode(arr[index++]);
        queue[r++] = root;
        while (l < r) {
            TreeNode node = queue[l++];
            // 直接建立左右
            node.left = generateNode(arr[index++]);
            node.right = generateNode(arr[index++]);
            if (node.left != null) {
                queue[r++] = node.left;
            }
            if (node.right != null){
                queue[r++] = node.right;
            }
        }
        return root;
    }

    private TreeNode generateNode(String str) {
        return "#".equals(str) ? null : new TreeNode(Integer.parseInt(str));
    }


    public void preOrderSerialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#,");
            return;
        }
        builder.append(root.val).append(",");
        preOrderSerialize(root.left, builder);
        preOrderSerialize(root.right, builder);
    }

    public static int count = 0;

    private TreeNode preOrderDeserialize(String[] arr) {
        String cur = arr[count++];
        if ("#".equals(cur)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(cur));

        node.left = preOrderDeserialize(arr);
        node.right = preOrderDeserialize(arr);
        return node;

    }
}
