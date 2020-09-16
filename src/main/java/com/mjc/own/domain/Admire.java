package com.mjc.own.domain;


import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

/**
 * 点赞表
 *
 */
@Table(name = "t_admire")
public class Admire {

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
     * 点赞信息 奇数 赞 偶数 不赞
     */
    @Column(name="admire")
    private Integer admire ;


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

    public Integer getAdmire() {
        return admire;
    }

    public void setAdmire(Integer admire) {
        this.admire = admire;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
