package com.lec.spring.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity(name = "users")  // javax.persistence.Entity  (name= 실제로 생성될 테이블명)
public class User {
	@Id  // PK. javax.persistence.Id
	@GeneratedValue  // AI,
	private Long id;
	
	
	@NonNull   // lombok.NonNull   ← import 주의!
	private String name;
	@NonNull
	private String email;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
}
