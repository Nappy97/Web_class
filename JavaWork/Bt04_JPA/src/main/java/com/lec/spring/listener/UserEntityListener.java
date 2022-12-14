package com.lec.spring.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.lec.spring.domain.User;
import com.lec.spring.domain.UserHistory;
import com.lec.spring.repository.UserHistoryRepository;
import com.lec.spring.support.BeanUtils;

//@Component  // <-- Listener 에선 스프링 빈 주입불가
public class UserEntityListener {

//	@Autowired   // <-- Listener 에선 스프링 빈 주입불가
//	private UserHistoryRepository userHistoryRepository;
	
//	@PrePersist   // User 가 INSERT 수행하기 전
//	@PreUpdate    // User 가 UPDATE 수행하기 전
	@PostUpdate
	@PostPersist	// DB 에 User 가 저장된 후 UserHistory 를 저장
	public void postUpdateAndPosetPersist(Object o) {  // <-- User Entity  를 매개변수 받음
		System.out.println(">> UserEntityListener#postUpdateAndPosetPersist()");
		
		// Listener 에서 스프링 빈 주입받기
		UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
		
		User user = (User)o;
		UserHistory userHistory = new UserHistory();
//		userHistory.setUserId(user.getId());
		userHistory.setName(user.getName());
		userHistory.setEmail(user.getEmail());
		userHistory.setUser(user);
		
		// userHistoryRepository 가 null 이다!
		// Entity Listener 는 Spring Bean 을 주입받지 못한다 !!!
		userHistoryRepository.save(userHistory);  // INSERT
	}
	
}
