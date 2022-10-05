package com.lec.spring.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
@Entity(name = "users")  // javax.persistence.Entity
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
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Address> addres;
	
}
