package com.niko.lesson_five_homework;

import com.niko.lesson_five_homework.dao.StudentDao;
import com.niko.lesson_five_homework.entity.Student;
import org.junit.jupiter.api.*;

public class TestStudentDaoDeleteAllOnly {
    private static StudentDao dao;

    @BeforeAll
    static void setup() {
        dao = new StudentDao();
    }

    @Test
    void testDeleteAll() {
        dao.openCurrentSessionWithTransaction();
        dao.deleteAll();
        Assertions.assertEquals(0, dao.findAll().size());
        dao.closeCurrentSessionWithTransaction();
    }
}
