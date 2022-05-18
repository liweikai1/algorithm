package com.li.binaryTree;

/**
 * @Author: li wei kai
 * @Date: 2022/02/19/17:02
 * @Description:定义二叉树的前序、中序、后序遍历方法；定义二叉树的前序、中序、后序查找方法
 */
public class BinaryTree {
    private HeroNode root ;

    public void setNode(HeroNode1 node) {
        this.node = node;
    }

    public HeroNode1 node ;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    /**
    * @Description: 前序遍历
    * @Param: []
    * @return: void
    * @Date: 2022/2/19
    */
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    /**
    * @Description: 中序遍历
    * @Param: []
    * @return: void
    * @Date: 2022/2/19
    */
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    /**
     * @Description: 后序遍历
     * @Param: []
     * @return: void
     * @Date: 2022/2/19
     */
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    /**
    * @Description: 二叉树前序查找
    * @Param: [no]
    * @return: com.li.BinaryTree.HeroNode
    * @Date: 2022/2/20
    */
    public HeroNode preSearch(int no){
        if (root != null){
            return root.preSearch(no) ;
        }else {
            return null ;
        }
    }
    /**
    * @Description: 二叉树中序查找
    * @Param: [no]
    * @return: com.li.BinaryTree.HeroNode
    * @Date: 2022/2/20
    */
    public HeroNode infixSearch(int no){
        if (root != null){
            return root.infixSearch(no) ;
        }else {
            return null ;
        }
    }
    /**
    * @Description: 二叉树后序查找
    * @Param: [no]
    * @return: com.li.BinaryTree.HeroNode
    * @Date: 2022/2/20
    */
    public HeroNode postSearch(int no){
        if (root != null){
            return root.postSearch(no) ;
        }else {
            return null ;
        }
    }
}
