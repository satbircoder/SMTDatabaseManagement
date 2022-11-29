package smtdatabasemanagement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerOperationManagement {
    public static void inserRecord(){// method to insert record in the database and using execute update method from 
        //customerinfoutil class
        try{
            System.out.println("Enter Customer Name to add");
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            System.out.println("Enter the customer email address");
            String email = sc.next();
            System.out.println("Enter Customer's Phone Number");
            String number = sc.next();
            if(name != null && email !=null && number != null){
                String insertRecord = String.format("INSERT INTO Customer(Customer_Name,Email_Address,Phone_Number) VALUES"
                        + "('%s','%s','%s')",name, email, number);
                int count = CustomerInfoUtil.executeUpdate(insertRecord);
                if(count == 0){
                    System.out.println("Failed to Add record");
                }
                else{
                    System.out.println("New Record has been added successfully");
                }
            }
            else{
                System.out.println("All fields are mandatory to add in database");
            }
        }
        catch(InputMismatchException ex){
                    System.out.println("Invalid input Please Try Again: "+ex.getMessage());
                    }
    }
    
    public static void deleteRecord(){// method to delete the records from database and also using execute update method
        System.out.println("Enter the customer ID to delete the record");
        Scanner sc = new Scanner(System.in);
        try{
            int id = sc.nextInt();
            String deleteRecord = "DELETE FROM Customer WHERE Customer_ID='"+id+"';";
            int count = CustomerInfoUtil.executeUpdate(deleteRecord);
            if(count == 0){
                System.out.println("Record is not found to delete");
            }
            else{
                System.out.println("Record has been deleted:");
            }
        }
        catch(InputMismatchException ex){
            System.out.println("Invalid Input Please Try Again:"+ex.getMessage());
        }
    }
    
    public static Customer searchRecord(){// Searching method using customer id and execute query method from customerinfoutil
        Customer c1 = null;
        System.out.println("Enter the Customer ID to search Record:");
        Scanner sc = new Scanner(System.in);
        try{
            int id = sc.nextInt();
            String query = "SELECT * FROM Customer WHERE Customer_ID=" +id+";";
            try{
                ResultSet rs = CustomerInfoUtil.executeQuery(query);
                if(rs.next()){
                    c1 = new Customer();
                    c1.setCustomerId(rs.getInt("Customer_ID"));
                    c1.setCustomerName(rs.getString("Customer_Name"));
                    c1.setEmailId(rs.getString("Email_Address"));
                    c1.setCustPhnNo(rs.getString("Phone_Number"));
                }
            }
             catch(SQLException ex){
            System.out.println("SQL Exception occured in Search Method:" +ex.getMessage());
        }
        }
        catch(InputMismatchException ex){
            System.out.println("Invalid Input Please Try Again:");
        }
       return c1;
    }
    public static ArrayList<Customer> getAllRecord(){// method to get the record from database and storing in arraylist 
        //to use in display method in the main method 
        String query = "SELECT * FROM Customer";
        ArrayList<Customer> customers = new ArrayList<>();
        try{
            ResultSet rs = CustomerInfoUtil.executeQuery(query);
            while(rs.next()){
                Customer c1 = new Customer();
                c1.setCustomerId(rs.getInt("Customer_ID"));
                c1.setCustomerName(rs.getString("Customer_Name"));
                c1.setEmailId(rs.getString("Email_Address"));
                c1.setCustPhnNo(rs.getString("Phone_Number"));
                customers.add(c1);
            }
        }
        catch(SQLException ex){
            System.out.println("SQL exception occured in get record method:" +ex.getMessage());
        }
        return customers;
    }
}
