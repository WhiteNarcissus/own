package com.mjc.own.domain;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_test")
public class Test implements Serializable {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id ;

        @Column(name = "test_name")
        private String testName;

        @Column(name = "test_time")
        private Date testTime;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getTestName() {
                return testName;
        }

        public void setTestName(String testName) {
                this.testName = testName;
        }

        public Date getTestTime() {
                return testTime;
        }

        public void setTestTime(Date testTime) {
                this.testTime = testTime;
        }
}
