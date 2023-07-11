package com.hcj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * StudentSystem
 *   检验知识点：集合、如何创建对象并赋值，键盘输入类，循环和判断，控制语句，开关思想，定义方法...
 * @author hcj
 * @date 2023-07-10
 */
public class StudentSystem {
    /**
     * 作为全局变量  这个类都可以使用
    */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        while(true){
            System.out.println("----------欢迎来到学生管理系统------------");
            System.out.println("1 查看所有学生");
            System.out.println("2 添加学生");
            System.out.println("3 删除学生");
            System.out.println("4 修改学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择:");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    // 1 查看所有学生
                    selectStudent(list);
                    break;
                case 2:
                    // 2 添加学生
                    addStudent(list);
                    break;
                case 3:
                    // 3 删除学生
                    deleteStudent(list);
                    break;
                case 4:
                    // 4 修改学生
                    updateStudent(list);
                    break;
                case 5:
                    // 5 退出
                    System.out.println("欢迎下次使用！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("你输入的选择数字不对，请输入1-5的数字！");
                    break;
            }
        }
    }

    /**
     * 2.添加学生
    */
    public static void addStudent(ArrayList<Student> list){
        /*
         * 思考：第一次调用添加学生方法没问题，但是第二次添加时，学号要不重复
         * 上来就要先遍历这个集合，判断你输入学号跟集合中的学号是否存在，
         * 如果集合中这个输入的学号已存在，就不能添加，
         * 反之可以继续向下操作
        */
        String id = "";
        while(true){
            System.out.println("请输入添加的学号:");
            id = sc.next();
            // 定义一个开关思想
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    // 你输入的学号已存在 开灯
                    flag = true;
                    break;
                }
            }
            if(flag){
                // 提示学号存在
                System.out.println("你输入的学号"+id+"已存在，请重新输入！");
            }else{
                // 说明学号不存在，结束while循环
                break;
            }
        }
        System.out.println("请输入添加的姓名:");
        String username = sc.next();
        System.out.println("请输入添加的性别:");
        String sex = sc.next();
        System.out.println("请输入添加的年龄:");
        int age = sc.nextInt();
        System.out.println("请输入添加的专业:");
        String major = sc.next();
        System.out.println("请输入添加的地址:");
        String address = sc.next();
        // 创建学生对象
        Student s = new Student();
        s.setId(id);
        s.setUsername(username);
        s.setAge(age);
        s.setMajor(major);
        s.setSex(sex);
        s.setAddress(address);
        // 把学生对象存入集合中
        list.add(s);
        System.out.println("添加学生信息成功！");
    }
    
    /**
     * 1 查看所有学生
     * @param list 存放学生信息的集合
     * @return void
    */
    public static void selectStudent(ArrayList<Student> list){
        /*
         * 思路：先判断集合有无学生信息，如果一个都没有，要提醒先去添加
         * 如果有，就查询出所有学生的属性信息
        */
        if(list.isEmpty()){
            System.out.println("目前没有学生信息，请先去添加");
            return; // 后面的代码不要执行了  结束方法的调用
        }
        System.out.println("序号\t学号\t姓名\t性别\t年龄\t专业\t地址");
        // 遍历集合  打印每个学生对象信息
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println((i+1)+"."+s.getId()+"\t"+s.getUsername()+"\t"+s.getSex()
                    +"\t"+s.getAge()+"\t"+s.getMajor()+"\t"+s.getAddress());
        }
    }

    /**
     * 3 删除学生
    */
    public static void deleteStudent(ArrayList<Student> list){
        /*
         * 思路：根据学号去删除学生，因为学号唯一，每次删除一个学生
        */
        while(true){
            System.out.println("请输入你要删除的学号：");
            String id = sc.next();
            // 开关思想
            int index = -1;
            // 遍历集合，看学号在集合中是否存在
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    index = i;
                    break;
                }
            }
            if(index==-1){
                // 说明学号不存在
                System.out.println("你输入的学号"+id+"不存在，请重新输入！");
            }else{
                // 说明学号存在，可以删除
                list.remove(index);
                System.out.println("学号"+id+"这个学生信息删除成功！");
                break;// 终止while循环
            }
        }
    }
    /**
     * 4 修改学生
    */
    public static void updateStudent(ArrayList<Student> list){
        /*
         * 思路：根据学号去修改学生，遍历学生集合，找到有无此学号
         *      有，就修改除了学号的其他信息
         *      没有，就重新输入学号
        */
        while(true){
            System.out.println("请输入你要修改的学号：");
            String id = sc.next();
            // 开关思想
            int index = -1;
            // 遍历集合，看学号在集合中是否存在
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    index = i;
                    break;
                }
            }
            if(index==-1){
                // 说明学号不存在
                System.out.println("你输入的学号"+id+"不存在，请重新输入！");
            }else{
                // 说明学号存在，可以修改：姓名、性别.....
                System.out.println("请输入你要修改的姓名：");
                String updateUsername = sc.next();
                System.out.println("请输入你要修改的性别:");
                String updateSex = sc.next();
                System.out.println("请输入你要修改的年龄:");
                int updateAge = sc.nextInt();
                System.out.println("请输入你要修改的专业:");
                String updateMajor = sc.next();
                System.out.println("请输入你要修改的地址:");
                String updateAddress = sc.next();
                // 创建学生对象
                Student s = new Student();
                s.setId(id);
                s.setUsername(updateUsername);
                s.setAge(updateAge);
                s.setMajor(updateMajor);
                s.setSex(updateSex);
                s.setAddress(updateAddress);
                // 把修改的学生对象
                list.set(index,s);
                System.out.println("学号"+id+"这个学生信息修改成功！");
                break;// 终止while循环
            }
        }

    }

}
