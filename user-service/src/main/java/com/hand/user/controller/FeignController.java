package com.hand.user.controller;

import com.hand.user.entity.Country;
import com.hand.user.entity.User;
import com.hand.user.feign.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Feign 控制层
 *
 * @author liuqixin
 * @date 2019/7/25 10:57
 */
@RestController
@RequestMapping("/user")
public class FeignController {
    private static final List<User> USER_LIST;

    private CountryService countryService;

    @Autowired
    public FeignController(CountryService countryService) {
        this.countryService = countryService;
    }

    static {
        List<User> userList = new ArrayList<>();
        userList.add(new User()
                .setId(5L)
                .setUsername("User 05")
                .setCountryId(1L)
                .setEmail("user05@demo.com")
                .setSex("女"));
        userList.add(new User()
                .setId(4L)
                .setUsername("User 04")
                .setCountryId(2L)
                .setEmail("user04@demo.com")
                .setSex("男"));
        // 错误的CountryId导致出错演示
        userList.add(new User()
                .setId(6L)
                .setUsername("User 06")
                .setCountryId(3L)
                .setEmail("user06@demo.com")
                .setSex("男"));
        USER_LIST = userList;
    }

    /**
     * 使用Feign调用服务
     *
     * @param
     * @author liuqixin
     * @date 2019/07/25 11:16
     */
    @GetMapping("/feign")
    public List<User> queryUser() {
        List<User> userList = new ArrayList<>(USER_LIST);
        userList.forEach(user -> {
            Country country = countryService.queryCountry(user.getCountryId());
            user.setCountryName(country.getCountryName());
        });
        return userList;
    }

}
