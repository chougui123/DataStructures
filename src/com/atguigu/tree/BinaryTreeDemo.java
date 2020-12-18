package com.atguigu.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        HeroNode node1 = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"宋江");
        HeroNode node5 = new HeroNode(5,"武松");
        binaryTree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
     /*   System.out.println("前序遍历结果：");
        binaryTree.preOrder();
        System.out.println("中序遍历结果：");
        binaryTree.infixOrder();
        System.out.println("后序遍历结果：");
        binaryTree.postOrder();*/

     /*   System.out.println("前序遍历查找：");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if(resNode != null){
            System.out.printf("找到的信息为no=%d,name=%s",resNode.getNo(),resNode.getName());
        }else {
            System.out.printf("没有找到编号为%d",5);
        }*/
      /*  System.out.println("中序遍历查找：");
        HeroNode resNode = binaryTree.infixOrderSearch(5);
        if(resNode != null){
            System.out.printf("找到的信息为no=%d,name=%s",resNode.getNo(),resNode.getName());
        }else {
            System.out.printf("没有找到编号为%d",5);
        }*/
   /*     System.out.println("后序遍历查找：");
        HeroNode resNode = binaryTree.postOrderSearch(5);
        if(resNode != null){
            System.out.printf("找到的信息为no=%d,name=%s",resNode.getNo(),resNode.getName());
        }else {
            System.out.printf("没有找到编号为%d",5);
        }
*/

        System.out.println("删除前：");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("删除后：");
        binaryTree.preOrder();
    }
}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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

    public HeroNode preOrderSearch(int no){
        if(this.root != null){
            return this.root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no){
        if(this.root != null){
            return this.root.infixOrderSearch(no);
        }else {
            return null;
        }

    }

    public HeroNode postOrderSearch(int no){
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

    public HeroNode preOrderSearch(int no){
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

    public HeroNode infixOrderSearch(int no){
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

    public HeroNode postOrderSearch(int no){
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
