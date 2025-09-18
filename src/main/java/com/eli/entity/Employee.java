package com.eli.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="employee_details")
@Component
@Scope(value = "prototype")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String name;
	@Column(unique = true)
	private long phoneNumber;
	private String password;
	
	@OneToMany
	private List<Attendence> attendences;

}
