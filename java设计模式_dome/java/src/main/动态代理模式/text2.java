import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class text2 {
    public static void main(String[] args) {

        WQL56 a=new WQL56(new nv1());
        Top as=(Top)a.Secceed();
        as.secceed();
    }
}

class WQL56{
  private Object NV;
    public WQL56(Object NV) {
        this.NV = NV;
    }

    public Object Secceed(){

        return Proxy.newProxyInstance(NV.getClass().getClassLoader(), NV.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
               System.out.println("asdad");
                Object a=method.invoke(NV,objects);
                return a;
            }
        });
  }


}

interface Top{
public void  secceed();
}

class nv1 implements Top{
    public  void secceed(){
        System.out.println("asd");
    }
}