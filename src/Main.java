import Model.Course;
import Model.Student;
import Model.Enrolls;

import java.util.Calendar;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        Course c1 = new Course();
        Enrolls e1 = new Enrolls();
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.MONTH, 11);
        cal1.set(Calendar.DATE, 05);
        cal1.set(Calendar.YEAR, 1996);
        e1.enroll_stud_course(s1,c1,cal1);

        s1.setName("Chinmay Desai");
        System.out.println(s1.getName());
    }
}