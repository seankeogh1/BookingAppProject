package ie.atu.week2.project;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/UserApp")
@RestController

public class RequestController {

    List<User> myUsers = new ArrayList<User>();


    @GetMapping
    public String welcome() {
        return "Welcome to UserApp!";
    }

    @GetMapping("/User Info")
    public User getUser() {
        User myUser = new User("subhan","john","adamok@gamil.com","trex","america");
        return myUser;
    }

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User myUser) {
        myUsers.add(myUser);
        return myUser;
    }



}
