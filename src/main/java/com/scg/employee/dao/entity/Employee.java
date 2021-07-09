package com.scg.employee.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.scg.employee.audit.AuditListener;
import com.scg.employee.audit.Auditable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name = "employee")
@EntityListeners(AuditListener.class)
public class Employee implements Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	@Column(name = "salary")
	private Integer salary;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "dept_id")
	private Department department;

	@Embedded
	private Audit audit;

}
