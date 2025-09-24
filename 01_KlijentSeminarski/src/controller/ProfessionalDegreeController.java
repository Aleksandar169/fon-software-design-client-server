/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Operation;
import java.util.List;
import model.Odo;
import model.ProfessionalDegree;

/**
 *
 * @author Lenovo
 */
public class ProfessionalDegreeController  extends ClientController{
    private static ProfessionalDegreeController instance;

    private ProfessionalDegreeController() {
    }
    public static ProfessionalDegreeController getInstance(){
        if(instance==null) return new ProfessionalDegreeController();
        return instance;
    }

    public void deletePD(ProfessionalDegree c) throws Exception {
         sendRequest(Operation.DELETE_PD, c);
    }

    public List<Odo> getPDS() throws Exception {
        return (List<Odo>) sendRequest(Operation.SHOW_PD, null);
    }
    
    public boolean updatePD(ProfessionalDegree pd) throws Exception{
        return (boolean) sendRequest(Operation.UPDATE_PD, pd);
    }
    
    public int addPD(ProfessionalDegree pd) throws Exception{
        return (int) sendRequest(Operation.ADD_PD, pd);
        
    }
    public ProfessionalDegree getPD(ProfessionalDegree pd) throws Exception{
        return (ProfessionalDegree) sendRequest(Operation.GET_PD, pd);
    }
    
    
    
    
}
