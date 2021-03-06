package com.example.dto;

import lombok.Data;
import lombok.NonNull;

/**
 * @author SumMer
 * @version V1.0
 * @Title: IndexDTO
 * @Package com.example.dto
 * @date 2018-08-09 10:12
 */
@Data
public class IndexDTO {

    @NonNull
    private String name;

    private String sex;

    private Integer age;

}
