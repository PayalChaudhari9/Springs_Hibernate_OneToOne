package springs_hibernate_anno_bean.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring_hibernate_xml.dto.Person;
import springs_hibernate_anno_bean.dto.Employee;

@Component
public class EmployeeDao {

	@Autowired
	private EntityManager manager;
	
	public void saveEmployee(Employee e) {
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(e);
		transaction.commit();
	}
	
	public void getEmployee(int id) {
		Employee employee = manager.find(Employee.class, id);
		if(employee!=null) {
			System.out.println(employee);
		}else {
			System.out.println("No employee found with given id!");
		}
	}
	
	public void deleteEmployee(int id) {
		EntityTransaction transaction = manager.getTransaction();
		Employee employee = manager.find(Employee.class, id);
		
		transaction.begin();
		if(employee!=null) {
			manager.remove(employee);
			System.out.println("Employee deleted successfully!!!");
		}
		else {
			System.out.println("Employee Not found!!");
		}
		transaction.commit();
	}
	
	public void updateEmployee(int id,Employee employee) {

		EntityTransaction transaction = manager.getTransaction();
		Employee employee2 = manager.find(Employee.class, id);
		
		if(employee2!=null) {
		    employee2.setId(id);
			employee.setAccount(employee.getAccount());
			
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
		}
	}
	
	public List<Employee> getAllEmployee()
	{	
		Query query = manager.createQuery("Select e From Employee e ");
		
		List<Employee> list= query.getResultList();
		
		return list;
	
	}
}
