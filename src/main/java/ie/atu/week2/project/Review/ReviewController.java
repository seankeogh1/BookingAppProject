package ie.atu.week2.project.Review;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final List<Review> reviews = new ArrayList<>();

    @GetMapping
    public List<Review> getReviews() {
        return reviews;
    }

    @PostMapping("/add")
    public Review addReview(@RequestBody @Valid Review review) {
        reviews.add(review);
        return review;

    }

    public String deleteByName(@RequestParam(value = "Firstname") String Firstname) {
        boolean removed = reviews.remove(Firstname);
        return "Deleted review with first name: " + Firstname;
    }
}
