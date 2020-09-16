package com.mjc.own.service.impl;


import com.mjc.own.common.DateUtil;
import com.mjc.own.domain.Promo;
import com.mjc.own.mapper.PromoMapper;
import com.mjc.own.service.PromoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PromoServiceImpl implements PromoService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PromoMapper promoMapper;

    public void insert(Promo promo) throws Exception {
        if(promo.getStuId()!=null){
            promo.setCreateTime(DateUtil.getTimestamp());
            promoMapper.insert(promo);
        }else{
            throw new Exception("请先登录");

        }

    }

    @Override
    public List<Promo> select(Promo promo) throws Exception {
        List<Promo> promos ;
        if("".equals(promo.getStuId())&&"".equals(promo.getTitle())){
            Example example = new Example(Promo.class);
            example.createCriteria().andNotEqualTo("id",0);
            example.setOrderByClause("create_time DESC");
            promos =promoMapper.selectByExample(example);
        }else {
            Example example = new Example(Promo.class);
            example.createCriteria().andEqualTo("stuId", promo.getStuId());
            example.createCriteria().andLike("title", promo.getTitle());
            example.setOrderByClause("create_time DESC");
            promos= promoMapper.selectByExample(example);
        }
        return promos;
    }

    @Override
    public void delete(String id) {
        Example example = new Example(Promo.class);
        example.createCriteria().andEqualTo("id",Integer.parseInt(id));
        promoMapper.deleteByExample(example);
    }
}
