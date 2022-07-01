package com.li.binaryTree;

import java.util.*;

/**
 * @Author: li wei kai
 * @Date: 2022/02/20/20:45
 * @Description:
 */
public class BinaryTreeDemo {

    public static ArrayList<Integer>  list = new ArrayList<>();
    public static int depth ;
    public static int val ;

    public static void main(String[] args) {

        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node1 = new HeroNode(2, "吴用");
        HeroNode node2 = new HeroNode(3, "卢俊义");
        HeroNode node3 = new HeroNode(4, "林冲");
        HeroNode node4 = new HeroNode(5, "关胜");
        HeroNode node5 = new HeroNode(6, "武松");
        HeroNode node6 = new HeroNode(7, "鲁智深");
        //创建二叉树节点
        binaryTree.setNode(root);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5 ;
        node2.right = node6 ;

        int[] preOrder = {1,2,4,5,3,6,7} ;
        int[] inOrder =  {4,2,5,1,6,3,7} ;
        int[] posOrder = {4,5,2,6,7,3,1} ;
        ArrayList<Integer> li = new ArrayList<>();

        //前序遍历
      /*  preNode(root , list);*/
       /* delNode(root,3);
         preNode(root , list);*/

        //中序遍历
       /* infixNode(root , list);*/
       /* delNode(root,1);
        System.out.println("11111111");
        infixNode(root , list);*/

        //后续遍历
       /* postNode(root,list) ;*/

        //求该树的最大深度
        int depth = maxDepth(root);
        System.out.println("depth =" + depth);

        //根节点到叶子节点的路径数字之和
       /* int path = sumNumbers(root);
        System.out.println("sum =" + path);*/

        //二叉树的右视图
       /* rightSideView(root , 0);
        System.out.println(list);*/

       /* int countNodes = countNodes(root);
        System.out.println("完全二叉树的节点个数 = " + countNodes);*/

       /* HeroNode1 ancestor = lowestCommonAncestor(root, node3, node4);
        System.out.println("二叉搜索树的最近公共祖先为 ：" + ancestor);*/

        //二叉树的最近公共祖先
        /*HeroNode1 ancestor = CommonAncestor(root, node1, node4);
        System.out.println("二叉树的最近公共祖先为：" + ancestor);*/

        //二叉树的层序遍历
        /*List<List<Integer>> list =levelOrder(root);
        System.out.println("二叉树的层序遍历为：" + list);*/

        //二叉树的锯齿形层序遍历
       /* List<List<Integer>> lists =zigzagLevelOrder(root);
        System.out.println("二叉树的锯齿形层序遍历为：" + lists);*/
        //二叉树的锯齿形层序遍历
        /*List<List<Integer>> li =zigzagLevelOrder1(root);
        System.out.println("二叉树的锯齿形层序遍历为：" + li);*/

        //二叉树的镜像
        /*boolean mirrorTree = mirrorTree(root.left, root.right);
        System.out.println("该二叉树是否为对称二叉树"+ mirrorTree);*/

       /* //路径总和
        List<List<Integer>> lists = pathSum(root, 8);
        System.out.println("二叉树中和为某一值的路径是："+lists);*/

        //平衡二叉树
        /*boolean balanced = isBalanced(root);
        System.out.println("该二叉树是否是平衡二叉树：" + balanced);*/

        //重建二叉树
        /*HeroNode1 buildTree = buildTree(preorder, inorder);
        System.out.println(buildTree);*/

        //二叉树最底层最左边的值
       /* int bottomLeftValue = findBottomLeftValue(root);
        System.out.println(bottomLeftValue);*/

        //向下的路径节点之和
        /*int pathSomeSum = pathSomeSum(root, 7);
        System.out.println(pathSomeSum);*/

    }
    /**
    * @Description: 迭代法：前序遍历
    * @Param: [root, res]
    * @return: void
    * @Date: 2022/2/21
    */
    public static void preNode(HeroNode root , List<Integer> res){
        if (root == null){
            return ;
        }
        res.add(root.no) ;
        System.out.println(root);
        preNode(root.left , res);
        preNode(root.right , res);

    }
    /**
     * @Description: 迭代法：中序遍历
     * @Param: [root, res]
     * @return: void
     * @Date: 2022/2/21
     */
    public static void infixNode(HeroNode root , List<Integer> res){
        if (root == null){
            return ;
        }
        infixNode(root.left , res);
        res.add(root.no) ;
        System.out.println(root);
        infixNode(root.right , res);

    }
    /**
     * @Description: 迭代法：后序遍历
     * @Param: [root, res]
     * @return: void
     * @Date: 2022/2/21
     */
    public static void postNode(HeroNode root , List<Integer> res){
        if (root == null){
            return ;
        }
        postNode(root.left , res);
        postNode(root.right , res);
        res.add(root.no) ;
        System.out.println(root);

    }
    /**
    * @Description: 删除节点
    * @Param:
    * @return: void
    * @Date: 2022/2/21
    */
    public static void delNode(HeroNode root , int no){
        if (root != null && root.no == no){
            root = null ;
            return;
        }
        if (root.left != null && root.left.no == no){
            root.left = null ;
            return;
        }
        if (root.right != null && root.right.no == no){
            root.right = null ;
            return;
        }
        if (root.left != null){
            delNode(root.left , no);
        }
        if (root.right != null){
            delNode(root.right , no);
        }

    }
    /**
    * @Description: 求该树的最大深度，  深度优先搜索
    * @Param: [root]
    * @return: int
    * @Date: 2022/2/28
    */
    public static int maxDepth(HeroNode root) {
        if(root == null){
            return 0 ;
        }
        int leftDepth = maxDepth(root.left) ;
        int rightDepth = maxDepth(root.right) ;
        return Math.abs(leftDepth - rightDepth) + 1 ;
    }
    /**
    * @Description: 求该树的最大深度，  广度优先搜索
    * @Param:
    * @return:
    * @Date: 2022/2/28
    */
   /*public static int maxDepth(HeroNode1 root) {
       if(root == null){
           return 0 ;
       }
       Queue<HeroNode1> queue = new LinkedList<HeroNode1>() ;
       queue.offer(root) ;
       int ans = 0 ;
       while(!queue.isEmpty()){
           int size = queue.size() ;
           while (size > 0){
               HeroNode1 node = queue.poll();
               if (node.left != null){
                   queue.offer(node.left) ;
               }
               if (node.right != null){
                   queue.offer(node.right) ;
               }
               size -- ;
           }
           ans ++ ;
       }
       return ans ;
   }*/
    /**
    * @Description: 求根节点到叶节点数字之和,  深度优先搜索算法
    * @Param: [root, sum]
    * @return: int
    * @Date: 2022/2/27
    */
   /* public static int sumNumbers(HeroNode root , int sum){
        if(root == null){
            return 0 ;
        }
        sum =sum * 10 + root.no ;
        if(root.left == null && root.right == null){
            return sum ;
        }*//*else{
            return sumNumbers(root.left , sum) + sumNumbers(root.right , sum) ;
        }*//*
        int a = sumNumbers(root.left,sum) ;
        int b = sumNumbers(root.right,sum) ;
        int c = a + b ;
        return c ;
    }*/
    /**
    * @Description: 求根节点到叶节点数字之和,  广度优先搜索算法
    * @Param: [root]
    * @return: int
    * @Date: 2022/2/27
    */
    public static int sumNumbers(HeroNode root) {
        if(root == null){
            return 0 ;
        }
        Queue<HeroNode> queue = new LinkedList<>() ;
        Queue<Integer> num = new LinkedList<>() ;
        queue.offer(root) ;
        num.offer(root.no) ;
        int sum = 0 ;
        while(!queue.isEmpty()){
            HeroNode node = queue.poll() ;
            int nums = num.poll() ;
            if(node.left == null && node.right == null){
                sum += nums ;
            }else {
                if (node.left != null){
                    queue.offer(node.left) ;
                    num.offer(nums * 10 + node.left.no) ;
                }
                if (node.right != null){
                    queue.offer(node.right) ;
                    num.offer(nums * 10 + node.right.no) ;
                }
            }
        }
        return sum ;
    }
    /**
    * @Description: 二叉树的右视图
    * @Param: [root, depth]
    * @return: void
    * @Date: 2022/2/28
    */
    public static void rightSideView (HeroNode root , int depth){
        if(root == null){
            return ;
        }
        if(depth == list.size()){
            list.add(root.no) ;
        }
        depth++ ;
        rightSideView(root.right , depth) ;
        rightSideView(root.left , depth) ;
    }
    /**
    * @Description: 完全二叉树的节点个数
    * @Param: [root, sum]
    * @return: int
    * @Date: 2022/3/3
    */
    public static int countNodes(HeroNode root){
        if(root == null){
            return 0  ;
        }
        int i = countNodes(root.left);
        int j = countNodes(root.right);
        return i + j + 1 ;
    }
    /**
    * @Description: 利用完全二叉树的性质计算节点个数
    * @Param: [root]
    * @return: int
    * @Date: 2022/3/9
    */
    public static int countNode(HeroNode root) {
        if(root == null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNode(root.right) + (1<<left);
        }else{
            return countNode(root.left) + (1<<right);
        }
    }
    /**
    * @Description: 计算二叉树的层数
    * @Param: [root]
    * @return: int
    * @Date: 2022/3/9
    */
    private static int countLevel(HeroNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }
    /**
    * @Description: 二叉搜索树的最近公共祖先
    * @Param: [root, p, q]
    * @return: TreeNode
    * @Date: 2022/3/9
    */
    public static HeroNode lowestCommonAncestor(HeroNode root, HeroNode p, HeroNode q) {
        if ((root.no - p.no) * (root.no - q.no) <= 0){
            return root ;
        }
        if ((root.no - p.no) > 0){
            return lowestCommonAncestor(root.left , p , q) ;
        }else {
            return lowestCommonAncestor(root.right , p , q) ;
        }
    }
    /**
     * @Description: 二叉树的最近公共祖先
     * @Param: [root, p, q]
     * @return: TreeNode
     * @Date: 2022/3/9  返回值分为四种情况：
    据 left 和 right ，可展开为四种情况；
    当 left 和 right 同时为空 ：说明 root 的左/右子树中都不包含 p,q ，返回 null ；
    当 left 和 right 同时不为空 ：说明 p, q分列在 root的 侧（分别在 左/右子树），因此 root为最近公共祖先，返回 root ；
    当 left 为空 ，right 不为空 ：p,q 都不在 root的左子树中，直接返回 right 。具体可分为两种情况：
        p,q其中一个在 root的 右子树 中，此时 right指向 p假设为p）；
        p,q两节点都在 root的 右子树 中，此时的 right指向 最近公共祖先节点 ；
    当 left不为空 ， right为空 ：与情况 3. 同理；
     */
    public static HeroNode CommonAncestor(HeroNode root, HeroNode p, HeroNode q) {
        if(root == null || root == p || root == q){
            return root ;
        }
        HeroNode left = CommonAncestor(root.left , p , q) ;
        HeroNode right = CommonAncestor(root.right , p ,q) ;
        if(left == null){
            return right ;
        }
        if(right == null){
            return left ;
        }
        return root ;
    }
    /**
    * @Description: 二叉树的层序遍历，每一层的遍历结果作为一个数组存放
    * @Param: [root]
    * @return: java.util.List<java.util.List<java.lang.Integer>>
    * @Date: 2022/3/29
    */
    public static List<List<Integer>> levelOrder(HeroNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>() ;
        }
        List<List<Integer>> list = new ArrayList<>() ;
        Queue<HeroNode> queue = new LinkedList() ;
        queue.offer(root) ;
        while(!queue.isEmpty()){
            List<Integer> val = new ArrayList<>() ;
            int size = queue.size() ;
            for(int i = 0 ; i < size ; i++){
                HeroNode node = queue.poll() ;
                val.add(node.no) ;
                if(node.left != null){
                    queue.offer(node.left) ;
                }
                if(node.right != null){
                    queue.offer(node.right) ;
                }
            }
            list.add(val) ;
        }
        return list ;
    }
    /**
    * @Description: 二叉树的锯齿形层序遍历
     *（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。）
    * @Param: [root]
    * @return: java.util.List<java.util.List<java.lang.Integer>>
    * @Date: 2022/3/29
    采用双线链表法，偶数层将值添加进临时双线链表的尾部，奇数层添加进双线链表的头部
    */
    public static List<List<Integer>>zigzagLevelOrder1(HeroNode root) {
        List<List<Integer>> list = new ArrayList<>() ;
        if(root == null) return list ;
        Queue<HeroNode> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while(!queue.isEmpty()){
            int size = queue.size() ;
            LinkedList<Integer> res = new LinkedList<>() ;
            for(int i = 0 ; i < size ; i++){
                HeroNode node = queue.poll() ;
                if(list.size() % 2 == 1){
                    res.addFirst(node.no) ;
                }else{
                    res.addLast(node.no) ;
                }
                if(node.left != null){
                    queue.offer(node.left) ;
                }
                if(node.right != null){
                    queue.offer(node.right) ;
                }
            }
            list.add(res) ;
        }
        return list ;
    }

    /**
    * @Description: 二叉树的锯齿形层序遍历
     * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
    * @Param: [root]
    * @return: java.util.List<java.util.List<java.lang.Integer>>
    * @Date: 2022/3/14
     采用奇偶分层法，分层操作，步骤较复杂，不推荐使用
    */
    public static List<List<Integer>> zigzagLevelOrder(HeroNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>() ;
        }
        int depth = 2 ;
        List<List<Integer>> list = new ArrayList<>() ;
        Deque<HeroNode> deque = new LinkedList() ;
        deque.offer(root) ;
        while(!deque.isEmpty()){
            List<Integer> val = new ArrayList<>() ;
            int size = deque.size() ;
            if(depth % 2 == 0){
                for(int i = 0 ; i < size ; i++){
                    HeroNode node = deque.pollFirst() ;
                    val.add(node.no) ;
                    if(node.left != null){
                        deque.offerLast(node.left) ;
                    }
                    if(node.right != null){
                        deque.offerLast(node.right) ;
                    }
                }
            }else{
                for(int i = 0 ; i < size ; i++){
                    HeroNode node = deque.pollLast() ;
                    val.add(node.no) ;
                    if(node.right != null){
                        deque.offerFirst(node.right) ;
                    }
                    if(node.left != null){
                        deque.offerFirst(node.left) ;
                    }
                }
            }
            list.add(val) ;
            depth += 1 ;
        }
        return list ;
    }
   /**
   * @Description: 判断该二叉树是不是对称二叉树：
    * 对称二叉树的定于：对于树中任意两个对称节点 L和 R，一定有：
    * L.val = R.val ：即此两对称节点值相等。
    * L.left.val = R.right.val ：即 L 的左子节点和 R 的右子节点对称；
    * L.right.val = R.left.val ：即 L 的右子节点和 R 的左子节点对称。
   根据以上规律，考虑从顶至底递归，判断每对节点是否对称，从而判断树是否为对称二叉树。
   * @Param: [root]
   * @return: com.li.BinaryTree.HeroNode1
   * @Date: 2022/3/29
   */
    public static boolean mirrorTree(HeroNode p , HeroNode q) {
        if(p == null && q == null){
            return true ;
        }
        if(p == null || q == null || p.no != q.no ){
            return false ;
        }
        return mirrorTree(p.left , q.right) && mirrorTree(p.right , q.left) ;
    }
    /**
    * @Description: 树的子结构；输入两棵二叉树 A 和 B ，判断 B 是不是 A 的子结构。
     * (约定空树不是任意一个树的子结构) B是A的子结构， 即 A中有出现和B相同的结构和节点值。
    * @Param: [A, B]
    * @return: boolean
    * @Date: 2022/3/30
     * 解题思路：
 若树B是树A的子结构，则子结构的根节点可能为树A的任意一个节点。判断树B是否是树A的子结构，需完成以下两步工作：
    1.先序遍历树 A中的每个节点 n_A；（对应函数 isSubStructure(A, B)）
    2.判断树 A中 以 n_A为根节点的子树 是否包含树 B。（对应函数 isSubStructureDfs(A, B)）

    */
    public static boolean isSubStructure(HeroNode A, HeroNode B) {
        if(A == null || B == null)  return false ;
        if(A.no == B.no && isSubStructureDfs(A.left , B.left) && isSubStructureDfs(A.right , B.right)){
            return true;
        }else{
            return isSubStructure(A.left , B) || isSubStructure(A.right , B) ;
        }

    }
    public static boolean isSubStructureDfs(HeroNode A , HeroNode B){
        if(B == null) return true ;
        if(A == null) return false ;
        if(A.no == B.no){
            return isSubStructureDfs(A.left , B.left) && isSubStructureDfs(A.right , B.right) ;
        }else{
            return false ;
        }
    }
    /**
    * @Description:二叉树中和为某一值的路径：
    给你二叉树的根节点 root 和一个整数目标和 target ，找出所有从根节点到叶子节点
    路径总和等于给定目标和的路径。
    示例1：
        输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        输出：[[5,4,11,2],[5,8,4,5]]

    * @Param: [root, target]
    * @return: java.util.List<java.util.List<java.lang.Integer>>
    * @Date: 2022/4/5
    */
    public static List<List<Integer>> pathSum(HeroNode root, int target) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        recur(root, target , list ,res);
        return list;
    }

    //List<>数组只能删除指定下标的元素比如（res.remove(2)），在不知道数组长度的时候无法删除最后一个元素
    //而在本题中，回溯至上一个节点就是用删除当前节点的方法，所以用LinkedList更方便
    public static void recur(HeroNode root, int target , LinkedList<List<Integer>> list , LinkedList<Integer> res) {
        if(root == null) return;
        res.add(root.no);
        target -= root.no;
        if(target == 0 && root.left == null && root.right == null)
            list.add(new LinkedList(res));
        recur(root.left, target , list , res);
        recur(root.right, target , list , res);
        //最关键一步，用于回溯至上一个节点
        res.removeLast();
    }

    /**
    * @Description:平衡二叉树：
    输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度
    相差不超过1，那么它就是一棵平衡二叉树。
    示例1 ：
        给定二叉树 [3,9,20,null,null,15,7]
     3
    / \
    9  20
      /  \
    15   7
        返回 true 。

    * @Param: [root]
    * @return: boolean
    * @Date: 2022/4/8
     分析：
    此树的深度等于左子树的深度与右子树的深度中的最大值 +1 。
    */
    public static boolean isBalanced(HeroNode root) {
        return dfsBalanced(root) != -1;
    }

    private static int dfsBalanced(HeroNode root) {
        if (root == null) return 0;
        int left = dfsBalanced(root.left);
        if(left == -1) return -1;
        int right = dfsBalanced(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    /**
    * @Description:重建二叉树：
    输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    示例1：
        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        Output: [3,9,20,null,null,15,7]

    * @Param: [preorder, inorder]
    * @return: com.li.binaryTree.HeroNode1
    * @Date: 2022/4/9
     思路：
    前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
    中序遍历性质： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序。
    根据以上性质，可得出以下推论：
    1.前序遍历的首元素为树的根节点 node 的值。
    2.在中序遍历中搜索根节点 node 的索引 ，可将中序遍历划分为 [ 左子树 | 根节点 | 右子树 ] 。
    3.根据中序遍历中的左（右）子树的节点数量，可将前序遍历划分为 [ 根节点 | 左子树 | 右子树 ]
    通过以上三步，可确定 三个节点 ：1.树的根节点、2.左子树根节点、3.右子树根节点。
    根据「分治算法」思想，对于树的左、右子树，仍可复用以上方法划分子树的左右子树。
    */
    public static HeroNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer , Integer> map = new HashMap<>() ;
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i] , i) ;
        }
        return recur(preorder , map ,0 , 0 , inorder.length - 1) ;
    }
    public static HeroNode recur(int[] preorder , HashMap<Integer,Integer> map , int root , int left , int right){
        if(left > right) return null ;
        HeroNode node = new HeroNode(preorder[root]) ;
        int index = map.get(preorder[root]) ;
        node.left = recur(preorder , map ,root+1 , left , index - 1) ;
        node.right = recur(preorder , map, index - left + root + 1, index + 1 , right) ;
        return node ;
    }
    /**
     * @Description: 二叉树最底层最左边的值
      dfs(深度优先搜索遍历方法)
    * @Param: [root]
    * @return: int
    * @Date: 2022/6/16
    */
    public static int findBottomLeftValue(HeroNode root) {
        depth = 0 ;
        dfs(root,0) ;
        return val ;
    }
    public static void dfs(HeroNode root ,  int maxHeight){
        if (root == null) return  ;
        if (maxHeight == depth){
            val = root.no ;
            depth++ ;
        }
        dfs(root.left,maxHeight+1);
        dfs(root.right,maxHeight+1);
    }

    /**
    * @Description: 二叉树最底层最左边的值
      bfs(广度优先搜索遍历方法)
    * @Param: [root]
    * @return: int
    * @Date: 2022/6/16
    */
   /* public static int findBottomLeftValue(HeroNode root) {
        Queue<HeroNode> qu = new LinkedList<>() ;
        qu.offer(root) ;
        int val = root.no ;
        while (!qu.isEmpty()){
            int size = qu.size() ;
            for(int i = 0 ; i < size ; i++){
                HeroNode node = qu.poll() ;
                if(i == 0){
                    val = node.no ;
                }
                if (node.left != null) qu.offer(node.left) ;
                if (node.right != null) qu.offer(node.right) ;
            }
        }
        return val ;
    }*/

    /**
    * @Description: 向下的路径节点之和
    给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于
    targetSum 的路径的数目。
    路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
    * @Param: [root, targetSum]
    * @return: int
    * @Date: 2022/6/21
    穷举所有的可能，我们访问每一个节点 node，检测以 node 为起始节点且向下延深的路径有多少种。
    我们递归遍历每一个节点的所有可能的路径，然后将这些路径数目加起来即为返回结果。
    */
    // 前缀和思路
    public static int pathSomeSum(HeroNode root, int targetSum) {
        if (root == null) return 0 ;
        HashMap<Integer , Integer> map = new HashMap<>() ;
        map.put(0 , 1) ;
        int ans = 0 ;
        prefixAnd(root , map , ans , 0 , targetSum);
        return ans ;
    }
    public static void prefixAnd(HeroNode root , HashMap<Integer,Integer> map , int ans , int sum , int targetSum){
        sum += root.no ;

        // 存在x，则x的出现次数即是符合条件的序列的出现次数
        if(map.containsKey(targetSum - sum)){
            ans += map.get(targetSum - sum) ;
        }

        // 当前节点的前缀和出现次数+1
        map.put(sum , map.getOrDefault(sum , 0) + 1) ;
        if (root.left != null){
            prefixAnd(root.left , map , ans , sum , targetSum);
        }
        if (root.right != null){
            prefixAnd(root.right , map , ans , sum , targetSum);
        }
        // 当前节点的前缀和出现次数-1，即向上返回了
        map.put(sum , map.get(sum) - 1) ;
    }


}
