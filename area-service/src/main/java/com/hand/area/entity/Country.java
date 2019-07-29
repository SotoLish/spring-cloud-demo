package com.hand.area.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * 国家类
 *
 * @author liuqixin
 * @date 2019/7/25 09:53
 */
@Entity
@Table(name = "sc_country")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Country {

    /**
     * 国家ID
     */
    @Id
    @GeneratedValue
    private Long countryId;

    /**
     * 国家名
     */
    @Column
    @NotBlank
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

    @Override
    public String toString() {
        return "Country{"
                + "countryId=" + countryId
                + ", countryName='" + countryName + '\'' + '}';
    }

    public Country() {
    }
}
