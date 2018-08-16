package com.example.controller;

import com.example.dto.SuperMarketDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SumMer
 * @version V1.0
 * @Title: SuperMarketController
 * @Package com.example.controller
 * @Description:
 * @date 2018-08-16 09:42
 * @ @Slf4j注解 等同于 private static final Log MY_LOG = LogFactory.getLog(SuperMarketController.class);
 */
@RestController
@RequestMapping("market")
@Slf4j
public class SuperMarketController {


    /**
     * 获取超市里所有的水果。
     * http://127.0.0.1:9099/market/supermarkents
     *
     * @return list集合
     */
    @GetMapping("supermarkents")
    public List<SuperMarketDTO> getAll() {

        Calendar c = Calendar.getInstance();
        c.set(2018, Calendar.AUGUST, 1);
        List<SuperMarketDTO> superMarketDTOList = new ArrayList<>();
        superMarketDTOList.add(this.watermelon());
        superMarketDTOList.add(this.peach());
        return superMarketDTOList;
    }


    /**
     * 查询某一种水果
     * http://127.0.0.1:9099/market/1
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public SuperMarketDTO getOne(@PathVariable Long id) {

        if (id == 1) {
            return watermelon();
        } else if (id == 2) {
            return peach();
        } else {
            log.error("没有找到ID为" + id + "的水果");
            throw new RuntimeException("没有找到ID为" + id + "的水果");
        }
    }

    /**
     * 添加商品
     * http://127.0.0.1:9099/market/goods
     * {
     * "name":"牛奶",
     * "expiryTime":12,
     * "manufacture":"2018-08-4",
     * "cost":4
     * }
     *
     * @param superMarketDTO
     * @return
     */
    @PostMapping("goods")
    public SuperMarketDTO insertGoods(@RequestBody SuperMarketDTO superMarketDTO) {

        log.info("这里应该写新增tvSeriesDto到数据库的代码, 传递进来的参数是：" + superMarketDTO);
        superMarketDTO.setId(999L);
        return superMarketDTO;
    }

    /**
     * 删除商品
     * http://127.0.0.1:9099/market/1?delete_reason=商品过期
     *
     * @return
     */
    @DeleteMapping("{id}")
    public Map<String, Object> deleteGoods(@PathVariable Long id,
            @RequestParam(value = "delete_reason", required = false) String deleteReason) {

        log.info("删除" + id + "号商品，删除原因：" + deleteReason);
        Map<String, Object> result = new HashMap<>();
        if (id == 1) {
            result.put("status", "success");
            result.put("msg", "成功删除" + id + "号商品，删除原因：" + deleteReason);
        } else if (id == 2) {
            result.put("status", "error");
            result.put("msg", "删除失败");
        } else {
            log.error("未查询到" + id + "号商品");
            throw new RuntimeException("未查询到" + id + "号商品");
        }
        return result;
    }

    /**
     * 更新商品
     * http://127.0.0.1:9099/market/1
     * {
     * "name":"牛奶",
     * "expiryTime":12,
     * "manufacture":"2018-08-4",
     * "cost":4
     * }
     *
     * @param id
     * @param superMarketDTO
     * @return
     */
    @RequestMapping(value = "{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public SuperMarketDTO updateGoods(@PathVariable Long id, @RequestBody SuperMarketDTO superMarketDTO) {

        log.info("修改" + id + "号商品，修改内容" + superMarketDTO);
        if (id == 1) {
            superMarketDTO.setId(id);
        }
        return superMarketDTO;
    }

    /**
     * 西瓜信息
     *
     * @return
     */
    private SuperMarketDTO watermelon() {

        Calendar c = Calendar.getInstance();
        c.set(2018, Calendar.AUGUST, 1);
        SuperMarketDTO superMarketDTO = new SuperMarketDTO();
        superMarketDTO.setId(1L);
        superMarketDTO.setCost(20.0);
        superMarketDTO.setName("西瓜");
        superMarketDTO.setExpiryTime(5);
        superMarketDTO.setManufacture(c.getTime());
        return superMarketDTO;
    }

    /**
     * 桃子信息
     *
     * @return
     */
    private SuperMarketDTO peach() {

        Calendar c = Calendar.getInstance();
        c.set(2018, Calendar.AUGUST, 10);
        SuperMarketDTO superMarketDTO = new SuperMarketDTO();
        superMarketDTO.setId(2L);
        superMarketDTO.setCost(20.0);
        superMarketDTO.setName("桃子");
        superMarketDTO.setExpiryTime(2);
        superMarketDTO.setManufacture(c.getTime());
        return superMarketDTO;
    }
}
