package com.mjc.own.rabbitmq.demo.pojo;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import groovyjarjarantlr.StringUtils;
import tk.mybatis.mapper.util.StringUtil;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
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
   public void putParameterValue(String key ,Object value){
       parameters.put(key,Parameter.builder().parameterName(key).value(value));
   }
    public void putParameterValue(String key ,Object value,Parameter.ParameterType parameterType){
      parameters.put(key,Parameter.builder().parameterName(key).parameterType(parameterType).value(value));
    }
   public Parameter get(String nodeCode){return  parameters.get(nodeCode);}
   public Set<String> keySet(){return parameters.keySet();}
   public int size(){return  parameters.size();}
   public boolean containsKey(String key){return  this.parameters.containsKey(key);}
   public void removeParameter(String key){
       parameters.remove(key);
   }
   public static boolean isEmpty(Parameters parameters){return  null == parameters || parameters.size() == 0 ;}
   private static  Parameter convertParameter(String key ,Object val){
       if(val instanceof JSONObject){
           JSONObject value = (JSONObject) val ;
           String sourceStr = (String) value.get("source");
           Parameter.Source source =new  Parameter.Source();
           if(!StringUtil.isEmpty(sourceStr)){
               String[] arr =sourceStr.split("[.]");
               source.setModuleName(arr[0]);
               source.setCodeSource(arr[1]);
               source.setReturnTemplate(Joiner.on(".").join(Arrays.copyOfRange(arr,2,arr.length-1)));
               source.setAttrName(arr[arr.length-1]);
           }
           return  Parameter.builder().parameterName(key)
                   .value(value.get(value))
                   .source(source)
                   .length(value.get("length") == null ? 0 : Integer.valueOf(value.get("length").toString()))
                   .required(value.get("required") != null && (boolean) value.get("required"))
                   .parameterType(value.get("parameterType") == null ? Parameter.ParameterType.STRING : Parameter.ParameterType.valueOf((String)(value.get("parameterType"))));
       }else if(val instanceof String){
           try {
               JSONObject jsonObject = JSONObject.parseObject((String) val);
               return  convertParameter(key,jsonObject);

           }catch (RuntimeException exc ){
               return  Parameter.builder().value(val).parameterType(Parameter.ParameterType.STRING);
           }
       }else {
           return Parameter.builder().value(val).parameterType(Parameter.ParameterType.INT);
       }
   }




}
