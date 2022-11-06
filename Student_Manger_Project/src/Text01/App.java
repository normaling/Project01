package Text01;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class App {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<User> list=new ArrayList<>();
    loop:while(true){
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作1.登录，2.注册，3.忘记密码，4.退出");
            String choose=sc.next();
            switch(choose){
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgerPassword(list);
                case "4" -> {
                    System.out.println("退出成功");
                    break loop;
                }
                default -> System.out.println("没有这个选项");
            }
        }

    }
    //忘记密码
    private static void forgerPassword(ArrayList<User> list) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String userName=sc.next();
        boolean flag=contains(list,userName);
        if(!flag){
            System.out.println("当前用户" + userName + "未注册，请先注册");
            return;
        }
        System.out.println("请输入身份证号");
        String personId=sc.next();
        System.out.println("请输入手机号");
        String phoneNumber=sc.next();
        
        int index=findIndex(list,userName);
        User user=list.get(index);
        if(!(user.getPersonId().equalsIgnoreCase(personId) && user.getPhoneNumber().equals(phoneNumber))){
            System.out.println("身份证号码或手机号码输入有误不能修改密码");
            return;
        }
        String password;
        while (true) {
            System.out.println("请输入新密码");
            password=sc.next();
            System.out.println("请再次输入密码");
            String againPassword=sc.next();
            if(password.equals(againPassword)){
                System.out.println("俩次密码输入一致");
                break;
            }else{
                System.out.println("俩次密码输入不一致");
                continue;
            }
        }
        user.setPassword(password);
        System.out.println("密码修改成功");
    }

    private static int findIndex(ArrayList<User> list, String userName) {
        for (int i = 0; i < list.size(); i++) {
            User user=list.get(i);
            if(user.getUsername().equals(userName)){
                return i;
            }
        }
        return -1;
    }

    //注册
    private static void register(ArrayList<User> list) {
        String userName;
        String password;
        String personId;
        String phoneNumber;
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名");
            userName=sc.next();
            boolean flag1=checkUserName(userName);
            if(!flag1){
                System.out.println("格式不满足条件，需要重新输入");
                continue;
            }
            boolean flag2= contains(list,userName);
            if(flag2){
                System.out.println("用户名" + userName + "已存在，请重新输入");

            }else{
                System.out.println("用户名" + userName + "可用");
                break;
            }
        }
        while (true) {
            System.out.println("请输入要注册的密码");
            password=sc.next();
            System.out.println("请再次输入要注册的密码");
            String againPassword=sc.next();
            if(!password.equals(againPassword)){
                System.out.println("俩次密码输入不一致，请重新输入");
                continue;
            }else{
                System.out.println("俩次密码一致，继续输入其他数据");
                break;
            }
        }
        while (true) {
            System.out.println("请输入身份证号码");
            personId=sc.next();
            boolean flag=checkPersonId(personId);
            if(flag){
                System.out.println("身份证号码满足要求");
                break;
            }else{
                System.out.println("身份证号码格式有误不满足要求，请重新输入");
                continue;
            }
        }
        while (true) {
            System.out.println("请输入手机号码");
            phoneNumber=sc.next();
            boolean flag=checkPhoneNumber(phoneNumber);
            if(flag){
                System.out.println("手机号码格式正确");
                break;
            }else{
                System.out.println("手机号码格式有误，请重新输入");
                continue;
            }
        }
        User u=new User(userName,password,personId,phoneNumber);
        list.add(u);
        System.out.println("注册成功");
        printList(list);
    }

    private static void printList(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            User user=list.get(i);
            System.out.println(user.getUsername() + "," + user.getPassword() + "," + user.getPersonId() + "," + user.getPhoneNumber());
        }
    }

    private static boolean checkPhoneNumber(String phoneNumber) {
        if(phoneNumber.length()!=11){
            return false;
        }
        if(phoneNumber.startsWith("0")){
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c=phoneNumber.charAt(i);
            if(!(c>='0'&&c<='9')){
                return false;
            }
        }
        return true;
    }

    private static boolean checkPersonId(String personId) {
        if(personId.length()!=18)return false;
        boolean flag=personId.startsWith("0");
        if(flag){
            return false;
        }
        for (int i = 0; i < personId.length()-1; i++) {
            char c=personId.charAt(i);
            if(!(c >='0' && c<='9')){
                return false;
            }
        }
        char endChar=personId.charAt(personId.length()-1);
        if((endChar>='0' && endChar<='9')|| (endChar=='x')||endChar=='X'){
            return true;
        }else{
            return false;
        }
    }

    private static boolean contains(ArrayList<User> list, String userName) {
        for (int i = 0; i < list.size(); i++) {
            User user=list.get(i);
            String rightUid=user.getUsername();
            if(rightUid.equals(userName)){
                return true;
            }
        }
        return false;
    }

    //检查用户名的正确性
    private static boolean checkUserName(String userName) {
        int len=userName.length();
        if(len < 3|| len > 15){
            return false;
        }
        for (int i = 0; i < userName.length(); i++) {
            char c=userName.charAt(i);
            if(!((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9'))){
                return false;
            }
        }
        int count=0;
        for (int i = 0; i < userName.length(); i++) {
            char c=userName.charAt(i);
            if((c>='a'&&c<='z') || (c>='A' && c<='Z')){
                count++;
                break;
            }
        }
        return count>0;
    }

    //登录
    private static void login(ArrayList<User> list) {
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<3;i++) {
            System.out.println("请输入用户名");
            String userName=sc.next();
            boolean flag=contains(list,userName);
            if(!flag){
                System.out.println("用户名" + userName + "未注册，请先注册在登陆");
                return;
            }
            System.out.println("请输入密码");
            String password=sc.next();
            while (true) {
                String rightCode=getCode();
                System.out.println("当前验证码为" + rightCode);
                System.out.println("请输入验证码");
                String code=sc.next();
                if(code.equalsIgnoreCase(rightCode)){
                    System.out.println("验证码正确");
                    break;
                }else{
                    System.out.println("验证码错误");
                    continue;
                }
            }
            User userInfo=new User(userName,password,null,null);
            boolean result=checkUserInfo(list,userInfo);
            if(result){
                System.out.println("登录成功，可以开始使用学生管理系统");
                StudentSystem ss=new StudentSystem();
                ss.startStudentSystem();
                break;
            }else{
                System.out.println("登录失败，用户名或密码错误");
                if(i==2){
                    System.out.println("当前账号" + userName + "被锁定");
                    return;
                }else{
                    System.out.println("用户名或密码错误还剩下" + (2-i) + "次机会");
                }
            }
        }
    }

    private static boolean checkUserInfo(ArrayList<User> list, User userInfo) {
        for (int i = 0; i < list.size(); i++) {
            User user=list.get(i);
            if((user.getUsername().equals(userInfo.getUsername()))&&(user.getPassword().equals(userInfo.getPassword())) ) {
                return true;
            }
        }
            return false;
    }

    public static String getCode(){
        ArrayList<Character> list=new ArrayList<>();

        for (int i = 0; i <26; i++) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        StringBuilder sb=new StringBuilder();
        Random r=new Random();
        for (int i = 0; i < 4; i++) {
            int index=r.nextInt(list.size());
            char c=list.get(index);
            sb.append(c);
        }
        int number=r.nextInt(10);
        sb.append(number);
        char[] arr=sb.toString().toCharArray();
        int randomIndex=r.nextInt(arr.length);
        char tmp=arr[randomIndex];
        arr[randomIndex]=arr[arr.length-1];
        arr[arr.length-1]=tmp;
        return new String(arr);
    }
}
