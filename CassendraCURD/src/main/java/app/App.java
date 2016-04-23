package app;

import com.skc.dao.employee.EmployeeDao;

public class App {
	public static void main(
			String[] args) {/*
							 * Cluster cluster =
							 * Cluster.builder().addContactPoint("127.0.0.1").
							 * build();
							 * 
							 * Session session = cluster.connect();
							 * 
							 * String cqlStatement =
							 * "CREATE KEYSPACE myfirstcassandradb WITH " +
							 * "replication = {'class':'SimpleStrategy','replication_factor':1}"
							 * ;
							 * 
							 * String cqlStatement2 =
							 * "CREATE TABLE myfirstcassandradb.users (" +
							 * " user_name varchar PRIMARY KEY," +
							 * " password varchar " + ");";
							 * session.execute(cqlStatement2);
							 * 
							 * System.out.println("Done-------->");
							 * 
							 */

		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.createEmployee(7, "sitakant", "chaudhury");
		employeeDao.retrieveEmployee();
		employeeDao.updateEmployee("skc", 5);
		employeeDao.retrieveEmployee();
		employeeDao.deleteEmployee(5);
		employeeDao.retrieveEmployee();

	}
}
