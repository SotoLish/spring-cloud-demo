package com.hand.area.controller;

import com.hand.area.entity.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 区域控制层
 *
 * @author liuqixin
 * @date 2019/7/25 09:57
 */
@RestController
public class AreaController {

    private static final Map<Long, Country> COUNTRY_MAP;

    static {
        Map<Long, Country> countryMap = new HashMap<>();
        countryMap.put(1L, new Country().setCountryId(1L).setCountryName("中国"));
        countryMap.put(2L, new Country().setCountryId(2L).setCountryName("其他"));
        COUNTRY_MAP = Collections.unmodifiableMap(countryMap);
    }

    @GetMapping("/country/{countryId}")
    public Country queryCountry(@PathVariable long countryId) throws InterruptedException {
        // 测试超时异常，默认超时是1s，设置延迟3s，触发超时
//        Thread.sleep(3000);
        if (COUNTRY_MAP.containsKey(countryId)) {
            return COUNTRY_MAP.get(countryId);
        }
        throw new RuntimeException("Country not found!");
    }

}
