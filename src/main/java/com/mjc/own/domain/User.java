package com.mjc.own.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_user")
public class User implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户姓名
     */
    @Column(name = "stuId")
    @Length(min = 3, max = 6, message = "学号长度必须位于3到6之间")
    private String stuId;

    /**
     * 密码在 6-15位，字母+数字
     */

    @Column(name = "user_password")
    @Length(min = 5, max = 15, message = "用户名长度必须位于5到15之间")
    private String userPassword;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_hobbit")
    private String userHobbit;

    @Column(name = "user_message")
    private Integer userMessage;

    @Column(name = "remember")
    private String remember;




    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    /**
     * 获取密码在 6-15位，字母+数字
     *
     * @return user_password - 密码在 6-15位，字母+数字
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置密码在 6-15位，字母+数字
     *
     * @param userPassword 密码在 6-15位，字母+数字
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return created_time
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return user_phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * @return user_hobbit
     */
    public String getUserHobbit() {
        return userHobbit;
    }

    /**
     * @param userHobbit
     */
    public void setUserHobbit(String userHobbit) {
        this.userHobbit = userHobbit;
    }

    public Integer getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(Integer userMessage) {
        this.userMessage = userMessage;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }



    public  User(){
    }

   public   User(String stuId ,Integer userMessage ){
        setStuId(stuId);
        setUserMessage(userMessage);
    }



}