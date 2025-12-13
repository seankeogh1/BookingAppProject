package ie.atu.week2.project.Review;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService revservice;

    public ReviewController(ReviewService revservice) {
        this.revservice = revservice;
    }

    @GetMapping
    public List<Review> findAll() {
        return revservice.findAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Review addReview(@RequestBody @Valid Review review) {
        return revservice.create(review);
    }

    @GetMapping("/{ReviewId}")
    public Review byEmployeeId(@PathVariable String ReviewId) {
        return revservice.findByReviewId(ReviewId);
    }
    @DeleteMapping("/{ReviewId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Review byReviewID(@PathVariable String ReviewId) {
        return revservice.deleteByReviewId(ReviewId);

    }


}
