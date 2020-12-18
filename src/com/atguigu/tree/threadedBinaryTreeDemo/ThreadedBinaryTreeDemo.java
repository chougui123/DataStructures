package com.atguigu.tree.threadedBinaryTreeDemo;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {

        HeroNode node1 = new HeroNode(1, "LiMing");
        HeroNode node2 = new HeroNode(3, "Tom");
        HeroNode node3 = new HeroNode(6, "Jerry");
        HeroNode node4 = new HeroNode(8, "WangNiMa");
        HeroNode node5 = new HeroNode(10, "Danny");
        HeroNode node6 = new HeroNode(14, "XiaoHong");

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(node1);

        threadedBinaryTree.threadedNodes();

        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("编号为10的前驱节点为："+leftNode);
        System.out.println("编号为10的后继节点为："+rightNode);

        System.out.println("线索二叉树中序遍历为：");
        threadedBinaryTree.threadedList();
    }
}

class ThreadedBinaryTree{
    private  HeroNode root;

    private HeroNode pre=null;

    public void setRoot( HeroNode root) {
        this.root = root;
    }

    public void threadedNodes(){
        this.threadedNodes(root);
    }

    public void threadedList(){
        HeroNode node=root;
        while (node != null){
            while (node.getLeftType() == 0){
                node=node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1){
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }

    }

    public void threadedNodes(HeroNode node){
        if(node == null){
            return;
        }

        threadedNodes(node.getLeft());

        if( node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if(pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        threadedNodes(node.getRight());

    }

    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("该二叉树为空");
        }
    }

    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("该二叉树为空");

        }
    }

    public void postOrder(){
        if (this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("该二叉树为空");
        }
    }

    public  HeroNode preOrderSearch(int no){
        if(this.root != null){
            return this.root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    public  HeroNode infixOrderSearch(int no){
        if(this.root != null){
            return this.root.infixOrderSearch(no);
        }else {
            return null;
        }

    }

    public  HeroNode postOrderSearch(int no){
        if(this.root != null){
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    public void delNode(int no){
        if(this.root == null){
            System.out.println("此二叉树为空");
        } else {
            if(this.root.getNo() == no){
                this.root=null;
            }
            this.root.delNode(no);
        }
    }


}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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

    public  HeroNode getLeft() {
        return left;
    }

    public void setLeft( HeroNode left) {
        this.left = left;
    }

    public   HeroNode getRight() {
        return right;
    }

    public void setRight( HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public  HeroNode preOrderSearch(int no){
        System.out.println("进入前序遍历查找");
        if(this.no == no){
            return this;
        }
         HeroNode resNode=null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public  HeroNode infixOrderSearch(int no){
         HeroNode resNode=null;
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        System.out.println("进入中序遍历查找");
        if(this.no == no){
            return this;
        }

        if(this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    public  HeroNode postOrderSearch(int no){
        HeroNode resNode=null;
        if(this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }

        if(this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        System.out.println("进入后序遍历查找");
        if(this.no == no){
            return this;
        }
        return resNode;

    }

    public void delNode(int no){
        if(this.left != null && this.left.no == no){
            this.left=null;
            return;
        }
        if(this.right !=null && this.right.no == no){
            this.right=null;
            return;
        }
        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
            this.right.delNode(no);
        }
    }


}

