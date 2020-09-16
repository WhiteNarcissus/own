package com.mjc.own.domain;


import java.util.Date;
import java.util.List;

/**
 * 用于二手市场的 数据渲染对象
 */
public class SecondHandView {

    /**
     *  发布时间差
     *  现在时间 - 发布前时间 单位分钟 / 小时
     */
    private String pushTimeCut;
    /**
     * 发布商品图片
     * 图片存在 E 盘下的 upload文件夹下
     */
    private List<String> pushImageUrl ;

    /**
     *  学号
     */
    private String stuId ;

    /**
     * 图片内容
     */
    private String content ;


    /**
     * 评论
     */
   private List<Reviewers> reviewers ;

    /**
     * 点赞
     */
    private String admires ;

    /**
     * 创建时间
     */
   private Date createTime ;

    /**
     * 价格
     * @return
     */
   private Double price ;


    private String contact;


    private String contactType;

    public String getPushTimeCut() {
        return pushTimeCut;
    }

    public void setPushTimeCut(String pushTimeCut) {
        this.pushTimeCut = pushTimeCut;
    }

    public List<String> getPushImageUrl() {
        return pushImageUrl;
    }

    public void setPushImageUrl(List<String> pushImageUrl) {
        this.pushImageUrl = pushImageUrl;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Reviewers> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<Reviewers> reviewers) {
        this.reviewers = reviewers;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAdmires() {
        return admires;
    }

    public void setAdmires(String admires) {
        this.admires = admires;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
}
