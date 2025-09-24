/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.List;
import model.Customer;
import model.Odo;
import model.Phone;
import model.Place;
import model.ProfessionalDegree;
import model.Receipt;
import model.WP;
import model.Worker;
import operation.customer.SOAddCustomer;
import operation.customer.SODeleteCustomer;
import operation.customer.SOGetCustomer;
import operation.customer.SOGetCustomers;
import operation.customer.SOUpdateCustomer;
import operation.pd.SOAddPD;
import operation.pd.SODeletePD;
import operation.pd.SOGetPD;
import operation.pd.SOGetPDs;
import operation.pd.SOUpdatePD;
import operation.phone.SOAddPhone;
import operation.phone.SODeletePhone;
import operation.phone.SOGetPhone;
import operation.phone.SOGetPhones;
import operation.phone.SOUpdatePhone;
import operation.place.SOAddPlace;
import operation.place.SODeletePlace;
import operation.place.SOGetPlace;
import operation.place.SOGetPlaces;
import operation.place.SOUpdatePlace;
import operation.receipt.SOAddReceipt;
import operation.receipt.SOGetReceipt;
import operation.receipt.SOGetReceipts;
import operation.receipt.SOUpdateReceipt;
import operation.worker.SOAddWorker;
import operation.worker.SODeleteWorker;
import operation.worker.SOGetWorker;
import operation.worker.SOGetWorkers;

import operation.worker.SOLogIn;
import operation.worker.SOUpdateWorker;
import operation.wp.SOAddWP;
import operation.wp.SOGetWPs;

/**
 *
 * @author Lenovo
 */
