package csi3471.edu.baylor.ecs.BaylorBurgers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileWriter;
import java.io.IOException;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Manager;

public class ManagerTest {
	
	@Test
	public void testInitialize() {
		Manager m = new Manager("user", "pass");
		assertNotEquals(m, null);
	}
	@Test
	public void testEquals() {
		Manager m = new Manager("user1", "pass1");
		Manager m1 = new Manager("user1", "pass1");
		assertEquals(m, m1 , "Supposed to equal");
	}
	
	@Test
	public void testHashCode() {
		Manager m = new Manager("user2", "pass2");
		Manager m1 = new Manager("user2", "pass2");
		assertTrue(m.toString() != m1.toString());
	}
	
	@Test
	public void testManagerExists() {
		Manager m = new Manager("user4", "pass4");
		Manager m1 = new Manager("user5", "pass5");
		String filename = "./target/managers.txt";
		String managerString = m.toString() + "\n";
		FileWriter fWriter;
		try {
			fWriter = new FileWriter(filename, true);
			fWriter.write(managerString);
			fWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		assertTrue(m.managerExists() && !m1.managerExists());
	}

}
