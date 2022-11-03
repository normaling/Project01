package Text01;

public class Role {
    //角色类的架构
    //1.成员属性
    private int blood;//血量
    private String name;//姓名
    //实参构造
    public Role(String name,int blood) {
        this.blood = blood;
        this.name = name;
    }
    //空参构造
    public Role() {
    }
    //set方法
    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void setName(String name) {
        this.name = name;
    }
    //get方法
    public int getBlood() {
        return blood;
    }

    public String getName() {
        return name;
    }
    //角色的行为
    //攻击行为逻辑分析
    //1.攻击者与被攻击人
    //实参为被攻击者，形参为攻击者
    public void attack(String name,int hurt){
        this.blood=this.blood-hurt;
        System.out.println(name+"攻击了"+this.name+"造成了"+hurt+"点伤害");
    }
}