public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            return new Controller();
        }
        return instance;
    }

    public Worker login(Worker worker) throws SQLException, Exception {
        SOLogIn ln = new SOLogIn();
        ln.executeSO(worker);
        return ln.getWorker();
    }

    public int addPlace(Place p) throws Exception {
        SOAddPlace ac = new SOAddPlace();
        ac.executeSO(p);
        return ac.getId();
    }

    public List<Odo> getPlaces() throws Exception {
        SOGetPlaces p = new SOGetPlaces();
        p.executeSO(new Place());
        return p.getList();
    }

    public int addPhone(Phone p) throws Exception {
        SOAddPhone ph = new SOAddPhone();
        ph.executeSO(p);
        return ph.getId();
    }

    public int addWorker(Worker wo) throws Exception {
        SOAddWorker aw = new SOAddWorker();
        aw.executeSO(wo);
        return aw.getId();
    }

    public int addCustomer(Customer c) throws Exception {
        SOAddCustomer ac = new SOAddCustomer();
        ac.executeSO((Odo) c);
        return ac.getId();
    }

    public int addWP(WP argument) throws Exception {
        SOAddWP so = new SOAddWP();
        so.executeSO(argument);
        return so.getId();
    }

    public int addPD(ProfessionalDegree pd) throws Exception {
        SOAddPD so = new SOAddPD();
        so.executeSO(pd);
        return so.getId();
    }

    public List<Odo> getCustomers() throws Exception {
        SOGetCustomers gCustomers = new SOGetCustomers();
        gCustomers.executeSO((Odo) new Customer());
        return gCustomers.getList();
    }

    public List<Odo> getPhones() throws Exception {
        SOGetPhones gPhones = new SOGetPhones();
        gPhones.executeSO(new Phone());
        return gPhones.getList();
    }

    public List<Odo> getWorkers() throws Exception {
        SOGetWorkers gWorkers = new SOGetWorkers();
        gWorkers.executeSO(new Worker());
        return gWorkers.getList();
    }

    public List<Odo> getReceipts() throws Exception {
        SOGetReceipts so = new SOGetReceipts();
        so.executeSO(new Receipt());
        return so.getL();
    }

    public List<Odo> getWPs() throws Exception {
        SOGetWPs so = new SOGetWPs();
        so.executeSO(new WP());
        return so.getList();
    }

    public List<Odo> getPDs() throws Exception {
        SOGetPDs so = new SOGetPDs();
        so.executeSO(new ProfessionalDegree());
        return so.getList();
    }

    public boolean deleteCustomer(Odo odo) throws Exception {
        SODeleteCustomer dCustomer = new SODeleteCustomer();
        return dCustomer.executeSO(odo);
    }

    public boolean deletePhone(Odo odo) throws Exception {
        SODeletePhone so = new SODeletePhone();
        return so.executeSO(odo);
    }

    public boolean deletePlace(Odo odo) throws Exception {
        SODeletePlace so = new SODeletePlace();
        return so.executeSO(odo);
    }

    public boolean deleteWorker(Odo odo) throws Exception {
        SODeleteWorker so = new SODeleteWorker();
        return so.executeSO(odo);
    }

    public boolean deletePD(Odo odo) throws Exception {
        SODeletePD so=new SODeletePD();
        return so.executeSO(odo);
    }

    public Customer getCustomer(Odo odo) throws Exception {
        SOGetCustomer so = new SOGetCustomer();
        so.executeSO(odo);
        return (Customer) so.getCustomer();

    }

    public Phone getPhone(Odo odo) throws Exception {
        SOGetPhone so = new SOGetPhone();
        so.executeSO(odo);
        return (Phone) so.getPhone();

    }

    public Place getPlace(Odo odo) throws Exception {
        SOGetPlace so = new SOGetPlace();
        so.executeSO(odo);
        return (Place) so.getPlace();
    }

    public Worker getWorker(Odo odo) throws Exception {
        SOGetWorker so = new SOGetWorker();
        so.executeSO(odo);
        return (Worker) so.getWorker();
    }

    public Receipt getReceipt(Odo odo) throws Exception {
        SOGetReceipt so = new SOGetReceipt();
        so.executeSO(odo);
        return (Receipt) so.getReceipt();
    }

    public ProfessionalDegree getPD(Object argument) throws Exception {
        SOGetPD so = new SOGetPD();
        so.executeSO((Odo) argument);
        return so.getPd();
    }

    public boolean updatePlace(Odo odo) throws Exception {
        SOUpdatePlace so = new SOUpdatePlace();
        return so.executeSO(odo);
    }

    public boolean updateCustomer(Odo odo) throws Exception {
        SOUpdateCustomer so = new SOUpdateCustomer();
        return so.executeSO(odo);
    }

    public boolean updatePhone(Odo odo) throws Exception {
        SOUpdatePhone so = new SOUpdatePhone();
        return so.executeSO(odo);
    }

    public boolean updateWorker(Odo odo) throws Exception {
        SOUpdateWorker so = new SOUpdateWorker();
        return so.executeSO(odo);
    }

    public boolean updateReceipt(Odo odo) throws Exception {
        SOUpdateReceipt so = new SOUpdateReceipt();
        System.out.println(((Receipt)odo).getItems());
        return so.executeSO(odo);
    }

    public boolean updatePD(Odo odo) throws Exception {
        SOUpdatePD so = new SOUpdatePD();
        return so.executeSO(odo);
    }

    public int addReceipt(Receipt r) throws Exception {
        SOAddReceipt so = new SOAddReceipt();
        so.executeSO(r);
        return so.getId();
    }

    public List<Odo> searchPlace(Odo odo) throws Exception {
        SOGetPlaces so = new SOGetPlaces();
        Place p = (Place) odo;
        so.executeSO(p);
        return so.getList();
    }

    public List<Odo> searchCustomer(Place p) throws Exception {
        SOGetCustomers so = new SOGetCustomers();
        Customer c=new Customer();
        c.setIdCustomer(p.getIdPlace());
        so.executeSO(c);
        return so.getList();
    }
    public List<Odo> searchCustomer(Customer c) throws Exception {
        SOGetCustomers so = new SOGetCustomers();
        //Customer c = (Customer) odo;
        so.executeSO(c);
        return so.getList();
    }

    public List<Odo> searchPhone(Odo odo) throws Exception {
        SOGetPhones so = new SOGetPhones();
        so.executeSO((Phone) odo);
        return so.getList();
    }

    public List<Odo> searchWorker(Odo odo) throws Exception {
        SOGetWorkers so = new SOGetWorkers();
        so.executeSO((Worker) odo);
        return so.getList();
    }

    public List<Odo> searchReceipt(Receipt r2) throws Exception {
        SOGetReceipts so=new SOGetReceipts();
        Receipt r = new Receipt();
        r.setCondition(r2);
        so.executeSO(r);
        return so.getL();
    }

}
