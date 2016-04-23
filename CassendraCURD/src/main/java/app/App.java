package app;

import com.skc.dao.employee.EmployeeDao;

public class App {
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.createEmployee(7, "sitakant", "chaudhury");
		employeeDao.retrieveEmployee();
		employeeDao.updateEmployee("skc", 5);
		employeeDao.retrieveEmployee();
		employeeDao.deleteEmployee(5);
		employeeDao.retrieveEmployee();
	}
}
