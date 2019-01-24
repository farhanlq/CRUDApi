package in.farhanlaeeq.springboot.springbootcrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.farhanlaeeq.springboot.springbootcrudapi.model.Employee;
import in.farhanlaeeq.springboot.springbootcrudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}

	@GetMapping("/employee")
	public List<Employee> get() {
		return employeeService.get();
	}

	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		Employee empObj = employeeService.get(id);
		if (empObj == null) {
			throw new RuntimeException("Employee Not Found for the Id:" + id);
		}
		return empObj;
	}

	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}

	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		employeeService.delete(id);
		return "Employee with id " + id + " has been deleted successfully!!";

	}
}
