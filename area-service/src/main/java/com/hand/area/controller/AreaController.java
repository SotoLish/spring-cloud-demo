package com.hand.area.controller;

import com.hand.area.entity.Country;
import com.hand.area.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 区域控制层
 *
 * @author liuqixin
 * @date 2019/7/25 09:57
 */
@RestController
@RequestMapping("/country")
public class AreaController {

    private CountryService countryService;

    @Autowired
    public AreaController(CountryService countryService) {
        this.countryService = countryService;
    }

    public AreaController() {
    }

    @GetMapping("/{countryId}")
    public Country queryCountry(@PathVariable Long countryId) {
        return countryService.queryById(countryId);
    }

    @GetMapping
    public List<Country> list() {
        return countryService.getList();
    }

    @PostMapping
    public Country create(@RequestBody @Validated Country country, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException(bindingResult.toString());
        }
        System.out.println(country);
        return countryService.create(country);
    }

    @PutMapping
    public Country update (@RequestBody Country country){
        return countryService.update(country);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        countryService.delete(id);
    }


}
