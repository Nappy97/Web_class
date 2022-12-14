package com.lec.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.lec.spring.listener.Auditable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
//@EntityListeners(value = AuditingEntityListener.class)
public class UserHistory extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name = "user_id", insertable = false, updatable = false)
	private Long userId;
	private String name;
	private String email;
	
	@ManyToOne
//	@ToString.Exclude
	private User user;
	
//	@Column(updatable = false)
//	@CreatedDate   // AuditingEntityListener 가 Listener 로 적용시 사용
//	private LocalDateTime createdAt;
//	
//	@LastModifiedDate  // AuditingEntityListener 가 Listener 로 적용시 사용s
//	private LocalDateTime updatedAt;
	
	
}






