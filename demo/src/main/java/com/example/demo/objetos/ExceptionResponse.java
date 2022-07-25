package com.example.demo.objetos;

import java.util.Date;

import lombok.Data;


@Data
public class ExceptionResponse {

    private Date timestamp;
    private String status;
    private String message;
    private String path;
    
    
    
	public ExceptionResponse(Date timestamp, String status, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.path = path;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
    
    

}