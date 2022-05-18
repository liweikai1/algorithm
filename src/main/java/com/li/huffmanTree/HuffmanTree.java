package com.li.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: li wei kai
 * @Date: 2022/02/21/22:01
 * @Description:
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13,7,8,3,29,6,1} ;
        Node root = creatHuffman(arr);
        preNode(root);

    }
    /**
    * @Description: 创建霍夫曼树
    * @Param: [arr]传递的数组
    * @return: void
    * @Date: 2022/2/22
    */
    public static Node creatHuffman(int[] arr){
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr){
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1){
            Collections.sort(nodes);
            System.out.println("nodes = " + nodes);
            //去除根节点权值最小的两棵二叉树
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            //构建一棵新的二叉树
            Node node = new Node(left.val + right.val);
            node.left = left ;
            node.right = right ;
            //从Nodes中删除处理过的两个二叉树。然后将新生成的二叉树加入进集合中
            nodes.remove(left) ;
            nodes.remove(right) ;
            nodes.add(node) ;
            System.out.println("第一次处理之后的霍夫曼树" + nodes);
        }
        return nodes.get(0) ;
    }

    public static void preNode(Node root){
        if (root == null){
            return ;
        }
        System.out.println("root = " + root);
        preNode(root.left);
        preNode(root.right);
    }

}
