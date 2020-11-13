package com.mjc.own.rabbitmq.demo.pojo;

import org.springframework.context.annotation.Primary;
import org.springframework.util.CollectionUtils;

import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

public class Action extends ProtoEntity {
 public static final String VALID = "valid";
 public static final String INVALID = "invalid";
 public static final String PROCESSING = "processing";
 public static final String PENDING = "pending";

 private Long actionId ;
 private String programCode ;
 private Long caseId ;
 private String nodeCode ;

 private Long taskId;

 private String status ;


 public String toString(){
     return "Action{"+
             "actionId='" +actionId+'\''+
             ",programCode='"+programCode+'\''+
             ",caseId='"+caseId+'\''+
             ",nodeCode='"+nodeCode+'\''+
             ",taskId='"+taskId+'\''+
             ",status='"+status+'\''+
              '}';
 }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
