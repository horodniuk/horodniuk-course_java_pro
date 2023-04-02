package hometask.hibernate;


import hometask.hibernate.dao.StudentDao;
import hometask.hibernate.entity.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Slf4j
public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        var student = new Student();
        student.setName("Ivan");
        student.setEmail("ivanov@gmail.com");
        // save
        studentDao.save(student);

        // delete
        studentDao.delete(student);

        // update
        var student2 = new Student();
        student2.setId(5L);
        student2.setName("Update");
        student2.setEmail("update@gmail.com");
        studentDao.update(student2);

        // findById
        studentDao.findById(1L).ifPresent(System.out::println);

        // findAll
        List<Student> list = studentDao.findAll();
        list.forEach(System.out::println);
    }
}
