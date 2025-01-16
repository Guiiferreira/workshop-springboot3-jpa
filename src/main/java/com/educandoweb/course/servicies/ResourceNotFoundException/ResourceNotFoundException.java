package com.educandoweb.course.servicies.ResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
//sub classe do RunTimeeException que o compilador nao te obriga a tratar
	
	
	
	public ResourceNotFoundException(Object id) {//passa o id que tentei encotrar e não encontrei 
		
		super("Resource not found. Id " + id);
	}
	
	
	
}
