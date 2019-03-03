package org.soto.exception;

public class CodeDecodeQRException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CodeDecodeQRException(String mensaje, Throwable causa){
		super(mensaje, causa);
	}
	
	

}
