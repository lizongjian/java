package com.wuzhou.test14Annotation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解	

//元注解 1.  注解的声明周期 ，编译的时候保留，运行时被抛弃。
@Retention(RetentionPolicy.CLASS)
//元注解2.  注解可用于修饰哪些类型
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
public @interface CustomAnnotation {
	
	String value() default "hello";
}
