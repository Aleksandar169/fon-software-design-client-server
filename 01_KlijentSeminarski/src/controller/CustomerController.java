/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Operation;
import java.util.List;
import model.Customer;
import model.Odo;
import model.Place;

/**
 *
 * @author Lenovo
 */
public class CustomerController extends ClientController{
    private static CustomerController instance;

    private CustomerController() {
    }
    
    public static CustomerController getInstance(){
        if(instance==null) return new CustomerController();
        return instance;               
    }
     public int addCustomer(Customer c) throws Exception {
        return (int) sendRequest(Operation.ADD_CUSTOMER, c);
        
    }

    public List<Odo> getCustomers() throws Exception {
        return (List<Odo>) sendRequest(Operation.SHOW_CUSTOMERS, null);
    }
    
    public void deleteCustomer(Customer c) throws Exception{
        sendRequest(Operation.DELETE_CUSTOMER, c);
    }
    
    public Customer getCustomer(Customer c) throws Exception{
        return (Customer) sendRequest(Operation.GET_CUSTOMER, c);
    }
    
    public boolean updateCustomer(Customer c) throws Exception{
        return (boolean) sendRequest(Operation.UPDATE_CUSTOMER, c);
    }

    public List<Odo> searchCustomer(String s) throws Exception {
        Customer c=new Customer();
        c.setCondition(s);
        return (List<Odo>) sendRequest(Operation.CONDITION_CUSTOMER, c);     
    }

    public List<Odo> searchCustomer(Place place) throws Exception {   
        Customer c=new Customer();
        
        
        return (List<Odo>) sendRequest(Operation.CONDITION_CUSTOMER, place);
    }

    public List<Odo> searchCustomer(Customer c) throws Exception {
        c.setCondition();
        return (List<Odo>) sendRequest(Operation.CONDITION_CUSTOMER, c);
    }
    
    
}
