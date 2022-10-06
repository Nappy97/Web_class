package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.spring.domain.Authority;
import com.lec.spring.domain.User;
import com.lec.spring.repository.AuthorityRepository;
import com.lec.spring.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private AuthorityRepository authorityRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setAuthorityRepository(AuthorityRepository authorityRepository) {
		this.authorityRepository = authorityRepository;
	}

	public UserService() {
		System.out.println(getClass().getName() + "() 생성");
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	// 특정 id 의 User 의 Authority (들)을 리턴
	public List<Authority> selectAuthoritiesById(Long id) {

		User user = userRepository.findById(id).orElse(null);
		
		if (user != null) {
			return user.getAuthorities();
		}

		return new ArrayList<>();
	}
}
