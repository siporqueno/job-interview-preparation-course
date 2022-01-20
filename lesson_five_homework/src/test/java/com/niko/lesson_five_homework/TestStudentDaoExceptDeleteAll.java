package com.niko.lesson_five_homework;

import com.niko.lesson_five_homework.dao.StudentDao;
import com.niko.lesson_five_homework.entity.Student;
import org.junit.jupiter.api.*;

public class TestStudentDaoExceptDeleteAll {
    private static StudentDao dao;

    @BeforeAll
    static void setup() {
        dao = new StudentDao();
    }

    @Test
    @Order(1)
    void testFindAll() {
        dao.openCurrentSessionWithTransaction();
        Assertions.assertEquals(1000, dao.findAll().size());
        dao.closeCurrentSessionWithTransaction();
    }

    @Test
    @Order(2)
    void testFindById() {
        dao.openCurrentSessionWithTransaction();
        Student student = dao.findById(1L);
        Assertions.assertNotNull(student);
        Assertions.assertTrue(student.getName().contains("student"));
        Assertions.assertTrue(1 <= student.getMark() && student.getMark() <= 10);
        dao.closeCurrentSessionWithTransaction();
    }

    @Test
    @Order(3)
    void testPersist() {
        dao.openCurrentSessionWithTransaction();
        Student newStudent = new Student("Vasya", 11);
        dao.persist(newStudent);
        Assertions.assertEquals(1001, dao.findAll().size());
        Student foundStudent = dao.findById(1001L);
        Assertions.assertNotNull(foundStudent);
        Assertions.assertEquals("Vasya", foundStudent.getName());
        Assertions.assertEquals(11, foundStudent.getMark());
        dao.closeCurrentSessionWithTransaction();
    }

    @Test
    @Order(4)
    void testDelete() {
        dao.openCurrentSessionWithTransaction();
        Student studentToBeDeleted = dao.findById(1001L);
        dao.delete(studentToBeDeleted);
        Assertions.assertNull(dao.findById(1001L));
        Assertions.assertEquals(1000, dao.findAll().size());
        dao.closeCurrentSessionWithTransaction();
    }

    @Test
    @Order(5)
    void testUpdate() {
        dao.openCurrentSessionWithTransaction();
        Student studentToBeUpdated = dao.findById(1000L);
        studentToBeUpdated.setName("Petr");
        studentToBeUpdated.setMark(12);
        Student updatedStudent = dao.findById(1000L);
        Assertions.assertNotNull(updatedStudent);
        Assertions.assertEquals("Petr", updatedStudent.getName());
        Assertions.assertEquals(12, updatedStudent.getMark());
        dao.closeCurrentSessionWithTransaction();
    }

}
