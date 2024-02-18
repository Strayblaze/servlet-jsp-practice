package kz.alabs.academy.db;

import kz.alabs.academy.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static List<Student> students = new ArrayList<>();
    private static Long id=4L;

    static {
        students.add(new Student(1L, "Mark", "Zuckerberg", 39, "Harvard University"));
        students.add(new Student(2L, "Elon", "Musk", 52, "Stanford University"));
        students.add(new Student(3L, "Jeff", "Bezos", 60, "Princeton University"));
    }

    public static List<Student> findAll(){
        return students;
    }

    public static void add(Student student){
        student.setId(id++);
        students.add(student);
    }

}
