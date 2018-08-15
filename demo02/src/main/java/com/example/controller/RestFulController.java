package com.example.controller;


import com.example.dto.PersonDTO;
import com.example.dto.TeamDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SumMer
 * @version V1.0
 * @Title: RestController
 * @Package com.example.controller
 * @Description:
 * @date 2018-08-15 15:06
 */
@RestController
public class RestFulController {


    /**
     * 获取全部人员信息
     *
     * @return map集合
     */
    @GetMapping("restindexmap")
    public Map<String, Object> restIndexMap() {

        List<TeamDTO> teamDTOList = new ArrayList<>();
        teamDTOList.add(new TeamDTO("小分队"));
        Map<String, Object> map = new HashMap<>(16);
        map.put("PERSON", new PersonDTO("0001", "小白", "DQ", "综合", teamDTOList));
        return map;
    }

    /**
     * 获取全部人员信息
     *
     * @return list集合
     */
    @GetMapping("restindexlist")
    public List<PersonDTO> restIndexList() {

        List<PersonDTO> personDTOArrayList = new ArrayList<>();
        List<TeamDTO> teamDTOList = new ArrayList<>();
        teamDTOList.add(new TeamDTO("小分队"));
        personDTOArrayList.add(new PersonDTO("0001", "小白", "DQ", "综合", teamDTOList));
        return personDTOArrayList;
    }

    /**
     * 增加人员
     *
     * @param personDTO 请求对象
     * @return
     */
    @PostMapping("person")
    public Map<String, Object> createPerson(@RequestBody PersonDTO personDTO) {

        Map<String, Object> map = new HashMap<>(16);
        map.put("PERSON", personDTO);
        return map;
    }

    /**
     * 获取指定人员
     *
     * @param personid
     * @return
     */
    @GetMapping("person/{personid}")
    public Map<String, Object> person(@PathVariable String personid) {

        List<PersonDTO> list = this.personList();
        for (PersonDTO person : list) {
            if (personid.equals(person.getPersonid())) {
                Map<String, Object> map = new HashMap<>(16);
                map.put("RESULT", "获取指定人员");
                map.put("MSG", "SUCCESS");
                map.put("PERSON", person);
                return map;
            }
        }
        return null;
    }

    /**
     * 删除
     *
     * @param personid
     * @return
     */
    @DeleteMapping("person/{personid}")
    public Map<String, Object> deletePerson(@PathVariable String personid) {

        List<PersonDTO> list = this.personList();
        for (PersonDTO person : list) {
            if (personid.equals(person.getPersonid())) {
                Map<String, Object> map = new HashMap<>(16);
                map.put("RESULT", "删除人员");
                map.put("MSG", "SUCCESS");
                map.put("PERSON", person);
                return map;
            }

        }
        return null;
    }


    /**
     * 向DTO中增加数据
     *
     * @return list
     */
    private List<PersonDTO> personList() {

        List<PersonDTO> personDTOList = new ArrayList<>();
        int i = 1;
        while (i <= 10) {
            List<TeamDTO> teamDTOList = new ArrayList<>();
            personDTOList.add(new PersonDTO("000" + i, "小白" + i, "DQ", "综合", teamDTOList));
            if (i % 2 == 0) {
                teamDTOList.add(new TeamDTO("小分队"));
            } else {
                teamDTOList.add(new TeamDTO("大分队"));
            }
            i++;
        }
        return personDTOList;
    }
}
