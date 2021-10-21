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
package br.com.ecommerce.ms.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ProfitCode IT Solutions
 *
 */
@Entity
@Table(name = "Users", schema="wisales_service_schema")
public class User extends BaseEntity<Long> {

	private static final long serialVersionUID = -2096127641665459704L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUser", nullable=false, unique=true, insertable=true, updatable=true )
	private Long id;
	
	@Column(name="name",  length=250, nullable=false, unique=false)
	private String name;
	
	@Column(name="email", length=250, nullable=false, unique=false)
	private String email;

	public User() {		
	}
	
	public User(Long id, String name, String email) {	
		
		super();
		this.id = id;			
		this.name = name;
		this.email = email;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}