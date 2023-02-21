package me.flash;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)   //default : RetentionPolicy.CLASS
@Target({ElementType.TYPE, ElementType.METHOD})  //생성자, 메소드에만 적용 가능
@Inherited
public @interface FlashAnnotation {
}
