package com.li.dynamicProgram;

import com.li.binaryTree.BinaryTree;
import com.li.binaryTree.HeroNode1;

/**
 * @Author: li wei kai
 * @Date: 2022/05/10/11:28
 * @Description:leetcode T337 题目：打家劫舍III
 题目：
小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。除了 root 之外，每栋房子有且只有
一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 
示例 1:
    输入: root = [3,2,3,null,3,null,1]
    输出: 7
    解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
示例 2:
    输入: root = [3,4,5,1,3,null,1]
    输出: 9
    解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 */
public class robIII {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode1 root = new HeroNode1(1, "宋江");
        HeroNode1 node1 = new HeroNode1(2, "吴用");
        HeroNode1 node2 = new HeroNode1(3, "卢俊义");
        HeroNode1 node3 = new HeroNode1(4, "林冲");
        HeroNode1 node4 = new HeroNode1(5, "关胜");
        HeroNode1 node5 = new HeroNode1(6, "武松");
        HeroNode1 node6 = new HeroNode1(7, "鲁智深");
        //创建二叉树节点
        binaryTree.setNode(root);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5 ;
        node2.right = node6 ;

        int rob = rob(root);
        System.out.println(rob);
    }
    public static int rob(HeroNode1 root) {
        int[] result = robTree(root) ;
        return Math.max(result[0] , result[1]) ;
    }
    //动态规划思路： 动态规划其实就是使⽤状态转移容器来记录状态的变化，这⾥可以使⽤⼀个⻓度为2的数组，记录当前
    // 节点偷与不偷所得到的的最⼤⾦钱。这道题⽬算是树形dp的⼊⻔题⽬，因为是在树上进⾏状态转移，我们在讲解⼆叉树
    // 的时候说过递归三部曲，那么下⾯我以递归三部曲为框架，其中融合动规五部曲的内容来进⾏讲解。
    //1. 确定递归函数的参数和返回值：这⾥我们要求⼀个节点 偷与不偷的两个状态所得到的⾦钱，那么返回值就是⼀个
    //   ⻓度为2的数组。参数为当前节点。
    //   dp数组以及下标的含义：下标为0记录不偷该节点所得到的的最⼤⾦钱，下标为1记录偷该节点所得到的的最⼤⾦钱。
    //   所以本题dp数组就是⼀个⻓度为2的数组！
    //2. 确定终⽌条件：在遍历的过程中，如果遇到空间点的话，很明显，⽆论偷还是不偷都是0，所以就返回{0，0}
    //   这也相当于dp数组的初始化
    //3. 确定遍历顺序：⾸先明确的是使⽤后序遍历。 因为通过递归函数的返回值来做下⼀步计算。后序遍历可以比较左节点和父节点的值，以便选择头父节点还是偷子节点
    //   通过递归左节点，得到左节点偷与不偷的⾦钱。
    //   通过递归右节点，得到右节点偷与不偷的⾦钱。
    //4. 确定单层递归的逻辑：如果是偷当前节点，那么左右孩⼦就不能偷，val1 = cur.val + left[0] + right[0];
    //   如果不偷当前节点，那么左右孩⼦就可以偷，⾄于到底偷不偷⼀定是选⼀个最⼤的，所以：
    //   val2 =max(left[0], left[1]) + max(right[0], right[1]);
    //   最后当前节点的状态就是{val2, val1}; 即：{不偷当前节点得到的最⼤⾦钱，偷当前节点得到的最⼤⾦钱}
    public static int[] robTree(HeroNode1 root){
        if(root == null){
            return new int[]{0 , 0} ;
        }
        int[] left = robTree(root.left) ;
        int[] right = robTree(root.right) ;
        int val1 = root.no + left[0] + right[0] ;
        int val2 = Math.max(left[0] , left[1]) + Math.max(right[0] , right[1]) ;
        return new int[]{val2 , val1} ;
    }
}
