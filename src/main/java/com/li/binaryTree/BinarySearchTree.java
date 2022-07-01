package com.li.binaryTree;

import java.util.*;

/**
 * @Author: li wei kai
 * @Date: 2022/06/27/20:07
 * @Description: 二叉搜索树
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode node1 = new HeroNode(1, "刘备");
        HeroNode node2 = new HeroNode(2, "关羽");
        HeroNode node3 = new HeroNode(3, "张飞");
        HeroNode node4 = new HeroNode(4, "曹操");
        HeroNode node5 = new HeroNode(5, "孙策");
        HeroNode node6 = new HeroNode(6, "诸葛亮");
        HeroNode node7 = new HeroNode(7, "赵云");
        //创建二叉树节点
        binaryTree.setNode(node4);
        node4.left = node3;
        node4.right = node6;
        node3.left = node1;
        node3.right = node2;
        node6.left = node5 ;
        node6.right = node7 ;

        //二叉搜索树的中序后继节点
        HeroNode heroNode = inorderSuccessor(node4, node1);
        System.out.println(heroNode);

    }

    /**
    * @Description: 二叉搜索树的中序后继节点
    给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
    节点 p 的后继是值比 p.no 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
    * @Param: [root, p]
    * @return: com.li.binaryTree.HeroNode
    * @Date: 2022/6/27
    */
    public static HeroNode inorderSuccessor(HeroNode root, HeroNode p) {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }
}
