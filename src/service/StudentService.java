package service;

import entities.Student;
import utils.Utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class StudentService {
    Map<Integer, Student> map = new HashMap<>();
    Utils ultis = new Utils();
    public void addStudent(Scanner scanner){
        System.out.println("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập điểm sinh viên: ");
        double score = ultis.inputDouble(scanner);
        Student student = new Student(name, score);
        map.put(student.getId(), student);
        System.out.println("Thêm học sinh thành công.");
    }

    public void removeStudent(Scanner scanner) {
        System.out.println("Nhập id sinh viên cần xóa.");
        int id = ultis.inputInt(scanner);
        Iterator<Map.Entry<Integer, Student>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Student> entry = iterator.next();
            if (entry.getKey().equals(id)) {
                iterator.remove();
                System.out.println("Đã xóa sinh viên: " + id);
                break;
            } else {
                System.out.println("Key không tồn tại hoặc đã bị xóa.");
            }
        }
    }

    public void printInfo(){
        for (Map.Entry<Integer, Student> entry : map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public void searchStudent(Scanner scanner){
        System.out.println("Nhập id sinh viên cần tìm.");
        int id = ultis.inputInt(scanner);
        System.out.println("Thông tin id sinh viên cần tìm là: " + map.get(id));
    }

    public void calAllScoreStudent(){
        double allScore = 0;
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            allScore += entry.getValue().getScore();
        }
        double gpaAllStudent = allScore / map.size();
        System.out.println("Điểm trung bình của tất cả sinh viên là: " + gpaAllStudent);
    }

}

