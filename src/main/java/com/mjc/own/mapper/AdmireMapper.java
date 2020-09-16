package com.mjc.own.mapper;


import com.mjc.own.domain.Admire;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmireMapper  extends TkMapper<Admire>  {

   void  updateAdmire(Admire admire);
}
