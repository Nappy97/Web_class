package com.lec.spring.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
// 이 객체가 JPA 에서 관리하는 Entity 객체임을 정의
@Entity(name = "users") // javax.persistence.Entity (name = 실제로 저장되는 테이블 이름)
//@Table(name = "users" // 이 이름으로 물리적인 테이블 생성
//		, indexes = { @Index(columnList = "name") } // 컬럼에 대한 index생성
//		, uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) } // unique 제약사항
//)
@EntityListeners(value = MyEntityListener.class)
public class User {
	@Id // PK. javax.persistence.Id Entity 는 pk가 반드시 필요없다.
	@GeneratedValue // AI,
	private Long id;

	@NonNull // lombok.NonNull ← import 주의!
	private String name;

	@NonNull
	@Column(unique = true)
	private String email;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", insertable = false, updatable = false) // Entity 가 어떤 컬럼으로 join 하게 될지 지정해준다.
	@ToString.Exclude
	private List<UserHistory> userHistories = new ArrayList<>(); // Nullpoint Excep 방지

	@OneToMany
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private List<Review> reviews = new ArrayList<>();
	
	
//	@Column(updatable = false)
	private LocalDateTime createdAt;

//	@Column(insertable = false)
	private LocalDateTime updatedAt;

//	@OneToMany(fetch = FetchType.EAGER)
//	private List<Address> address;
//
//	@Transient	// DB에 반영안하는 필드
//	private String testData;

	@Enumerated(value = EnumType.STRING)
	private Gender gender; // Enum 타입빌드

	@PrePersist
	public void prePersist() {
		System.out.println(">>> prePersist");
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		System.out.println(">>> preUpdate");
		this.updatedAt = LocalDateTime.now();
	}

//	@PreRemove
//	public void preRemove() {
//		System.out.println(">>> preRemove");
//	}
//
//	@PostPersist
//	public void postPersist() {
//		System.out.println(">>> postPersist");
//	}
//
//	@PostUpdate
//	public void postUpdate() {
//		System.out.println(">>> postUpdate");
//	}
//
//	@PostRemove
//	public void postRemove() {
//		System.out.println(">>> postRemove");
//	}
//
//	@PostLoad
//	public void postLoad() {
//		System.out.println(">>> postLoad");
//	}

}
