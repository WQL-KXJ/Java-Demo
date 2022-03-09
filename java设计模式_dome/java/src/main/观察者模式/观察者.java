import java.util.ArrayList;

public class 观察者 {
    public static void main(String[] args) {
Bond n=new Bond();
n.add(new WQL());
n.add(new FUQING());
n.setS(100);

    }
}
 interface abBond{
  abstract public void add(observer a);
  abstract  public void remove(observer a);
  abstract public void nofyity();
}

class Bond implements abBond{
    int s;
    public void setS(int a){
        this.s=a;
        nofyity();
    }

     ArrayList<observer> list=new ArrayList();   //注册列表

    @Override
    public void add(observer a) {
    list.add(a);
    }

    @Override
    public void remove(observer a) {
     list.remove(a);
    }

    @Override
    public void nofyity() {
      for (observer a:list){
          a.updata(s);
      }
    }
}

interface observer{
    abstract public void updata(int a);
}

class WQL implements observer{
    int a;
    @Override
    public void updata(int a) //更新方法
    {
        this.a=a;
        if(a>3){
            pr(a);
        }
    }
    //把值打印
    public void pr(int a){
        System.out.println("小王债券更新！！！"+a);

    }
}

class FUQING implements observer{
    int a;
    @Override
    public void updata(int a) {
      this.a=a;
        if(a>3){
            pr(a);
        }
    }
    public void pr(int a){
        System.out.println("小王债券更新！！！"+a);

    }
}