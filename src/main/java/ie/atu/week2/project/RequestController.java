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
        User myUser = new User("joey","john","adamok@gamil.com","trex","america",5675);
        return myUser;
    }

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User myUser) {
        myUsers.add(myUser);
        return myUser;
    }

    @DeleteMapping("/delete")
    public String deleteByName(@RequestParam(value = "Firstname") String Firstname){
        // Add a logic to delete by Firstname

        return "Deleted by Firstname";
    }




      // Be inplemeted when we add id to the User class to track how many there are
   /* @PutMapping("/User")
    public boolean updateUser(@PathVariable id, @RequestBody User user) {
        User currentUser = userRepo.findOne(id);
   }
    */
}
