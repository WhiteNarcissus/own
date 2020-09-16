package com.mjc.own.service;



import com.mjc.own.domain.Promo;

import java.util.List;

public interface PromoService {
     void insert(Promo promo) throws Exception;
     List<Promo> select(Promo promo)throws Exception;
     void delete(String id);

}
