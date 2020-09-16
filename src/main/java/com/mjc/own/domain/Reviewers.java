package com.mjc.own.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

/**
 * 评论表
 */
@Table(name = "t_reviewers")
public class Reviewers {


    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    /**
     *  被评论的学号
     */
    @Column(name="stuIded")
    private String stuIded ;

    /**
     *  评论的学号
     */
    @Column(name="stuId")
    private String stuId ;

    /**
     * 留言信息
     */
    @Column(name="message")
    private String message ;


    /**
     *创建时间
     */
    @Column(name="create_time")
    private Date createTime ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuIded() {
        return stuIded;
    }

    public void setStuIded(String stuIded) {
        this.stuIded = stuIded;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
