package com.scg.employee.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.scg.employee.audit.AuditListener;
import com.scg.employee.audit.Auditable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EntityListeners(AuditListener.class)
@Entity
@Table(name = "department")
public class Department implements Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "department")
	private List<Employee> employeeList;

	@Embedded
	private Audit audit;

}
