public class chaintree {
    public static void main(String[] args) {
        //建立节点:定义6个节点
        predata a=new predata(1);
        predata b=new predata(2);
        predata c=new predata(3);
        predata d=new predata(4);
        predata e=new predata(5);
        predata f=new predata(6);
        //给他们建立关系
        //a点的左节点是b，a的右节点是c
        a.setLife(b);
        a.setRight(c);
        //b的左节点是d，右节点是e
        b.setLife(d);
        b.setRight(e);
        //c的右节点是f，没有左节点
        c.setRight(f);
        //将节点关系放进树里面
        tree wql=new tree(a);
        wql.front();//1，2，4，5，3，6
    }
}
//定义树把节点类的节点联系放进树
class tree{
    private predata treewql;
    public tree(predata treewql){
        this.treewql=treewql;
    }
    //从树类中调用遍历方法
    //前序遍历
    public void front(){
        if(treewql==null){
            System.out.println("树为空");
        }else{
            treewql.front();
        }
    }
    //中序遍历
    public void centre(){
        if(treewql==null){
            System.out.println("树为空");
        }else{
            treewql.centre();
        }
    }
    //后序遍历
    public void later(){
        if(treewql==null){
            System.out.println("树为空");
        }else{
            treewql.later();
        }
    }
}



//节点类
class predata{
    private predata life;//定义左子节点
    private predata right;//定义右子节点
    private int val;//给我树一个权值
    //初始化值
    public predata(int val){
        this.val=val;
    }
    //给当前节点设置它的左节点
    public void setLife(predata life) {
        this.life = life;
    }
    //给当前节点设置它左节点
    public void setRight(predata right) {
        this.right = right;
    }
    //toString方法
    @Override
    public String toString() {
        return "predata{" +
                "val=" + val +
                '}';
    }
    //前序遍历:先输出父节点，再输出左子节点，最后是右子节点
    public void front(){
        System.out.println(this);//前序遍历首先输当前节点也就是父节点

        if(this.life!=null){//输出左子节点，先判断左子节点是否为空，再递归输出左子节点
            this.life.front();
        }
        if(this.right!=null){//输出右子节点，先判断右子节点是否为空，再递归输出右子节点
            this.right.front();
        }
    }
    //中序遍历:先输出左子节点，再输出父节，最后是右子节点
    public void centre(){
        //中序遍历首先输当前节点也就是父节点
        if(this.life!=null){//输出左子节点，先判断左子节点是否为空，再递归输出左子节点
            this.life.centre();
        }
        //中间输出父节点
        System.out.println(this);
        if(this.right!=null){//输出右子节点，先判断右子节点是否为空，再递归输出右子节点
            this.right.centre();
        }
    }
    //后序遍历:先输出左子节点，再输出右子节点，最后是父节点
    public void later(){
        //中序遍历首先输当前节点也就是父节点
        if(this.life!=null){//输出左子节点，先判断左子节点是否为空，再递归输出左子节点
            this.life.later();
        }
        //中间输出右子节点
        if(this.right!=null){//输出右子节点，先判断右子节点是否为空，再递归输出右子节点
            this.right.later();
        }
        //最后输出父节点
        System.out.println(this);
    }
}