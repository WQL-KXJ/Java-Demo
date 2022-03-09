public class 装饰者模式1 {
    public static void main(String[] args) {

  role a=new role1();
  cplthing b=new fashionable1(a);
  cplthing c=new fashionable3(b);
  c.colthing();

    }
}

interface role{
    abstract public void colthing();
}

class role1 implements role{
    @Override
    public void colthing() {
        System.out.print("角色1：");
    }
}

class role2 implements role{
    @Override
    public void colthing() {
        System.out.print("角色2：");
    }
}

abstract class cplthing implements role{
    role roles;
    public cplthing(role roles){
        this.roles=roles;
    }


}

class fashionable1 extends cplthing{

    public fashionable1(role roles){
        super(roles);
    }
    @Override
    public void colthing() {
        roles.colthing();
        System.out.print("暗黑地魔装,");
    }
}

class fashionable2 extends cplthing{

    public fashionable2(role roles){
        super(roles);
    }
    @Override
    public void colthing() {
        roles.colthing();
        System.out.print("天空神翼装,");
    }
}
class fashionable3 extends cplthing{

    public fashionable3(role roles){
        super(roles);
    }
    @Override
    public void colthing() {
        roles.colthing();
        System.out.print("丛林装,");
    }
}