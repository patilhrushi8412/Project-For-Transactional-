package com.te.springBootTransaction.services;

import com.te.springBootTransaction.dto.Employeedto;
import com.te.springBootTransaction.entity.Employee;

public interface Services {

	Employee addEmployee(Employeedto dto);

	Employee getEmployee(int id);

}
