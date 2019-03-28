package com.ktslogis.service;

import com.ktslogis.entity.User;
import com.ktslogis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		User user = repository.findByUsername(username);
		
		if(null == user) {
			throw new UsernameNotFoundException(username);
		}
		
		
//		return new org.springframework.security.core.userdetails.User(
//				user.getUsername(),
//				user.getPassword(),
//				null
//				);
		
		return new UserDetailsImpl(user);
	}

}
