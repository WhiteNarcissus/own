package com.mjc.own.rabbitmq.demo.pojo;

import javax.xml.transform.Source;
import java.io.Serializable;


/**
 * program 中定义的输入模板的参数
 */
public class Parameter implements Serializable {

    private Source source;

    private String parameterName;

    private Object value;

    private ParameterType parameterType;

    private boolean required;
    private Integer length;

    public static Parameter builder() {
        return new Parameter();
    }

    public Parameter value(Object value) {
        setValue(value);
        return this;
    }

    public Parameter source(Source source) {
        setSource(source);
        return this;
    }

    public Parameter parameterName(String parameterName) {
        setParameterName(parameterName);
        return this;
    }

    public Parameter required(boolean required) {
        setRequired(required);
        return this;
    }

    public Parameter parameterType(ParameterType parameterType) {
        setParameterType(parameterType);
        return this;
    }

    public Parameter length(Integer length) {
        setLength(length);
        return this;
    }






    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ParameterType getParameterType() {
        return parameterType;
    }

    public void setParameterType(ParameterType parameterType) {
        this.parameterType = parameterType;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public static class Source implements Serializable {
        private String moduleName;
        private String returnType;
        private String attrName;
        private String codeSource;
        private String returnTemplate;

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public String getReturnType() {
            return returnType;
        }

        public void setReturnType(String returnType) {
            this.returnType = returnType;
        }

        public String getAttrName() {
            return attrName;
        }

        public void setAttrName(String attrName) {
            this.attrName = attrName;
        }

        public String getCodeSource() {
            return codeSource;
        }

        public void setCodeSource(String codeSource) {
            this.codeSource = codeSource;
        }

        public String getReturnTemplate() {
            return returnTemplate;
        }

        public void setReturnTemplate(String returnTemplate) {
            this.returnTemplate = returnTemplate;
        }
    }

    public enum ParameterType {
        STRING,
        DATE,
        INT,
        ARR;
    }


}
