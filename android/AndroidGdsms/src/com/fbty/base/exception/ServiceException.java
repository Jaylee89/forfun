package com.fbty.base.exception;

public class ServiceException extends RuntimeException{

	public ServiceException(){
		super();
	}
	
	public ServiceException(String msg){
		super( msg );
	}
	
	public ServiceException( Throwable throwable ){
		super(throwable);
	}
	
	public ServiceException( String msg, Throwable throwable ){
		super(msg,throwable);
	}
}
