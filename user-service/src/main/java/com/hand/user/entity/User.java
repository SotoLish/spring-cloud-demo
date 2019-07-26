package com.hand.user.entity;

/**
 * 用户类
 *
 * @author liuqixin
 * @date 2019/7/25 10:15
 */
public class User {
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 性别
     */
    private String sex;
    /**
     * 国家ID
     */
    private Long countryId;
    /**
     * 国家名称
     */
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
