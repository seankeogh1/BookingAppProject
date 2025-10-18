package ie.atu.week2.project;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/UserApp")
public class RequestController {

    private final List<User> myUsers = new ArrayList<>();

    @GetMapping
    public String welcome() {
        return "Welcome to UserApp!";
    }

    @GetMapping("/UserInfo")
    public User getUser() {
        return new User("joey", "john", "adamok@gamil.com", "trex", "america", 5675L);
    }

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User myUser) {
        myUsers.add(myUser);
        return myUser;
    }

    @DeleteMapping("/delete")
    public String deleteByName(@RequestParam(value = "Firstname") String Firstname){
        // Add a logic to delete by Firstname
         boolean removed = myUsers.remove(Firstname);
         return "Deleted user with first name: " + Firstname;
    }
    }




      // Be inplemeted when we add id to the User class to track how many there are
   /* @PutMapping("/User")
    public boolean updateUser(@PathVariable id, @RequestBody User user) {
        User currentUser = userRepo.findOne(id);
   }
    */
    

