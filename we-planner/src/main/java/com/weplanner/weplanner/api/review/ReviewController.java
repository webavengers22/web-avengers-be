package com.weplanner.weplanner.api.review;

import org.springframework.web.bind.annotation.RestController;

import com.weplanner.weplanner.api.review.dto.AddReviewRequestDto;
import com.weplanner.weplanner.api.review.dto.UpdateReviewRequestDto;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    
    @GetMapping(value="/review/{planId}")
    public Review getMethodName(@PathVariable("planId") Long planId) throws Exception {
        return reviewService.getReviewByPlainId(planId);
    }

    @PostMapping("/review")
    public Review addReview(@RequestBody AddReviewRequestDto requestDto) throws Exception {
        return reviewService.addReview(requestDto);
    }
    
    @PutMapping(value="/review/{reviewId}")
    public Review updateReview(@PathVariable Long reviewId, @RequestBody UpdateReviewRequestDto requestDto) throws Exception{
        return reviewService.updateReview(reviewId, requestDto);
    }

    @DeleteMapping(value="/review/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) throws Exception{
        reviewService.deleteReviewById(reviewId);
    }
}
