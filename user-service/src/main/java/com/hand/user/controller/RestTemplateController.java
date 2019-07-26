package com.hand.user.controller;

import com.hand.user.entity.Country;
import com.hand.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户控制层
 *
 * @author liuqixin
 * @date 2019/7/25 10:27
 */
@RestController
@RequestMapping("/user")
public class RestTemplateController {
    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(RestTemplateController.class);
    /**
     * 用户对象
     */
    private static final List<User> USER_LIST;

    // 给用户列表初始化
    static {
        List<User> userList = new ArrayList<>();
        userList.add(new User()
                .setId(1L)
                .setUsername("User 01")
                .setCountryId(1L)
                .setEmail("user01@demo.com")
                .setSex("女"));
        userList.add(new User()
                .setId(2L)
                .setUsername("User 02")
                .setCountryId(2L)
                .setEmail("user02@demo.com")
                .setSex("男"));
        // 错误的CountryId导致出错演示
        userList.add(new User()
                .setId(3L)
                .setUsername("User 03")
                .setCountryId(3L)
                .setEmail("user03@demo.com")
                .setSex("男"));
        USER_LIST = userList;
    }

    /**
     * REST模板
     */
    private RestTemplate restTemplate;

    /**
     * 构造方法
     *
     * @param restTemplate
     */
    @Autowired
    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/rest-template")
    public List<User> queryUser() {
        List<User> userList = new ArrayList<>(USER_LIST);
        userList.forEach(user -> {
            try {
                Country country = restTemplate.getForObject("http://area-service/country/{countryId}",
                        Country.class,
                        user.getCountryId());
                user.setCountryName(country.getCountryName());
            } catch (RestClientException e) {
                logger.error(e.getMessage());
            }

        });
        return userList;
    }
}
