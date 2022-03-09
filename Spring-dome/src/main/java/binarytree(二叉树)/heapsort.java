import java.util.Arrays;

public class heapsort {
    public static void main(String[] args) {
int[] a=new int[]{2,3,1,6,4};
heap1 s=new heap1(a);

    }
}

//将堆进行排序
class hea1sort{
    heap1 c;
    public hea1sort(heap1 c){
        this.c=c;
    }
    public void sort(){
        for(int a=c.a.length/2-1;a>=0;a--){
            c.adjustheap(a);
        }
    }
}

//定义一个堆
class heap1{
    int[] a;
    public heap1(int[] a){
        this.a=a;
    }
    //将数组的二叉树转化成一个堆
    public void adjustheap(int i){//非叶子节点的索引
        int[] n=a;
        int temp=n[i];//保存当前节点的值
        for(int i1=i*2+1; i1>=0; i1=i*2+1){
            //接收当前节点得到左节点(i*2+1)，判断左节点是否比右节点大，如果比右节点小就把左节点的索引改成右索引
            if(i1+1<n.length && n[i1+1] >n[i1]){
                i1++;
            }
            //判断当前非叶子节点的根节点是是否比子节点大，如果小就把子节点的值赋给当前节点也就是a[i]
            if(i1+1<n.length && n[i] < n[i1]){
                n[i]=n[i1];
                i=i1;//把i(当前的父节点索引)换成子节点索引
            }else {
                break;//这个方法只判断一个非叶子节点
            }
            n[i]=temp;//如果前后的if条件符号就把之前父节点的值再给子节点
        }
    }

}


