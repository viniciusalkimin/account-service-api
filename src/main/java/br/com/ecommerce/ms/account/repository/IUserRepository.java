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
package br.com.ecommerce.ms.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.ms.account.entity.User;

/**
 * @author ProfitCode IT Solutions
 * 
 * Define the data repository for user operations.
 *
 */
public interface IUserRepository extends JpaRepository<User, Long> {
	
	/**
	 * Find user by identification.
	 * 
	 * @param The identification of user found.
	 * @return User if found.
	 */
	public Optional<User> findById (Long id);

}
