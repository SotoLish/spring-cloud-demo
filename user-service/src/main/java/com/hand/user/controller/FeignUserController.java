package com.hand.user.controller;

import com.hand.area.entity.Country;
import com.hand.user.entity.User;
import com.hand.user.service.CountryService;
import com.hand.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Feign 控制层
 * 使用Feign调用 area-service 服务
 * @author liuqixin
 * @date 2019/7/25 10:57
 */
@RestController
@RequestMapping("/user/feign")
public class FeignUserController {

    private CountryService countryService;
    private UserService userService;

    @Autowired
    public FeignUserController(@Qualifier("CountryService") CountryService countryService, UserService userService) {
        this.countryService = countryService;
        this.userService = userService;
    }

    @GetMapping
    public List<User> queryUser() {
        List<User> users = userService.getList();
        users.forEach(user -> {
            user.setCountryName(countryService.queryCountry(user.getCountryId()).getCountryName());
        });
        return users;
    }

    @GetMapping("/{id}")
    public User query(@PathVariable long id) {
        User user = userService.queryById(id);
        Country country = countryService.queryCountry(user.getCountryId());
        user.setCountryName(country.getCountryName());
        return user;
    }

    @PostMapping
    public User create(@RequestBody @Validated User user, BindingResult bindingResult) {
        Country country = countryService.queryCountry(user.getCountryId());
        user.setCountryName(country.getCountryName());
        return userService.create(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        Country country = countryService.queryCountry(user.getCountryId());
        user.setCountryName(country.getCountryName());
        return userService.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }

}
