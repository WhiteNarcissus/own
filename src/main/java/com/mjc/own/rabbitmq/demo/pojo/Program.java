package com.mjc.own.rabbitmq.demo.pojo;

import javafx.concurrent.Task;

import javax.swing.*;
import java.lang.reflect.Parameter;

public class Program extends ProtoEntity {
   private static final long serialVersionUID  = -23423423424234l;
   private static final Byte ENDFLG = 100;
   private static Program end = new Program();

   static {

   }


   private Long programId ;

   private String programCode ;
   private String programName ;
   private String status ;
   private String inputField;
   private String remark ;
   private String outputField;
   private Task task ;
   private Action action ;
//   private Parameters inputMap ;
//   private Parameters  outputMap ;


   private Integer priority ;


}
