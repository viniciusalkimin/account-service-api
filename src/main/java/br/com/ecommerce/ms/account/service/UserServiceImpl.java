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

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.ecommerce.ms.account.entity.User;
import br.com.ecommerce.ms.account.repository.IUserRepository;

/**
 * @author ProfitCode IT Solutions
 * 
 * Implements business rules of the user.
 *
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) 
public class UserServiceImpl implements UserService {

	/**
	 * Set the logger factory. 
	 */
	static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/**
	 * Set data repositories.
	 */
	@Autowired
	private IUserRepository iUserRepository;
	
	/**
	 * Create new user.
	 * 
	 * @param User
	 * @return Authentication token if created.
	 */
	@Override
	public User create (User user) throws Exception {
		
		logger.info("Creating a new user.");
		
		try {
			
			return iUserRepository.save(user);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	/**
	 * Get user.
	 * 
	 * @param id
	 * @return User if found.
	 */
	@Override
	public Optional<User> read (Long id) throws Exception {
		
		logger.info("Reading user by identification.");
		
		try {
			
			return iUserRepository.findById(id);			
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	/**
	 * Update user.
	 * 
	 * @param id
	 * @param details
	 * @return User if found.
	 */
	@Override
	public User update (Long id, User detail) throws Exception {
		
		logger.info("Updating user by identification and user details.");
		
		try {
			
			Optional<User> user = iUserRepository.findById(id);
			
			if (user.isPresent()) {				
				return iUserRepository.save(new User(id, detail.getName(), detail.getEmail()));
			} 
			
			return null;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Delete user.
	 * 
	 * @param id
	 * @return True if deleted.
	 */
	@Override
	public boolean delete (Long id) throws Exception {
		
		logger.info("Deleting user by identification.");
		
		try {
			
			Optional<User> user = iUserRepository.findById(id);
			
			if (user.isPresent()) {				
				iUserRepository.deleteById(id);
				return true;
			} 
			
			return false;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
