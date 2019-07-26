package com.hand.area.entity;

/**
 * 国家类
 *
 * @author liuqixin
 * @date 2019/7/25 09:53
 */
public class Country {

    /**
     * 国家ID
     */
    private Long countryId;

    /**
     * 国家名
     */
    private String countryName;

    public Long getCountryId() {
        return countryId;
    }

    public Country setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public Country setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }
}
