package com.li.binaryTree;

/**
 * @Author: li wei kai
 * @Date: 2022/02/19/17:05
 * @Description:定义节点的前序、中序、后序遍历方法；定义节点的前序、中序、后序查找方法
 */

/**
* @Description: 先创建HeroNode节点，用来执行前序，中序，后序遍历
* @Param:
* @return:
* @Date: 2022/2/19
*/
public class HeroNode {
    private int no ;
    private String name ;
    private HeroNode left ;
    private HeroNode right ;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
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
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
    * @Description: 编写前序遍历的方法
    * @Param:
    * @return:
    * @Date: 2022/2/19
    */
    public void preOrder(){
        System.out.println(this); //先输出父节点
        //递归向左子树前序遍历
        if(this.left != null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right != null){
            this.right.preOrder();
        }
    }
    /**
    * @Description: 编写中序遍历的方法
    * @Param: []
    * @return: void
    * @Date: 2022/2/19
    */
    public void infixOrder(){
        //递归向左子树前序遍历
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this); //输出父节点
        //递归向右子树前序遍历
        if(this.right != null){
            this.right.infixOrder();
        }
    }
    /**
    * @Description: 编写后序遍历的方法
    * @Param: []
    * @return: void
    * @Date: 2022/2/19
    */
    public void postOrder(){
        //递归向左子树前序遍历
        if(this.left != null){
            this.left.postOrder();
        }
        //递归向右子树前序遍历
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this); //输出父节点
    }

    /**
     * @Description: 前序查找
     * @Param: [no]需要查找的指定编号
     * @return: com.li.BinaryTree.HeroNode
     * @Date: 2022/2/20
     */
    public HeroNode preSearch(int no){
        System.out.println("进去前序查找");
        //比较当前节点是否为要查找的节点
        if (this.no == no){
            return this ;
        }
        //1.判断当前节点的左节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到节点则返回
        HeroNode reNode = null ;
        if (this.left != null){
            reNode = this.left.preSearch(no) ;
        }
        if (reNode != null){ //左子树找到了
            return reNode ;
        }
        //1.判断当前节点的右节点是否为空，如果不为空，则递归前序查找
        //2.如果右递归前序查找，找到节点则返回
        if (this.right != null){
            reNode = this.right.preSearch(no) ;
        }
        return reNode ;
    }
    /**
    * @Description: 中序查找
    * @Param: [no] 指定要查找的编号
    * @return: com.li.BinaryTree.HeroNode
    * @Date: 2022/2/20
    */
    public HeroNode infixSearch(int no){
        //先判断当前节点的左子节点是否为空,不为空的话进行左子节点递归中序查找
        HeroNode resNode = null ;
        if (this.left != null){
            resNode = this.left.infixSearch(no) ;
        }
        if (resNode != null){
            return resNode ;
        }
        //当前节点的编号正好是要找的编号
        System.out.println("进去中序查找");
        if (this.no == no){
            return this ;
        }
        //1.判断当前节点的右节点是否为空，如果不为空，则递归前序查找
        //2.如果右递归前序查找，找到节点则返回
        if (this.right != null){
            resNode = this.right.infixSearch(no) ;
        }
        return resNode ;

    }
    /**
    * @Description: 后序查找
    * @Param: [no]
    * @return: com.li.BinaryTree.HeroNode
    * @Date: 2022/2/20
    */
    public HeroNode postSearch(int no){
        //先判断当前节点的左子节点是否为空,不为空的话进行左子节点递归中序查找
        HeroNode resNode = null ;
        if (this.left != null){
            resNode = this.left.postSearch(no) ;
        }
        if (resNode != null){
            return resNode ;
        }
        //1.判断当前节点的右节点是否为空，如果不为空，则递归前序查找
        //2.如果右递归前序查找，找到节点则返回
        if (this.right != null){
            resNode = this.right.postSearch(no) ;
        }
        if (resNode != null){
            return resNode ;
        }
        //当前节点的编号正好是要找的编号
        System.out.println("进去后序查找");
        if (this.no == no){
            return this ;
        }
        return resNode ;
    }

}
