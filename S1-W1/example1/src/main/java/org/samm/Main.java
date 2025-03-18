package org.samm;

import org.samm.models.Student;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("12345678", "Karen1", "Fonseca", "karenf@gmail.com", "Computer Science"));
        students.add(new Student("12345678", "Karen2", "Fonseca", "karenf@gmail.com", "Computer Science"));
        students.add(new Student("12345678", "Karen3", "Fonseca", "karenf@gmail.com", "Computer Science"));
        students.add(new Student("12345678", "Karen4", "Fonseca", "karenf@gmail.com", "Computer Science"));
        students.add(new Student("12345678", "Karen5", "Fonseca", "karenf@gmail.com", "Computer Science"));

        int op = 0;
        while (op != 3) {
            op = Integer.parseInt(JOptionPane.showInputDialog("1. Add students\n" +
                    "2. Show students\n" +
                    "3. Exit"));
            switch (op) {
                case 1:
                    String cif = JOptionPane.showInputDialog("CIF");
                    String name = JOptionPane.showInputDialog("Name");
                    String surname = JOptionPane.showInputDialog("Surname");
                    String email = JOptionPane.showInputDialog("Email");
                    String major = JOptionPane.showInputDialog("Major");
                    Student student = new Student(cif, name, surname, email, major);
                    students.add(student);
                    break;
                case 2:
                    String list = "";
                    for (Student e : students) {
                        list += e.getCif() + " " + e.getName() + " " + e.getSurname() + " " + e.getEmail() + " " + e.getMajor() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, list);
                    break;
            }
        }
    }
}