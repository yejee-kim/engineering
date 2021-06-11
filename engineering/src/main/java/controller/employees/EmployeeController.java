package controller.employees;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.EmployeeCommand;
import service.EmployeeNoService;
import service.EmployeeService;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmployeeNoService employeeNoService;
	@Autowired
	EmployeeNoService employeeListService;
	
	@RequestMapping("empList")
	public String empList(Model model) {
	    employeeListService.empList.empList(model);
		return "employee/empList";
	}
	@RequestMapping("empReget")
	public String empReset(Model model) {
		employeeNoService.getEmpNo(model);
		return "employee/employeeForm";
	}
	@RequestMapping(value="empJoin", method=RequestMethod.POST)
	public String empJoin(EmployeeCommand employeeCommand) {
		employeeService.insertemp(employeeCommand);
		return "redirect:empList";
	}
}
