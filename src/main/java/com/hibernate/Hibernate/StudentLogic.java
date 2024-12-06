package com.hibernate.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentLogic {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();

        Transaction t = s.beginTransaction();

        // Insert a sample Student record to test the fetch operation
        Student std = new Student();
        std.setId(111);
        std.setName("rohi");
        std.setCgpa(10);
        s.save(std);

        t.commit();

        // Fetch the Student record
        s = sf.openSession(); // Open a new session for fetching
        Student fetchedStd = s.get(Student.class, 111);

        if (fetchedStd != null) {
            System.out.println("Name: " + fetchedStd.getName());
        } else {
            System.out.println("No student found with ID 111");
        }

        s.close();
        sf.close();
    }
}
