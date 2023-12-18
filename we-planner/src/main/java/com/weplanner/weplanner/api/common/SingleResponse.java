package com.weplanner.weplanner.api.common;

import lombok.Getter;

@Getter
public class SingleResponse<T> extends CommonResponse {
    T data;    
}
