package csi3471.edu.baylor.ecs.BaylorBurgers.Persistence;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.FoodDescription;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * This class handles menu database access and transactions.
 */
public class MenuDAO {
    private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CONNECTION = "jdbc:derby:menuconnect;create=true";
    private static final String DB_SHUT = "jdbc:derby:menuconnect;shutdown=true";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    private Statement statement;
    private Connection dbConnection;

    /**
     * Constructs a MenuDAO object.
     */
    public MenuDAO() {
    }
    
    /**
     * This function creates a table to hold Employee login credentials.
     * @throws SQLException
     */
    public void createEmployeeTable() throws SQLException {
        this.dbConnection = null;
        this.statement = null;
        String createTableSQL = "CREATE TABLE MENU(ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME VARCHAR(255) NOT NULL, CATEGORYNAME VARCHAR(255) NOT NULL, "
                + "PRICE DOUBLE NOT NULL, DESCRIPTION VARCHAR(255) NOT NULL)";

        try {
            this.dbConnection = getDBConnection();
            this.statement = this.dbConnection.createStatement();
            this.statement.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.language.sequence.preallocator', '1')");
            this.statement.execute(createTableSQL);
        } catch (SQLException var6) {
            System.out.println(var6.getMessage());
        } finally {
            if (this.statement != null) {
                this.statement.close();
            }

            if (this.dbConnection != null) {
                this.dbConnection.close();
            }

        }

    }
    /*
    public void createEmployeeTable() throws SQLException {
        this.dbConnection = null;
        this.statement = null;
        String createTableSQL = "CREATE TABLE EMPLOYEE(ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME VARCHAR(255) NOT NULL, "
        		+ "PRICE DOUBLE NOT NULL, DESCRIPTION VARCHAR(255) NOT NULL)";

        try {
            this.dbConnection = getDBConnection();
            this.statement = this.dbConnection.createStatement();
            this.statement.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.language.sequence.preallocator', '1')");
            System.out.println(createTableSQL);
            this.statement.execute(createTableSQL);
            System.out.println("Table \"employee\" is created!");
        } catch (SQLException var6) {
            System.out.println(var6.getMessage());
        } finally {
            if (this.statement != null) {
                this.statement.close();
            }

            if (this.dbConnection != null) {
                this.dbConnection.close();
            }

        }

    }
	*/
    /**
     * This function accesses the database.
     * @return Returns a connection to the database.
     */
    public static Connection getDBConnection() {
        Connection dbConnection = null;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException var3) {
            System.out.println(var3.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection("jdbc:derby:menuconnect;create=true", "", "");
            return dbConnection;
        } catch (SQLException var2) {
            System.out.println(var2.getMessage());
            return dbConnection;
        }
    }

    /**
     * This function enters a new FoodDescription object into the database.
     * @param e The FoodDescription object to be entered into the database.
     * @throws SQLException
     */
    public void save(FoodDescription e) throws SQLException {
        this.dbConnection = null;
        this.statement = null;

        try {
            this.dbConnection = getDBConnection();
            this.statement = this.dbConnection.createStatement();
            
            if (e.getId() != null) {
                String query = "UPDATE MENU SET NAME = '" + e.getName() + "', CATEGORYNAME= '" + e.getCategory() + "', PRICE = " + e.getPrice() + ", DESCRIPTION = '" + e.getDetails() + "' WHERE ID = " + e.getId();
                this.statement.executeUpdate(query);
            } else {
    		
            this.statement.executeUpdate("INSERT INTO MENU(NAME, CATEGORYNAME, PRICE, DESCRIPTION) VALUES('" + e.getName() + "', '" + e.getCategory() + "', " + e.getPrice() + ", '" + e.getDetails() +  "')");
            }
        } catch (SQLException var6) {
            System.out.println(var6.getMessage() + "\n" + var6.getCause().getMessage());
            System.out.println("Did not succeed: save");
        } finally {
            if (this.statement != null) {
                this.statement.close();
            }

            if (this.dbConnection != null) {
                this.dbConnection.close();
            }

        }

    }
    /*
    public Employee findById(Long id) throws SQLException {
        this.dbConnection = null;
        this.statement = null;
        Employee e = new Employee();

        try {
            this.dbConnection = getDBConnection();
            this.statement = this.dbConnection.createStatement();
            String select = "SELECT ID, NAME, EMAIL, AGE, GENDER, SALARY FROM EMPLOYEE WHERE ID = " + id;
            ResultSet rs = this.statement.executeQuery(select);
            if (rs.next()) {
                e.setId(rs.getLong("ID"));
                e.setName(rs.getString("NAME"));
                e.setEmail(rs.getString("EMAIL"));
                e.setAge(rs.getInt("AGE"));
                e.setGender(rs.getString("GENDER"));
                e.setSalary(rs.getLong("SALARY"));
                System.out.println("Employee found in Employee table.");
            } else {
                System.out.println("Employee not found in Employee table.");
            }
        } catch (SQLException var8) {
            System.out.println(var8.getMessage());
            System.out.println("Did not succeed: findById");
        } finally {
            if (this.statement != null) {
                this.statement.close();
            }

            if (this.dbConnection != null) {
                this.dbConnection.close();
            }

        }

        return e;
    }
	*/
    
