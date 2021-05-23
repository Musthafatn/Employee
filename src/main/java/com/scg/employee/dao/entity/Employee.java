package com.scg.employee.dao.entity;

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

@Getter
@Entity
@Table(name = "employee")
@EntityListeners(AuditListener.class)
public class Employee implements Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Setter
	@Column(name = "name")
	private String name;

	@Setter
	@Column(name = "age")
	private int age;

	@Setter
	@Column(name = "salary")
	private int salary;

	@Setter
	@Column(name = "dept_id")
	private int deptId;

	@Setter
	@ManyToOne
	@JoinColumn(name = "dept_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Department department;

	@Setter
	@Embedded
	private Audit audit;

}
