/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation;

import databse.DBBroker;
import model.Odo;

/**
 *
 * @author Lenovo
 */
public abstract class SystemOperation {
    public DBBroker broker=new DBBroker();
    
    public boolean executeSO(Odo odo) throws Exception{
        try{
            boolean flag=false;
            broker.openConnection();
            if(checkLimits(odo) && execute(odo)){
                flag=true;
            }
            if(flag){
                broker.commit();
            }
            return flag;
        }catch(Exception e){
             
            e.printStackTrace();
            broker.rollback();
        }finally{
            broker.closeConnection();
        }
        return false;
    }

    abstract public boolean checkLimits(Odo odo);

    abstract  public boolean execute(Odo odo);
}
