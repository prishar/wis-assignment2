package sharma.priyanka.lawendy.abram.wis.hw2.Assignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class Assignment2Application {

    public static HashMap<Long, Student> hmStudent;

    public static void main(String[] args) {
        hmStudent = new HashMap<Long, Student>();

        Student one = new Student("Priyanka Sharma", "WIS");
        Student two = new Student("Abram Lawendy", "WIS");
        hmStudent.put(new Long(one.getId()), one);
        hmStudent.put(new Long(two.getId()), two);

        System.out.print(hmStudent.get(one.getId()));
        System.out.print(hmStudent.get(two.getId()));

        SpringApplication.run(Assignment2Application.class, args);
    }
}
