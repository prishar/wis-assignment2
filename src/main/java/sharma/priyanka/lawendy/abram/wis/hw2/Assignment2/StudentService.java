package sharma.priyanka.lawendy.abram.wis.hw2.Assignment2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/rest/student")
class StudentService {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HashMap<Long, Student> getAllStudents() {
        return Assignment2Application.hmStudent;
    }
}

