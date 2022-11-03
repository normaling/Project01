package Text01;
import java.util.Random;
public class Demo {
    public static void main(String[] args) {
        //测试类
        Role r1=new Role("张三",100);
        Role r2=new Role("李四",100);
        Random r=new Random();
        while(true){
            r1.attack(r2.getName(),r.nextInt(10));
            if(r1.getBlood()==0 ){
                System.out.println(r1.getName() + "被" + r2.getName() + "击败了");
                break;
            }else if(r2.getBlood()==0){
                System.out.println(r2.getName() + "被" + r1.getName() + "击败了");
                break;
            }
        }

    }
}
