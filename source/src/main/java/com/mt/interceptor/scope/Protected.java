package com.mt.interceptor.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 受保护的功能，需登录才能访问
 */
@Target( {
        TYPE, METHOD
})
@Retention(RUNTIME)
public @interface Protected {

}
