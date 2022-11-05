package Text01;
import java.util.ArrayList;
import java.util.Scanner;
public class Demo {
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();
        String choose;
        loop: while(true){
            message();
            Scanner sc=new Scanner(System.in);
            choose=sc.next();
            switch(choose){
                case "1" -> {
                    addStudent(list);
                }
                case "2" ->{
                    removeStudent(list);
                }
                case "3" -> {
                    changeStudent(list);
                }
                case "4" -> {
                    selectStudent(list);
                }
                case "5"->{
                    System.out.println("退出成功");
                    break loop;
                }
                default -> {
                    System.out.println("没有这个选项");

                }
            }
        }
    }
    //添加学生
    public static void addStudent(ArrayList<Student> list){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学生的id");
        int id=sc.nextInt();
        if(contains(list,id)){
            System.out.println("已存在该id请重写录入");
            System.out.print("id=");
            id=sc.nextInt();
        }
        System.out.println("请输入学生的姓名");
        String name=sc.next();
        System.out.println("请输入学生的年龄");
        int age=sc.nextInt();
        System.out.println("请输入学生的家庭住址");
        String address=sc.next();
        Student s=new Student(id,name,age,address);
        if(list.add(s)){
            System.out.println("添加成功");
        }

    }
    //删除学生
    public static void removeStudent(ArrayList<Student> list){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要删除的id");
        int id=sc.nextInt();
        int index=getIndex(list,id);
        if(index >=0){
            list.remove(index);
            System.out.println("id为" + id + "删除成功");
        }else{
            System.out.println("id不存在");
            return;
        }
    }
    //修改学生
    public static void changeStudent(ArrayList<Student> list){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要修改学生的id");
        int id=sc.nextInt();
        int index=getIndex(list,id);
        if(index==-1){
            System.out.println("要修改的id不存在，请重新输入");
            return;
        }else{
            Student stu=list.get(index);
            System.out.println("请输入要修改的学生姓名");
            String newName=sc.next();
            stu.setName(newName);
            System.out.println("请输入要修改的学生年龄");
            int newAge=sc.nextInt();
            stu.setAge(newAge);
            System.out.println("请输入要修改的学生地址");
            String newAddress=sc.next();
            stu.setAddress(newAddress);
            System.out.println("修改成功");
        }
    }
    //查询学生
    public static void selectStudent(ArrayList<Student> list){
        if(list.size()==0){
            System.out.println("当前无学生信息，请添加后再查询");
            return;
        }
        System.out.println("id\t姓名\t年龄\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Student stu=list.get(i);
            System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
        }
    }
    public static void message(){
        System.out.println("---------------------学生管理系统-------------------");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查询学生");
        System.out.println("5.退出");
        System.out.println("请输入您的选择：");
    }
    //判断id在集合中是否存在
    public static boolean contains(ArrayList<Student> list,int id){
        for (int i = 0; i < list.size(); i++) {
            Student stu=list.get(i);
            int sId=stu.getId();
            if(sId==id){
                return true;
            }
        }
        return false;
    }
    //通过id获取索引
    public static int getIndex(ArrayList<Student> list,int id){
        for (int i = 0; i < list.size(); i++) {
            Student stu=list.get(i);
            int sId=stu.getId();
            if(sId==id){
                return i;
            }
        }
        return -1;
    }
}
