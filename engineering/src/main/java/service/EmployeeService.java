package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.EmployeeCommand;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	EmployeeRepository employeeRepository;
	public void insertemp(EmployeeCommand EmployeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
	    dto.setEmpDeptNumber(EmployeeCommand.getEmpDeptNumber());
		dto.setEmpEmail(EmployeeCommand.getEmpEmail());
		dto.setEmpId(EmployeeCommand.getEmpId());
		dto.setEmpName(EmployeeCommand.getEmpName());
		dto.setEmpNo(EmployeeCommand.getEmpNo());
		dto.setEmpPhoneNumber(EmployeeCommand.getEmpPhoneNumber());
		dto.setEmpPw(bcryptPasswordEncoder.encode(
				EmployeeCommand.getEmpPw()));
		dto.setHireDate(EmployeeCommand.getHireDate());
		dto.setSalary(EmployeeCommand.getSalary());
		employeeRepository.insertEmployee(dto);
	}
}
