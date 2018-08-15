package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * @author SumMer
 * @version V1.0
 * @Title: TeamDTO
 * @Package com.example.dto
 * @Description:
 * @date 2018-08-15 15:12
 */
@Data
public class TeamDTO {

    @NonNull
    @JsonProperty("TEAMNAME")
    private String teamname;
}
