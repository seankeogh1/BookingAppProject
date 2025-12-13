package ie.atu.week2.project.Review;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepo;

    public ReviewService(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }


    public Review create(Review review) {
        return reviewRepo.save(review);
    }

    public List<Review> findAll() {
        return reviewRepo.findAll();
    }

    public Review findByReviewId(String ReviewId) {
        return reviewRepo.findByReviewId(ReviewId)
                .orElseThrow(() -> new IllegalArgumentException("Review not found"));

    }
    public Review deleteByReviewId(String ReviewId) {
        Review r = reviewRepo.findByReviewId(ReviewId)
                .orElseThrow(() -> new IllegalArgumentException("Review not found"));
        reviewRepo.delete(r);
        return r;
    }

}
