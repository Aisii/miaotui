package com.mt.interceptor.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 公开的功能，不受权限控制
 */
@Target( {
        TYPE, METHOD
})
@Retention(RUNTIME)
public @interface Public {

}
