package controller.employees;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@RequestMapping("empList")
	public String empList() {
		return "employee/empList";
	}
}
