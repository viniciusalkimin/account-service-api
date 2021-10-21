/*
--+
    | Project ACCOUNT SERVICE API - Java Class File : 1.0.0 Data: 10/06/2018
    | Copyright(c) by ProfitCode IT Solutions
    |
    | All rights reserved.
    |
    | This software is confidential and proprietary information of
    | ProfitCode IT Solutions ("Confidential Information").
    | You shall not disclose such Confidential Information and shall 
    | use it only in accordance with the terms of the license agreement
    | you entered with ProfitCode IT Solutions.
 +--
 */
package br.com.ecommerce.ms.account.published;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * @author ProfitCode IT Solutions
 *
 * Published objects.
 *
 */
public class StatusResponse implements Serializable {

	private static final long serialVersionUID = -8892377914502297992L;
	
	private String message;
	private HttpStatus http;
	
	public StatusResponse (String message, HttpStatus http) {
		this.message = message;
		this.http = http;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttp() {
		return http;
	}

	public void setHttp(HttpStatus http) {
		this.http = http;
	}
}
