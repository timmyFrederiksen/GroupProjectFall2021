package csi3471.edu.baylor.ecs.BaylorBurgers;

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
}
