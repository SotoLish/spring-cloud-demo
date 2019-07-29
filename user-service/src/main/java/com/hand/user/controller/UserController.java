package com.hand.user.controller;

import com.hand.area.entity.Country;
import com.hand.user.entity.User;
import com.hand.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 用户控制层
 *
 * @author liuqixin
 * @date 2019/7/26 14:48
 */
@RestController
@RequestMapping("/user/rest")
public class UserController {
    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final String URL_ID = "http://area-service/country/{countryId}";
    private static final String URL = "http://area-service/country";

    private UserService userService;


    /**
     * REST模板
     */
    private RestTemplate restTemplate;

    @Autowired
    public UserController(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }


    /**
     * 获取用户列表
     * @return
     */
    @GetMapping
    public List<User> list() {
        List<User> users = userService.getList();
        users.forEach(user -> {
            try {
                Country country = restTemplate.getForObject(URL_ID,
                        Country.class,
                        user.getCountryId());
                user.setCountryName(country.getCountryName());
            } catch (RestClientException e) {
                logger.error(e.getMessage());
                user.setCountryName("Error");
            }
        });
        return users;
    }



    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @author liuqixin
     * @date 2019/07/23 11:23
     */
    @GetMapping("/{id}")
    public User query(@PathVariable long id) {
        User user = userService.queryById(id);
        Country country = restTemplate.getForObject(URL_ID, Country.class, user.getCountryId());
        user.setCountryName(country.getCountryName());
        return user;
    }

    /**
     * 新建用户
     *
     * @param user
     * @author liuqixin
     * @date 2019/07/23 11:23
     */
    @PostMapping
    public User create(@RequestBody @Validated User user, BindingResult bindingResult) {
        Country country = restTemplate.getForObject(URL_ID,
                Country.class,
                user.getCountryId());
        user.setCountryName(country.getCountryName());
        return userService.create(user);
    }

    /**
     * 更新用户
     *
     * @param user
     * @author liuqixin
     * @date 2019/07/23 11:24
     */
    @PutMapping
    public User update(@RequestBody User user) {
        Country country = restTemplate.getForObject(URL_ID,
                Country.class,
                user.getCountryId());
        user.setCountryName(country.getCountryName());
        return userService.create(user);
    }


    /**
     * 根据ID删除用户
     *
     * @param id
     * @author liuqixin
     * @date 2019/07/23 11:24
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }


}
