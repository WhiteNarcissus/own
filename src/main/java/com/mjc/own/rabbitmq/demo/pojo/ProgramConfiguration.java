package com.mjc.own.rabbitmq.demo.pojo;

import com.mjc.own.rabbitmq.demo.executor.BaseProgramExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * program code 和 executor 的对应
 */
public class ProgramConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ProgramConfiguration.class);
    private static final ProgramConfiguration PROGRAM_CONFIGURATION  = new ProgramConfiguration();

    private final Map<String, BaseProgramExecutor> programMapping = new HashMap<>();

    private ProgramConfiguration(){}

    private static ProgramConfiguration getConfig(){
        return PROGRAM_CONFIGURATION ;
    }

    public void put(String programCode ,BaseProgramExecutor executor){
        programMapping.put(programCode,executor);
    }

    public BaseProgramExecutor getExecutor(String programCode){
        if(null != programMapping.get(programCode)){
            return programMapping.get(programCode);
        }
         logger.error("no executor ["+programCode+"] registered");
        return null ;
    }

    public boolean containExecutors(String programCode){
        if(Objects.nonNull(programMapping.get(programCode))){
            return true;
         }
         return  false ;
    }

}
