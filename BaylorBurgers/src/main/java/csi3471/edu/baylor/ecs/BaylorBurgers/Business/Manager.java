package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Manager {
	
	protected String username;
	protected String password;	
	
	
	public Manager(String uName, String pWord) {
		username = uName;
		password = pWord;
	}
	
	public String getUsername() {
		return username;
	}
	
	@Override
	public String toString() {
		return "" + hashCode();
	}

	@Override
	public int hashCode() {
		final int prime = 61;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

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
