package com.weplanner.weplanner.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    boolean success;
    int code;
    String message;
}
