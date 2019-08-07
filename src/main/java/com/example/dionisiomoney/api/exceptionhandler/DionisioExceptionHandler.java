package com.example.dionisiomoney.api.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DionisioExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String msgUser = messageSource.getMessage("message.invalid", null, LocaleContextHolder.getLocale());
		String msgDeveloper = ex.getCause().toString();
		
		List<Error> errors = Arrays.asList(new Error(msgUser, msgDeveloper));
		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Error> errors = createErrorsList(ex.getBindingResult());		
		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Error> createErrorsList(BindingResult bindingResult) {
		List<Error> errors = new ArrayList<>();
		
		for(FieldError fildError : bindingResult.getFieldErrors()) {
			String msgUser = messageSource.getMessage(fildError, LocaleContextHolder.getLocale());
			String msgDeveloper = fildError.toString();			
			errors.add(new Error(msgUser, msgDeveloper));
		}
		
		return errors;
	}
	
	public static class Error {
		
		private String msgUser;
		private String msgDeveloper;
		
		public Error(String msgUser, String msgDeveloper) {
			this.msgUser = msgUser;
			this.msgDeveloper = msgDeveloper;
		}

		public String getMsgUser() {
			return msgUser;
		}

		public String getMsgDeveloper() {
			return msgDeveloper;
		}
	}
}