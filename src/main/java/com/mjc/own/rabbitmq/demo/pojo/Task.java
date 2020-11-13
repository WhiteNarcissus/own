package com.mjc.own.rabbitmq.demo.pojo;

import org.springframework.util.CollectionUtils;

import java.util.List;

public class Task extends ProtoEntity {

    public static final String PROCESSING = "processing";
    public static final String SUCCESS ="success" ;

    public static final String FAIL = "fail";

    private static final long serialVersionUID = -323423424244444443L;

    private Long taskId ;

    private Long caseId ;

    private String barCode ;

    private String nodeCode ;

    private String lastNode ;

    private String originalNode ;

    private String status ;

    private List<Program> programs ;
    //指定action 处理人
    private Long nextProcessor ;
    private Integer curProgIndex = 0 ;
    private Long currentProcessor ;

    private TaskType taskType = TaskType.MAIN;
    private String flow ;
    enum   TaskType {
        MAIN("MAIN","主流程"),
        OTHER("OTHER","其他流程");
        String code ;
        String name ;
        TaskType(String code ,String name ){
            this.code = code ;
            this.name = name ;
        }

        public String getCode(){
            return code ;
        }

        public String getName(){
            return name ;
        }
    }


    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getLastNode() {
        return lastNode;
    }

    public void setLastNode(String lastNode) {
        this.lastNode = lastNode;
    }

    public String getOriginalNode() {
        return originalNode;
    }

    public void setOriginalNode(String originalNode) {
        this.originalNode = originalNode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        if(!CollectionUtils.isEmpty(programs)){
            for(Program program : programs){
                program.setTask(this);
            }
        }
        this.programs = programs;
    }

    public Program getcurrentProgram(){
        List<Program> programs = getPrograms();
        if(CollectionUtils.isEmpty(programs)){
            return null ;
        }
        return programs.get(getCurProgIndex());
    }

    public Program getLastProgram(){
        if(!CollectionUtils.isEmpty(getPrograms())){
            int length = getPrograms().size();
            return  getPrograms().get(length-1);
        }
        return  new Program();
    }



    public Long getNextProcessor() {
        return nextProcessor;
    }

    public void setNextProcessor(Long nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public Integer getCurProgIndex() {
        return curProgIndex;
    }

    public void setCurProgIndex(Integer curProgIndex) {
        this.curProgIndex = curProgIndex;
    }

    public Long getCurrentProcessor() {
        return currentProcessor;
    }

    public void setCurrentProcessor(Long currentProcessor) {
        this.currentProcessor = currentProcessor;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }
}