    /**
     * This function deletes a FoodDescription from the database.
     * @param name String containing the name of the FoodDescription.
     * @throws SQLException
     */
    public void delete(String name) throws SQLException {
        this.dbConnection = null;
        this.statement = null;

        try {
            this.dbConnection = getDBConnection();
            this.statement = this.dbConnection.createStatement();
            this.statement.executeUpdate("DELETE FROM MENU WHERE NAME = '" + name +"'");
        } catch (SQLException var6) {
            System.out.println(var6.getMessage());
            System.out.println("Did not succeed: delete");
        } finally {
            if (this.statement != null) {
                this.statement.close();
            }

            if (this.dbConnection != null) {
                this.dbConnection.close();
            }

        }

    }
    
    /**
     * This function accesses the database to get all FoodDescriptions that
     * are currently in the database.
     * @return A vector of all FoodDescriptions currently in the database.
     * @throws SQLException
     */
    public Vector<FoodDescription> findAll() throws SQLException {
        this.dbConnection = null;
        this.statement = null;
        Vector<FoodDescription> descriptions = new Vector<FoodDescription>();

        try {
            this.dbConnection = getDBConnection();
            this.statement = this.dbConnection.createStatement();
            ResultSet rs = this.statement.executeQuery("SELECT ID, NAME, CATEGORYNAME, PRICE, DESCRIPTION FROM MENU");

            while(rs.next()) {
                FoodDescription e = new FoodDescription(rs.getString("NAME"), rs.getString("CATEGORYNAME"), rs.getDouble("PRICE"), rs.getString("DESCRIPTION"));
                e.setId(rs.getLong("ID"));
                descriptions.add(e);
            }

        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
            System.out.println("Did not succeed: findAll");
        } finally {
            if (this.statement != null) {
                this.statement.close();
            }

            if (this.dbConnection != null) {
                this.dbConnection.close();
            }

        }

        return descriptions;
    }
    /*
    public int count() throws SQLException {
        int count = 0;
        this.dbConnection = null;
        this.statement = null;

        try {
            this.dbConnection = getDBConnection();
            this.statement = this.dbConnection.createStatement();
            System.out.println("Employee count executed.");
            ResultSet numberOfElements = this.statement.executeQuery("SELECT * FROM EMPLOYEE");
            if (numberOfElements != null) {
                while(numberOfElements.next()) {
                    ++count;
                }
            }

            int var4 = count;
            return var4;
        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
            System.out.println("Did not succeed: count");
        } finally {
            if (this.statement != null) {
                this.statement.close();
            }

            if (this.dbConnection != null) {
                this.dbConnection.close();
            }

        }

        return 0;
    }
	*/
    //"Drinks or Food"
    /**
     * This function accesses the database to find all FoodDescription objects
     * that matches the provided category.
     * @param query The category of FoodDescription to be accessed
     * @return A vector of all FoodDescription items that match the category.
     * @throws SQLException
     */
    public Vector<FoodDescription> find(String query) throws SQLException {
        this.dbConnection = null;
        this.statement = null;
        Vector<FoodDescription> descriptions = new Vector<FoodDescription>();

        try {
            this.dbConnection = getDBConnection();
            this.statement = this.dbConnection.createStatement();
            ResultSet rs = this.statement.executeQuery("SELECT ID, NAME, CATEGORYNAME, PRICE, DESCRIPTION FROM MENU WHERE CATEGORYNAME = '" +query+"'");

            while(rs.next()) {
                FoodDescription e = new FoodDescription(rs.getString("NAME"), rs.getString("CATEGORYNAME"), rs.getDouble("PRICE"), rs.getString("DESCRIPTION"));
                e.setId(rs.getLong("ID"));
                descriptions.add(e);
            }

        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
            System.out.println("Did not succeed: findAll");
        } finally {
            if (this.statement != null) {
                this.statement.close();
            }

            if (this.dbConnection != null) {
                this.dbConnection.close();
            }

        }

        return descriptions;
    }
	
    /*
    public static void main(String[] args) throws SQLException {
        EmployeeDTO gateway = new EmployeeDTO();
        gateway.createEmployeeTable();
        //gateway.save(new Employee("foo", "foo@foo.com", 3, "MALE", 10000L));
        //System.out.println(gateway.findAll());

        try {
            DriverManager.getConnection("jdbc:derby:employee;shutdown=true");
        } catch (SQLException var3) {
        }

    }

     */
}