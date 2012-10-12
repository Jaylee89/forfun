package com.fbty.base.exception;

public class SystemException extends RuntimeException{

	public SystemException(){
		super();
	}
	
	public SystemException(String msg){
		super( msg );
	}
	
	public SystemException( Throwable throwable ){
		super(throwable);
	}
	
	public SystemException( String msg, Throwable throwable ){
		super(msg,throwable);
	}
}
