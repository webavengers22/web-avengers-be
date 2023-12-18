package com.weplanner.weplanner.api.common;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ResponseService {
 public<T> SingleResponse<T> getSingleResponse(T data) {
    SingleResponse<T> singleResponse = new SingleResponse<>();
    singleResponse.data = data;
    setSuccessResponse(singleResponse);

    return singleResponse;
 }   

 public<T> ListResponse<T> getListResponse(List<T> dataList) {
    ListResponse<T> listResponse = new ListResponse<>();
    listResponse.dataList = dataList;
    setSuccessResponse(listResponse);

    return listResponse;
 }   

 void setSuccessResponse(CommonResponse response){
    response.code = 0;
    response.success = true;
    response.message = "SUCCESS";
 }
}
