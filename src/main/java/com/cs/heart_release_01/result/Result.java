package com.cs.heart_release_01.result;

import lombok.Data;

/**
 * @author Guo Jiaqi
 * @version 1.0
 * @date 2020/10/5 13:03
 */
@Data
public class Result<T>{
    private String code;
    private String msg;
    private T data;
}
