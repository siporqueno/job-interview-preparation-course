package com.niko.lesson_five_homework.dao;

import com.niko.lesson_five_homework.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {

    private SessionFactory sessionFactory;

    private Session currentSession;

    private Transaction currentTransaction;

    public StudentDao() {
        this.sessionFactory = SessionFactoryCreator.getSessionFactory();
    }

    public Session openCurrentSession() {
        currentSession = sessionFactory.getCurrentSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = sessionFactory.getCurrentSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Student student) {
        getCurrentSession().save(student);
    }

    public void update(Student student) {
        if (student.getId() != null) {
            Student studentToBeUpdated = findById(student.getId());
            studentToBeUpdated.setName(student.getName());
            studentToBeUpdated.setMark(student.getMark());
        }
    }

    public Student findById(Long id) {
        return (Student) getCurrentSession().get(Student.class, id);
    }

    public void delete(Student student) {
        getCurrentSession().delete(student);
    }

    public List<Student> findAll() {
        return (List<Student>) getCurrentSession().createQuery("from Student").list();
    }

    public void deleteAll() {
        List<Student> students = findAll();
        for (Student student : students
        ) {
            delete(student);
        }
    }
}
