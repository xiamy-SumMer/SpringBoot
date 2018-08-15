package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * @author SumMer
 * @version V1.0
 * @Title: RestDTO
 * @Package com.example.dto
 * @Description:
 * @date 2018-08-15 15:09
 */
@Data
public class PersonDTO {

    @NonNull
    @JsonProperty("PERSONID")
    private String personid;

    @NonNull
    @JsonProperty("DISPLAYNAME")
    private String displayname;

    @NonNull
    @JsonProperty("PROFESSION")
    private String profession;

    @NonNull
    @JsonProperty("DEPARTMENT")
    private String department;

    @NonNull
    @JsonProperty("TEAMDTOLIST")
    private List<TeamDTO> teamDTOList;

}
