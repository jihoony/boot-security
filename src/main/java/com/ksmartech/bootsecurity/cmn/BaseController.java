package com.ksmartech.bootsecurity.cmn;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

public abstract class BaseController extends BaseComponent {

    @ExceptionHandler
    @ResponseBody
    protected HashMap<String, Object> handleException(Exception e){

        logger.error(e.getMessage(), e);

        HashMap<String, Object> map = new HashMap<>();

        if (e instanceof BadCredentialsException){

            BadCredentialsException bce = (BadCredentialsException) e;
            logger.error(bce.getMessage());

            map.put("BadCredentialsException", e);

        } else if (e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException manve = (MethodArgumentNotValidException) e;

            MethodParameter parameter = manve.getParameter();

            logger.error("=================================================");
            logger.error("== Catch MethodArgumentNotValidException ");
            logger.error("== Rised On: " + parameter.getMethod().getDeclaringClass() + "." + parameter.getMethod().getName());
            logger.error("== Rised At: " + parameter.getParameterType() + " " + parameter.getParameterName());
            logger.error("== Message: " + manve.getMessage());
            logger.error("== Details: " + manve.getBindingResult().getFieldErrors());
            logger.error("=================================================");


            map.put("MethodArgumentNotValidException", e);

        } else if (e instanceof HttpMessageNotReadableException) {
            HttpMessageNotReadableException hmnre = (HttpMessageNotReadableException) e;

            logger.error("=================================================");
            logger.error("== Catch HttpMessageNotReadableException ");

            logger.error(hmnre.getMostSpecificCause().getMessage());

            logger.error("=================================================");

            map.put("HttpMessageNotReadableException", e);
        } else if (e instanceof UsernameNotFoundException ){
            UsernameNotFoundException unfe = (UsernameNotFoundException) e;
            logger.error(unfe.getMessage());

            map.put("UsernameNotFoundException", e);
        } else {
            map.put("Unknown Error", e);
        }

        return map;
    }
}
