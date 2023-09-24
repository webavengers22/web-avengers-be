package com.weplanner.weplanner.api.review.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class AddReviewRequestDto {
    private Long planId;
    private String description;    
}
