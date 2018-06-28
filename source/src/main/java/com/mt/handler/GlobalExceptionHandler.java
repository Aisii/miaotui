package com.mt.handler;

import com.mt.util.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/** 
* @ClassName: GlobalExceptionHandler 
* @Description: 全局异常处理
*/
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private boolean debug = true;
	private String defaultMessage = "网络繁忙，请稍候再试";
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	//运行时异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public BaseResult runtimeExceptionHandler(RuntimeException ex) {
    	return buildResult(1000, debug, ex, defaultMessage);
    }  

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public BaseResult nullPointerExceptionHandler(NullPointerException ex) {
    	return buildResult(1001, debug, ex, defaultMessage);
    }   
    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public BaseResult classCastExceptionHandler(ClassCastException ex) {
    	return buildResult(1002, debug, ex, defaultMessage);
    }  

    //IO异常
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public BaseResult iOExceptionHandler(IOException ex) {  
    	return buildResult(1003, debug, ex, defaultMessage);
    }  
    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public BaseResult noSuchMethodExceptionHandler(NoSuchMethodException ex) {  
    	return buildResult(1004, debug, ex, defaultMessage);
    }  

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public BaseResult indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {  
    	return buildResult(1005, debug, ex, defaultMessage);
    }
    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public BaseResult httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex){
    	return buildResult(400, debug, ex, defaultMessage);
    }
    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public BaseResult typeMismatchExceptionHandler(TypeMismatchException ex){
    	return buildResult(400, debug, ex, defaultMessage);
    }
    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public BaseResult missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex){
    	return buildResult(400, debug, ex, defaultMessage);
    }
    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public BaseResult httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex){
    	return buildResult(405, debug, ex, defaultMessage);
    }
    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public BaseResult httpMediaTypeNotAcceptableExceptionHandler(HttpMediaTypeNotAcceptableException ex){
    	return buildResult(406, debug, ex, defaultMessage);
    }
    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class,HttpMessageNotWritableException.class})
    @ResponseBody
    public BaseResult server500ExceptinoHandler(RuntimeException ex){
    	return buildResult(500, debug, ex, defaultMessage);
    }
    
    private BaseResult buildResult(int code, boolean debug, Exception ex, String defaultMessage){
    	BaseResult result = new BaseResult(code);
    	result.setMessage(debug? ex.toString() : defaultMessage);
    	if(debug) ex.printStackTrace();
    	if(logger.isDebugEnabled()) 
    		logger.debug("{code:" + result.getCode() + ",message:" + result.getMessage() + "}");
    	return result;
    }

}
