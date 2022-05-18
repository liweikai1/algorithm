package com.li.linkedList;

/**
 * @Author: li wei kai
 * @Date: 2022/03/22/21:21
 * @Description:
 */

/**
* @Description: 创建实体类，HeroNode 为该链表中的节点实体类，每一个 Hero 为一个节点。
* @Param: 
* @return: 
* @Date: 2022/3/22
*/
public class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点
    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}
