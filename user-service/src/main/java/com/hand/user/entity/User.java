package com.hand.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * 用户类
 *
 * @author liuqixin
 * @date 2019/7/25 10:15
 */
@Entity
@Table(name = "sc_user")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 用户名
     */
    @Column
    @NotBlank
    private String username;
    /**
     * 邮箱
     */
    @Column
    private String email;
    /**
     * 性别
     */
    @Column
    private String sex;
    /**
     * 国家ID
     */
    @Column
    private Long countryId;
    /**
     * 国家名称
     */
    @Transient // 此属性不作为数据库字段
    private String countryName;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public User setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public Long getCountryId() {
        return countryId;
    }

    public User setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public User setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }
}
