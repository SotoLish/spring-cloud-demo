package com.hand.user.service;

import com.hand.area.entity.Country;
import com.hand.user.service.fallback.CountryServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 国家服务接口
 *
 * @author liuqixin
 * @date 2019/7/25 11:01
 */
@FeignClient(name = "area-service", fallback = CountryServiceImpl.class)
public interface CountryService {

    @GetMapping("/country/{countryId}")
    Country queryCountry(@PathVariable(name = "countryId") long countryId);
}
