package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class holds manager or employee's username and password for the system.
 */
public class Manager {
	
	protected String username;
	protected String password;	
	
	/**
	 * Constructs a Manager object
	 * @param uName The employee's username
	 * @param pWord The employee's password
	 */
	public Manager(String uName, String pWord) {
		username = uName;
		password = pWord;
	}
	
	/**
	 * Getter for username
	 * @return Username of employee
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Converts the employee's information into a String.
	 * @return String equivalent of the employee
	 */
	@Override
	public String toString() {
		return "" + hashCode();
	}

	/**
	 * Hashes the employee information.
	 * @return Hashed employee
	 */
	@Override
	public int hashCode() {
		final int prime = 61;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/**
	 * Determines if 2 employees are the same.
	 * @param obj Employee to compare to 'this'
	 * @return True if the employees are the same
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	/**
	 * Determines if the manager exists in the system.
	 * @return True if the manager/employee exists
	 */
	public Boolean managerExists() {

		Boolean isInFile = false;
		String filename = "./target/resources/managers.txt";
		String managerString = this.toString();
		Scanner scanner = null;
		String checkStr = null;
		
		try {
			scanner = new Scanner(new File(filename));
			while (scanner.hasNextLine()) {
				checkStr = scanner.nextLine();
				
				if (checkStr.equals(managerString)) {
					isInFile = true;
				}
			}
		} catch (FileNotFoundException e) {
			// File not found
			e.printStackTrace();
		}
		
		return isInFile;
	}
}
