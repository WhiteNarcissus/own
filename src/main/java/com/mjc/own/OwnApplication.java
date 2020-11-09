package com.mjc.own;

import com.mjc.own.mapper.TkMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = {"com.mjc.own.mapper"}, markerInterface = TkMapper.class)

@SpringBootApplication
public class OwnApplication {

    public static void main(String[] args) {
        SpringApplication.run(OwnApplication.class, args);
    }

}
