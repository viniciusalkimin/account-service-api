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

/**
 * @author ProfitCode IT Solutions
 *
 * Published objects.
 *
 */
public class APIGenericResponse implements Serializable {

	private static final long serialVersionUID = 1503764240637501124L;
	
	private Object result;
	private StatusResponse status;

	public APIGenericResponse (Object result, StatusResponse status) {
		this.result = result;
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public StatusResponse getStatus() {
		return status;
	}

	public void setStatus(StatusResponse status) {
		this.status = status;
	}
	
}
