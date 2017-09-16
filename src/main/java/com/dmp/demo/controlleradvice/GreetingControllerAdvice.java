package com.dmp.demo.controlleradvice;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dmp.demo.controller.GreetingController;
import com.dmp.demo.error.CustomErrorType;
import com.dmp.demo.error.YouException;

@ControllerAdvice(basePackageClasses = GreetingController.class)
public class GreetingControllerAdvice extends ResponseEntityExceptionHandler {

	private final static Log log = LogFactory.getLog(GreetingControllerAdvice.class);
	
	@ExceptionHandler(YouException.class)
	@ResponseBody
	public ResponseEntity<?> handleControllerException(HttpServletRequest request, CustomErrorType error) {
        HttpStatus status = getStatus(request);
 
        log.info(ToStringBuilder.reflectionToString(error, ToStringStyle.DEFAULT_STYLE));
        log.info(ToStringBuilder.reflectionToString(status, ToStringStyle.DEFAULT_STYLE));

        return new ResponseEntity<>(error, status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
