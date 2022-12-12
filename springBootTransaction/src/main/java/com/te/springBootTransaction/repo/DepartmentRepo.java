package com.te.springBootTransaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springBootTransaction.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
