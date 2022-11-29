package smtdatabasemanagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerManagement {

    public static void main(String[] args) {// Option are provided as required by client using switch statement
        int optionProvider;
        boolean quit = false;
        System.out.println("***************");
        System.out.println("Create smtbiz Database");
        System.out.println("*****************");
        CreateDatabase.createCustomerDB();
        System.out.println("Database has been created:");
        System.out.println("Press 1 to Add Record");
        System.out.println("Press 2 to Delete Record");
        System.out.println("Press 3 to Search Record");
        System.out.println("Press 4 to Display Record");
        System.out.println("Press 5 to Re-create Database");
        System.out.println("Press 6 to Exit");
        do{
            System.out.println("Please Select from the given options");
            Scanner sc = new Scanner(System.in);
            try{
                optionProvider = sc.nextInt();
                if(optionProvider > 0 && optionProvider <= 6){
                    switch(optionProvider){
                        case 1 ->{
                            System.out.println("Adding Record Has been selected");
                            CustomerOperationManagement.inserRecord();// insert record method from class customer operation management
                            displayRecord();
                            break;
                        }
                        case 2 ->{
                            System.out.println("Deleting Record has been selected");
                            CustomerOperationManagement.deleteRecord();// delete record method from customeopertaionmanagement class
                            displayRecord();
                            break;
                        }
                        case 3 ->{
                            System.out.println("Search Has been Selected");
                            try{
                                Customer c1 = CustomerOperationManagement.searchRecord();// search method from CustomerOperationManagement
                                System.out.println("Customer_ID \t"+"Customer_Name \t\t"+"Customer Email \t\t"+"Customer Phone Number\t\t");
                                System.out.println(c1.getCustomerId()+"\t\t"+c1.getCustomerName()+"\t\t\t"+c1.getEmailId()+"\t\t\t"+c1.getCustPhnNo()+"\t\t\t");
                            }
                            catch(Exception ex){
                                System.out.println("Something Went Wrong:"+ex.getMessage());
                            }
                            break;
                        }
                        case 4 ->{
                            System.out.println("Display Records has been selected");
                            displayRecord();
                        }
                        case 5 ->{
                            System.out.println("Re Creation of database is selected");
                            CreateDatabase.createCustomerDB();
                            System.out.println("New Database has been Created");
                            break;
                        }
                        case 6 ->{
                            quit = true;
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Not An option Please try Again");
                }
            }
            catch(InputMismatchException ex){
                System.out.println("Invalid Input Please Try Again:");
            }
        }
        while(!quit);
        // TODO code application logic here
    }
    private static void displayRecord(){// method to display all the record using getallrecord method from customeroperationmanagement
        ArrayList<Customer> customers = CustomerOperationManagement.getAllRecord();
        if(customers.isEmpty()){
            System.out.println("No Record Found");
        }
        System.out.println("All Customers Record are: ");
        System.out.println("Customer_ID \t"+"Customer_Name \t\t"+"Customer Email \t\t"+"Customer Phone Number\t\t");
        for(Customer c1:customers){
            if(c1.getCustomerName() != null && c1.getEmailId() !=null && c1.getCustPhnNo() != null){
                int id = c1.getCustomerId();
            String name = c1.getCustomerName();
            String email = c1.getEmailId();
            String phnNo = c1.getCustPhnNo();
        System.out.println(id+"\t\t"+name+"\t\t\t"+email+"\t\t\t"+phnNo+"\t\t\t");
            }
            
        }
    }
}
