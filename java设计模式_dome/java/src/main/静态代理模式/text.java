public class text {
    public static void main(String[] args) {

        WQL44 E=new WQL44(new Matchmakingplatform(new nv()));
               E.w();
    }
}
class WQL44{
    Matchmakingplatform a;
    public WQL44(Matchmakingplatform a) {
        this.a = a;
    }
    public void  w(){
        a.succeed();
    }}

    interface g{
    public void succeed();

   }

class Matchmakingplatform implements g{
   //聚合一个被代理对象
    g fuqing; //接口类型，都继承接口这样一个代理类可以代理多个类
    public Matchmakingplatform(g fuqing) {
        this.fuqing = fuqing;
    }
    public void succeed(){
//增强这个被代理类
        System.out.println("非美不要");
        fuqing.succeed();
    }}

class  nv implements g{
    public void succeed(){
        System.out.print("成功!!!");

    }


}