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
package br.com.ecommerce.ms.account.endpoint;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.ms.account.entity.User;
import br.com.ecommerce.ms.account.published.APIGenericResponse;
import br.com.ecommerce.ms.account.published.StatusResponse;
import br.com.ecommerce.ms.account.service.UserService;

/**
 * @author ProfitCode IT Solutions
 *
 * User Rest Web Service End Point.
 *
 */
@RestController
public class UserRestWsEndpoint {

	/**
	 * Set the logger factory. 
	 */
	static Logger logger = LoggerFactory.getLogger(UserRestWsEndpoint.class);	
	
	/**
	 * Set services. 
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * End points definitions. 
	 */	
	@RequestMapping(method = RequestMethod.POST, value = "/public/create/user", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> create (@RequestBody User user) { 
		
		try {

			return ResponseEntity.ok(new APIGenericResponse(userService.create(user), new StatusResponse("Request API is successfully", HttpStatus.CREATED)));
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(false, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/public/read/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> read (@PathVariable(value = "id") Long id) { 
		
		try {

			Optional<User> user = userService.read(id);
			
			if (user.isPresent()) {
				
				return ResponseEntity.ok(new APIGenericResponse(user.get(), new StatusResponse("Request API is successfully", HttpStatus.OK)));
			
			} else {
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(null, new StatusResponse("User not found.", HttpStatus.NOT_FOUND)));
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/public/update/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> update (@PathVariable(value = "id") Long id,  @Valid @RequestBody User detail) { 
		
		try {

			User user = userService.update(id, detail);
			
			if (user == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(user, new StatusResponse("User not found.", HttpStatus.NOT_FOUND)));
			}
			 
			return ResponseEntity.ok(new APIGenericResponse(user, new StatusResponse("Request API is successfully", HttpStatus.OK)));
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/public/delete/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> delete (@PathVariable(value = "id") Long id) { 
		
		try {

			Boolean deleted = userService.delete(id);
			
			if (deleted) {
				return ResponseEntity.ok(new APIGenericResponse(deleted, new StatusResponse("Request API is successfully", HttpStatus.OK)));
			}
			 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(deleted, new StatusResponse("User not found.", HttpStatus.NOT_FOUND)));
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
}
