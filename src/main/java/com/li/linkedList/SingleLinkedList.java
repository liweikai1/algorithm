package com.li.linkedList;

import java.util.Stack;

class SingleLinkedList {

    //在对链表进行操作时，一种常用的技巧是添加一个哑节点(dummy node)，它的 next 指针指向链表的头节点。
    // 这样一来，我们就不需要对头节点进行特殊的判断了。

    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        LinkedList singleLinkedList = new LinkedList();

        //向链表中加入各个节点
        singleLinkedList.add(hero1);singleLinkedList.add(hero2);singleLinkedList.add(hero3);singleLinkedList.add(hero4);

        //打印原链表
        System.out.println("原来链表的情况~~");
        singleLinkedList.list();

        //链表反转
        System.out.println("反转单链表~~");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

//		System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
//		reversePrint(singleLinkedList.getHead());

		//链表中有效节点的个数
		System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));//2

		//获取倒数第K个节点
		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
		System.out.println("res=" + res);
    }

    /**
    * @Description: 将单链表反转
    * @Param: [head] 头节点
    * @return: void
    * @Date: 2022/6/7
    */
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null) {
            return ;
        }
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;// 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        //动脑筋
        while(cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端(把上一个摘出来的节点放在现在摘出来的节点的后面)
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next ;
    }

    /**
    * @Description: 翻转链表：利用栈的先进后出的特点，将各个节点压入到栈中，就实现了逆序打印的效果
    * @Param: [head]
    * @return: void
    * @Date: 2022/6/7
    */
    public static void reversePrint(HeroNode head) {
        if(head.next == null) {
            return;//空链表，不能打印
        }
        //创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while(cur != null) {
            stack.push(cur);
            cur = cur.next; //cur后移，这样就可以压入下一个节点
        }
        //将栈中的节点进行打印,pop 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop()); //stack的特点是先进后出
        }
    }

    /**
    * @Description: 查找单链表中的倒数第k个结点
    * @Param: [head, index]
    * @return: com.li.linkedList.HeroNode
    * @Date: 2022/6/7
    思路
    1. 编写一个方法，接收head节点，同时接收一个index
    2. index 表示是倒数第index个节点
    3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    5. 如果找到了，则返回该节点，否则返回null
    */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空，返回null
        if(head.next == null) {
            return null;//没有找到
        }
        //第一个遍历得到链表的长度(节点个数)
        int size = getLength(head);
        //第二次遍历  size-index 位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if(index <=0 || index > size) {
            return null;
        }
        //定义给辅助变量， for 循环定位到倒数的index
        HeroNode cur = head.next; //3 // 3 - 1 = 2
        for(int i =0; i< size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

   /**
   * @Description: 获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
   * @Param: [head]
   * @return: int
   * @Date: 2022/6/7
   */
    public static int getLength(HeroNode head) {
        if(head.next == null) { //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode cur = head.next;
        while(cur != null) {
            length++;
            cur = cur.next; //遍历
        }
        return length;
    }
    /**
    * @Description: 获取链表的中间结点
     * 思路：
     * 采用快慢指针，快指针比慢指针多走一格，当快指针走到终点时，慢指针走一半。
    * @Param: [head]
    * @return: com.li.linkedList.HeroNode
    * @Date: 2022/6/8
    */
    public static HeroNode middleNode(HeroNode head) {
        HeroNode fast = head ;
        HeroNode slow = head ;
        while (fast.next != null || fast.next.next != null){
            fast = fast.next.next ;
            slow = slow.next ;
        }
        if (fast.next == null){
            return slow ;
        }else{
            return slow.next ;
        }
    }
    /**
    * @Description: 合并两个链表
    合并前：l1->l2->l3
          l5->l6->l7
    合并后：l1->l5->l2->l6->l3->l7
    * @Param: [h1, h2]
    * @return: com.li.linkedList.HeroNode
    * @Date: 2022/6/9
    */
    public static void mergeNode(HeroNode h1 , HeroNode h2){
        while(h1 != null && h2 != null){
            HeroNode p1 = h1.next ;
            HeroNode p2 = h2.next ;
            h1.next = h2 ;
            h1 = p1 ;
            h2.next = h1 ;
            h2 = p2 ;
        }
    }


}
