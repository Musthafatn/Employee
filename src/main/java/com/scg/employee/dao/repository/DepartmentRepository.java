package com.scg.employee.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scg.employee.dao.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	List<Department> findByName(String name);

}
