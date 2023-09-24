package com.weplanner.weplanner.api.review;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import javax.validation.constraints.Null;

import org.apache.tomcat.jni.Local;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.weplanner.weplanner.api.review.dto.AddReviewRequestDto;
import com.weplanner.weplanner.api.review.dto.UpdateReviewRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository repository;

    public Review getReviewByPlainId(Long planId){
        // TODO : 리뷰 페이지 확인 후 필요한 값만 리턴 필요
        return repository.findOneByPlanId(planId);
    }
    
    public Review addReview(AddReviewRequestDto requestDto){
        // TODO : 
        // 일정 조회 후 없으면 에러
        // 일정에 내가 편집자 권한인지 확인 후 없으면 forbidden 에러
        // jwt로 내 아이디 조회해서 넣어주기
        // 일정 당 리뷰 한 개만 작성인지 확인
        
        Review review = new Review();
        review.setPlanId(requestDto.getPlanId());
        review.setDescription(requestDto.getDescription());
        review.setLastWriterId((long) 1);
        return repository.save(review);
    }

    public Review updateReview(Long id, UpdateReviewRequestDto requestDto) throws Exception{
        // TODO : 
        // 일정에 내가 편집자 권한인지 확인 후 없으면 forbidden 에러
        // jwt로 내 아이디 조회해서 LastWriterId 넣어주기
        // updatedAt 업데이트
        Review review = repository.findById(id).orElseThrow(NotFoundException::new);
        
        review.setDescription(requestDto.getDescription());
        LocalDateTime now = LocalDateTime.now();
        review.setUpdatedAt(now);
        return repository.save(review);
    }

    public void deleteReviewById(Long id) throws Exception{
        repository.findById(id).orElseThrow(NotFoundException::new);
        // TODO: // 일정에 내가 편집자 권한인지 확인 후 없으면 forbidden 에러
        repository.deleteById(id);
    }
}
