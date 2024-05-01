package springs_hibernate_anno_bean.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springs_hibernate_anno_bean.dao.EmployeeDao;
import springs_hibernate_anno_bean.dao.OneToOneConfig;
import springs_hibernate_anno_bean.dto.Employee;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(OneToOneConfig.class);
		Employee employee = (Employee) context.getBean("employee");
		EmployeeDao dao = (EmployeeDao) context.getBean("employeeDao");
//		dao.saveEmployee(employee);
//		dao.getEmployee(2);
//		dao.deleteEmployee(1);
//		dao.updateEmployee(1, employee);
		List<Employee>list = dao.getAllEmployee();
		for (Employee employee2 : list) {
			System.out.println(employee2);
		}
	}
}
