package com.li.binaryTree;

/**
 * @Author: li wei kai
 * @Date: 2022/06/21/17:14
 * @Description:leetcode T124 题目：二叉树中的最大路径和
 题目描述：
路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中
至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
路径和 是路径中各节点值的总和。
给你一个二叉树的根节点 root ，返回其 最大路径和

示例 1：
    输入：root = [1,2,3]
    输出：6
    解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
示例 2：
    输入：root = [-10,9,20,null,null,15,7]
    输出：42
    解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
public class binaryTreeMaximumPathSum {
    public static int sum ;
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree tree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(-10, "宋江");
        HeroNode node1 = new HeroNode(9, "吴用");
        HeroNode node2 = new HeroNode(20, "卢俊义");
        HeroNode node3 = new HeroNode(15, "林冲");
        HeroNode node4 = new HeroNode(7, "关胜");
        //创建二叉树节点
        tree.setNode(root);
        root.left = node1;
        root.right = node2;
        node2.left = node3 ;
        node2.right = node4 ;

        int maxPathSum = maxPathSum(root);
        System.out.println("二叉树中的最大路径和 = " + maxPathSum);
    }
    /**
    * @Description:
    根据函数 maxGain 得到每个节点的最大贡献值之后，如何得到二叉树的最大路径和？对于二叉树中的一个节点，
    该节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值，如果子节点的最大贡献值为正，则计
    入该节点的最大路径和，否则不计入该节点的最大路径和。维护一个全局变量 maxSum 存储最大路径和，在递归
    过程中更新 maxSum 的值，最后得到的 maxSum 的值即为二叉树中的最大路径和。
    * @Param: [root]
    * @return: int
    * @Date: 2022/6/22
    */
    public static int maxPathSum(HeroNode root){
        sum = Integer.MIN_VALUE ;
        maxGain(root) ;
        return sum ;
    }

    /**
    * @Description: 计算二叉树中一个节点的最大贡献值
    具体而言，该函数的计算如下：
        空节点的最大贡献值等于 0。
        非空节点的最大贡献值等于节点值与其子节点中的最大贡献值之和（对于叶节点而言，最大贡献值等于节点值）。
    * @Param: [root]
    * @return: int
    * @Date: 2022/6/22
    */
    public static int maxGain(HeroNode root){
        if (root == null){
            return 0 ;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(maxGain(root.left) , 0) ;
        int right = Math.max(maxGain(root.right) , 0) ;

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        sum = Math.max(sum , left + right + root.no) ;

        // 返回节点的最大贡献值
        return root.no + Math.max(left , right) ;
    }

}
