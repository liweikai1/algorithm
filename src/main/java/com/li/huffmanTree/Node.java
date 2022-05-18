package com.li.huffmanTree;

import org.jetbrains.annotations.NotNull;

/**
 * @Author: li wei kai
 * @Date: 2022/02/21/21:56
 * @Description:
 */
public class Node implements Comparable<Node>{
    public int val ;
    public Node left ;
    public Node right ;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(@NotNull Node o) {
        return this.val - o.val;
    }
}
