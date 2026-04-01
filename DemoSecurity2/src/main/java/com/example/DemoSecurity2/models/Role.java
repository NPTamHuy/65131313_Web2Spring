package com.example.DemoSecurity2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String name;  // Ví dụ: ROLE_USER, ROLE_ADMIN
//getter, setter, contrstructor
}