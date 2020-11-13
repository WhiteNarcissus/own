package com.mjc.own.rabbitmq.demo.pojo;



import javax.swing.*;
import java.lang.reflect.Parameter;

public class Program extends ProtoEntity {
   private static final long serialVersionUID  = -23423423424234l;
   private static final Byte ENDFLG = 100;
   private static Program end = new Program();

   static {
      end.setProgramId(Long.MIN_VALUE);
      end.setStatus(Program.ENDFLG);
      end.setRemark("this  is the end of Program");
   }


   private Long programId ;

   private String programCode ;
   private String programName ;
   private String programType ;
   private Byte status ;
   private String inputField;
   private String remark ;
   private String outputField;
   private Task task ;
   private Action action ;
   private Parameters inputMap ;
   private Parameters  outputMap ;


   private Integer priority ;


   public Long getProgramId() {
      return programId;
   }

   public void setProgramId(Long programId) {
      this.programId = programId;
   }

   public String getProgramCode() {
      return programCode;
   }

   public void setProgramCode(String programCode) {
      this.programCode = programCode;
   }

   public String getProgramName() {
      return programName;
   }

   public void setProgramName(String programName) {
      this.programName = programName;
   }

   public Byte getStatus() {
      return status;
   }

   public void setStatus(Byte status) {
      this.status = status;
   }

   public String getInputField() {
      return inputField;
   }

   public void setInputField(String inputField) {
      this.inputField = inputField;
   }

   public String getRemark() {
      return remark;
   }

   public void setRemark(String remark) {
      this.remark = remark;
   }

   public String getOutputField() {
      return outputField;
   }

   public void setOutputField(String outputField) {
      this.outputField = outputField;
   }

   public Task getTask() {
      return task;
   }

   public void setTask(Task task) {
      this.task = task;
   }

   public Action getAction() {
      return action;
   }

   public void setAction(Action action) {
      this.action = action;
   }

   public Integer getPriority() {
      return priority;
   }

   public void setPriority(Integer priority) {
      this.priority = priority;
   }

   public Parameters getInputMap() {
      return inputMap;
   }

   public void setInputMap(Parameters inputMap) {
      this.inputMap = inputMap;
   }

   public Parameters getOutputMap() {
      return outputMap;
   }

   public void setOutputMap(Parameters outputMap) {
      this.outputMap = outputMap;
   }

   public String getProgramType() {
      return programType;
   }

   public void setProgramType(String programType) {
      this.programType = programType;
   }
}
