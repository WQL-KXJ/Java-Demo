public class ordertree {
    public static void main(String[] args) {
        int[] WQL=new int[]{1,2,3,4,5,6};
        datawql a=new datawql(WQL);
        a.alter1(0);       //1,2,4,5,3,6
    }
}
class datawql{
    int[] datas;
    public datawql(int[] datas){
        this.datas=datas;
    }
    //前序遍历
    public void  front1(int index){//给出要遍历的起始节点的索引
        if(datas[index]!=0 && index<datas.length) {
            System.out.println(datas[index]);
        }
        if((index*2+1)<datas.length){
            front1(index*2+1);
        }
        if((index*2+2)<datas.length){
            front1(index*2+2);
        }
}

    //中序遍历
    public void  concre1(int index){//给出要遍历的起始节点的索引
        if((index*2+1)<datas.length){
            concre1(index*2+1);
        }
        if(datas[index]!=0 && index<datas.length) {
            System.out.println(datas[index]);
        }
        if((index*2+2)<datas.length){
            concre1(index*2+2);
        } }


    //中序遍历
    public void  alter1(int index){//给出要遍历的起始节点的索引
        if((index*2+1)<datas.length){
            alter1(index*2+1);
        }
        if(datas[index]!=0 && index<datas.length) {
            System.out.println(datas[index]);
        }
        if((index*2+2)<datas.length){
            alter1(index*2+2);
        } }
}