package com.li.binaryTree;

/**
 * @Author: li wei kai
 * @Date: 2022/02/20/20:53
 * @Description:
 */
public class HeroNode {
    public int no ;
    public String name ;
    public HeroNode left ;
    public HeroNode right ;

    public HeroNode(int no) {
        this.no = no;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode(int no, String name, HeroNode left, HeroNode right) {
        this.no = no;
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
