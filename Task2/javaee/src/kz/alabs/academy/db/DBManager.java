package kz.alabs.academy.db;

import kz.alabs.academy.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1L, "Mark", "Zuckerberg", 39));
        students.add(new Student(2L, "Elon", "Musk", 52));
        students.add(new Student(3L, "Jeff", "Bezos", 60));
    }

    public static List<Student> findAll(){
        return students;
    }

}
