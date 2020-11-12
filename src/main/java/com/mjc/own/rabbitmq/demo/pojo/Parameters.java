package com.mjc.own.rabbitmq.demo.pojo;

import com.alibaba.fastjson.JSONObject;
import groovyjarjarantlr.StringUtils;
import tk.mybatis.mapper.util.StringUtil;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 由参数模板转换的
 *
 */
public class Parameters  implements Serializable {

    private final static Parameters EMPTYOBJECT = new Parameters();

    /*
      key 参数名 value 参数模板
     */
    private Map<String ,Parameter> parameters ;
    public Parameters(){
        parameters = new ConcurrentHashMap<>();
    }
   public static Parameters emptyParameters(){return EMPTYOBJECT;}

    /**
     * String  转Parameters
     */
   public static Parameters parseParameters(String res){
       if(StringUtil.isEmpty(res)){
           return Parameters.emptyParameters();
       }
       return parseParameters(JSONObject.parseObject(res));
   }

   public static Parameters parseParameters(Map<String,Object> object ){
       Objects.requireNonNull(object);
       Parameters newParam = new Parameters();
       for(String key : object.keySet()){
           newParam.put(key ,convertParameter(key ,object.get(key)));
       }
       return newParam ;
   }

   private void put(String  key ,Parameter val){
       parameters.put(key,val);
   }
   private static  Parameter convertParameter(String key ,Object val){
       if(val instanceof JSONObject){
           return null ;
       }else if(val instanceof String){
           return null ;
       }else {
           return Parameter.builder().value(val).parameterType(Parameter.ParameterType.INT);
       }
   }

}
