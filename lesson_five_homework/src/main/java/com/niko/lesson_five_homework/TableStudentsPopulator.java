package com.niko.lesson_five_homework;

import com.niko.lesson_five_homework.dao.StudentDao;
import com.niko.lesson_five_homework.entity.Student;

import java.util.Random;

public class TableStudentsPopulator {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Random random = new Random();

        studentDao.openCurrentSessionWithTransaction();

        for (int i = 0; i < 1000; i++) {
            Student student = new Student(String.format("student %d", random.nextInt(100) + 1), random.nextInt(10) + 1);
            studentDao.persist(student);
            if (i > 0 && i % 20 == 0) {
                studentDao.getCurrentSession().flush();
                studentDao.getCurrentSession().clear();
            }
        }

        studentDao.closeCurrentSessionWithTransaction();
    }
}
