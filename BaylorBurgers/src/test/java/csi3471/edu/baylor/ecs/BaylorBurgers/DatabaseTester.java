package csi3471.edu.baylor.ecs.BaylorBurgers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.FoodDescription;
import csi3471.edu.baylor.ecs.BaylorBurgers.Persistence.MenuDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseTester {
    private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CONNECTION = "jdbc:derby:menuconnect;create=true";
    private static final String DB_SHUT = "jdbc:derby:menuconnect;shutdown=true";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    private Statement statement;
    private Connection dbConnection;
    private FoodDescription fd1;
    private FoodDescription fd2;
    private FoodDescription fd3;
    private FoodDescription fd4;
    private FoodDescription fd5;

    private MenuDAO menuDB;

    public DatabaseTester() {
    }

    @BeforeEach
    void setup() throws SQLException {
        this.menuDB = new MenuDAO();

        try {
            this.menuDB.createEmployeeTable();
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

        this.fd1 = new FoodDescription("Ham", "Food", 25.0, "100% Real Pig");
        //this.fd1.setId(1L);
        this.fd2 = new FoodDescription("Turkey w/ Rice", "Food", 22.0, "Healthy & Delicious");
        //this.fd2.setId(2L);
        this.fd3 = new FoodDescription("Water", "Drinks", 1.0, "Hydrate Alot");
        //this.fd3.setId(3L);
        this.fd4 = new FoodDescription("Pepsi", "Drinks", 17.0, "Not the Healthiest");
        //this.fd4.setId(4L);
        this.fd5 = new FoodDescription("Tea", "Drinks", 5.0, "Nutritionist");
        //this.fd5.setId(5L);
        this.dbConnection = null;
        this.statement = null;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.dbConnection = DriverManager.getConnection("jdbc:derby:menuconnect;create=true", "", "");
            this.statement = this.dbConnection.createStatement();
            System.out.println("Run");
            this.statement.executeUpdate("DELETE FROM MENU");
        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
        } catch (ClassNotFoundException var8) {
            System.out.println(var8.getMessage());
        } finally {
            if (this.statement != null) {
                this.statement.close();
            }

            if (this.dbConnection != null) {
                this.dbConnection.close();
            }

        }

    }

    @AfterEach
    void takeDown() throws SQLException {
        try {
            DriverManager.getConnection("jdbc:derby:menuconnect;shutdown=true");
        } catch (SQLException var2) {
        }

    }
    
    @Test
    void savePositive() {
        try {
            this.menuDB.save(this.fd1);
            List<FoodDescription> fds = (List)this.menuDB.findAll().stream().collect(Collectors.toList());
            Assertions.assertEquals(1, fds.size());
            FoodDescription e1 = (FoodDescription)fds.get(0);
            Assertions.assertEquals(e1.getName(), fd1.getName());
            Assertions.assertEquals(e1.getCategory(), fd1.getCategory());
            Assertions.assertEquals(e1.getPrice(), fd1.getPrice());
            Assertions.assertEquals(e1.getDetails(), fd1.getDetails());
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }
    
    @Test
    void saveNegative() {
        try {
            this.menuDB.save(this.fd1);
            List<FoodDescription> fds = (List)this.menuDB.findAll().stream().collect(Collectors.toList());
            Assertions.assertEquals(1, fds.size());
            FoodDescription e1 = (FoodDescription)fds.get(0);
            Assertions.assertNotEquals(e1.getName(), fd2.getName());
            Assertions.assertEquals(e1.getCategory(), fd1.getCategory());
            Assertions.assertEquals(e1.getPrice(), fd1.getPrice());
            Assertions.assertEquals(e1.getDetails(), fd1.getDetails());
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
    }
    
    @Test
    void deletePositive() {
        try {
            this.menuDB.save(this.fd1);
            FoodDescription e1 = (FoodDescription)this.menuDB.findAll().get(0);
            this.menuDB.delete(e1.getName());
            Assertions.assertTrue(this.menuDB.findAll().size() == 0);
        } catch (SQLException var2) {
            var2.printStackTrace();
        }
    }

    @Test
    void deleteNegative() {
        try {
            this.menuDB.save(this.fd1);
            FoodDescription e1 = (FoodDescription)this.menuDB.findAll().get(0);
            this.menuDB.delete(fd2.getName());
            Assertions.assertTrue(this.menuDB.findAll().size() == 1);
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

    }

    @Test
    void findPositive() {
        
        try {
            this.menuDB.save(this.fd1);
            this.menuDB.save(this.fd2);
            this.menuDB.save(this.fd3);
            this.menuDB.save(this.fd4);
            this.menuDB.save(this.fd5);
            List<FoodDescription> dbItems = this.menuDB.find("Drinks").stream().collect(Collectors.toList());
            
            List<FoodDescription> orgItems = new ArrayList<>();
            orgItems.add(fd1);
            orgItems.add(fd2);
            orgItems.add(fd3);
            orgItems.add(fd4);
            orgItems.add(fd5);
            
            orgItems = orgItems.stream().filter(s -> s.getCategory() == "Drinks").collect(Collectors.toList());
            

            Boolean flag = true;
            if(dbItems.size() != orgItems.size()) { flag = false;}
            for(int i = 0; i < orgItems.size() && flag == true; i++){
            	if(!orgItems.get(i).equals(dbItems.get(i))) {
            		flag = false;
            	}
            }

            Assertions.assertTrue(flag);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }
    @Test
    void findNegative() {
        
        try {
            this.menuDB.save(this.fd1);
            this.menuDB.save(this.fd2);
            this.menuDB.save(this.fd3);
            this.menuDB.save(this.fd4);
            this.menuDB.save(this.fd5);
            List<FoodDescription> dbItems = this.menuDB.find("Food").stream().collect(Collectors.toList());
            
            List<FoodDescription> orgItems = new ArrayList<>();
            orgItems.add(fd1);
            orgItems.add(fd2);
            orgItems.add(fd3);
            orgItems.add(fd4);
            orgItems.add(fd5);
                        

            Boolean flag = true;
            if(dbItems.size() != orgItems.size()) { flag = false;}
            for(int i = 0; i < orgItems.size() && flag == true; i++){
            	if(!orgItems.get(i).equals(dbItems.get(i))) {
            		flag = false;
            	}
            }

            Assertions.assertFalse(flag);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }
    @Test
    void findAllNegative() {
    	try {
            this.menuDB.save(this.fd1);
            this.menuDB.save(this.fd2);
            this.menuDB.save(this.fd3);
            Vector<FoodDescription> dbItems = this.menuDB.findAll();
            
            Vector<FoodDescription> orgItems = new Vector<FoodDescription>();
            fd1.setId(1L);
            fd1.setId(2L);
            orgItems.add(fd1);
            orgItems.add(fd2);

            Boolean flag = true;
            if(dbItems.size() != orgItems.size()) { flag = false;}
            for(int i = 0; i < orgItems.size() && flag == true; i++){
            	if(!orgItems.elementAt(i).equals(dbItems.elementAt(i))) {
            		flag = false;
            	}
            }

            Assertions.assertFalse(flag);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }
    @Test
    void findAll() {
    	try {
            this.menuDB.save(this.fd1);
            this.menuDB.save(this.fd2);
            this.menuDB.save(this.fd3);
            Vector<FoodDescription> dbItems = this.menuDB.findAll();
            
            Vector<FoodDescription> orgItems = new Vector<FoodDescription>();
            fd1.setId(1L);
            fd1.setId(2L);
            orgItems.add(fd1);
            orgItems.add(fd2);

            Boolean flag = true;
            if(dbItems.size() != orgItems.size()) { flag = false;}
            for(int i = 0; i < orgItems.size() && flag == true; i++){
            	if(!orgItems.elementAt(i).equals(dbItems.elementAt(i))) {
            		flag = false;
            	}
            }

            Assertions.assertFalse(flag);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }
    
}
