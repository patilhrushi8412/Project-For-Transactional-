package com.te.springBootTransaction.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.te.springBootTransaction.dto.Employeedto;
import com.te.springBootTransaction.entity.Department;
import com.te.springBootTransaction.entity.Employee;
import com.te.springBootTransaction.repo.DepartmentRepo;
import com.te.springBootTransaction.repo.EmployeeRepo;

@Service
public class ServiceImpl implements Services {

	@Autowired
	private EmployeeRepo emprepo;

	@Autowired
	private DepartmentRepo deptepo;

	@Override @Transactional	
	public Employee addEmployee(Employeedto dto) {

		Department dept = new Department();
		dept.setDepartmentName(dto.getDepartmentName());
		dept.setDepartmentcode(dto.getDepartmentName()+"01");
		long deptId = deptepo.save(dept).getDeptid();
		
		Employee emp=new Employee();
		emp.setEmployeeName(dto.getEmployeeName());
		emp.setEmail(dto.getEmail());
		emp.setDepartmentId(deptId);
		Employee save = emprepo.save(emp);
		return save;
	}
	
	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> findById = emprepo.findById(id);
		return findById.get();
	}
	
	@Scheduled(fixedRate = 4000)
	public List<Employee> getall() {
		List<Employee> findAll = emprepo.findAll();
		System.out.println(findAll);
		return findAll;
	}

}
