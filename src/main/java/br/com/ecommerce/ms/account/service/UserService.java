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
package br.com.ecommerce.ms.account.service;

import java.util.List;
import java.util.Optional;

import br.com.ecommerce.ms.account.entity.User;

/**
 * @author ProfitCode IT Solutions
 * 
 * Service interface to User.
 *
 */
public interface UserService {
	
	/**
	 * Create new user.
	 * 
	 * @param User
	 * @return User if created.
	 */
	public User create (User user) throws Exception;
	
	/**
	 * Get user.
	 * 
	 * @param id
	 * @return User if found.
	 */
	public Optional<User> read (Long id) throws Exception;
	
	/**
	 * Update user.
	 * 
	 * @param id
	 * @param details
	 * @return User if found.
	 */
	public User update (Long id, User detail) throws Exception;
	
	/**
	 * Delete user.
	 * 
	 * @param id
	 * @return True if deleted.
	 */
	public boolean delete (Long id) throws Exception;
	
	/**
	 * Create new user.
	 * 
	 * @param User
	 * @return User if created.
	 */
	public List<User> list () throws Exception;
}

