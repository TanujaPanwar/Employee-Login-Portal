package com.eli.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
@Scope(value ="prototype")
public class Attendence {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY,generator="attendence_id_generator")
	@SequenceGenerator(name="attendence_id_generator",initialValue = 1001,allocationSize =1)
	private int attendenceId;
	@CreationTimestamp //current system time
	private LocalDateTime loginTime;
	private LocalDateTime logoutTime;
	

}
