package com.greatlearning.springbootEmployeeManagementDesign.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.greatlearning.springbootEmployeeManagementDesign.service.UserService;
import com.greatlearning.springbootEmployeeManagementDesign.config.MyUserDetails;
import com.greatlearning.springbootEmployeeManagementDesign.entity.User;
import com.greatlearning.springbootEmployeeManagementDesign.repository.UserRepository;
public class UserDetailsServiceImpl implements UserDetailsService {

	   @Autowired
	    private UserRepository userRepository;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	        User user = userRepository.getUserByUsername(username);
	         
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	         
	        return new MyUserDetails(user);
	    }

}
