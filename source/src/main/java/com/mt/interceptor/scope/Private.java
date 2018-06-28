package com.mt.interceptor.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 私有功能，只有得到授权才能访问
 */
@Target( {
        TYPE, METHOD
})
@Retention(RUNTIME)
public @interface Private {

	/**
	 * 绑定其它uri的权限
	 * 
	 * @return
	 */
	String[] value() default {};

}
