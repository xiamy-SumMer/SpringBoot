package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author SumMer
 * @version V1.0
 * @Title: SuperMarketDTO
 * @Package com.example.dto
 * @Description:
 * @date 2018-08-16 09:39
 */
@Getter
@Setter
@ToString
public class SuperMarketDTO {

    private Long id;

    private String name;

    private Integer expiryTime;

    private Date manufacture;

    private Double cost;
}
