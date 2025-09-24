/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class WP implements Serializable, Odo {

    private LocalDate date;
    private Worker worker;
    private ProfessionalDegree professionalDegree;
    private String condition;

    public WP() {
    }

    public WP(LocalDate date, Worker worker, ProfessionalDegree professionalDegree) {
        this.date = date;
        this.worker = worker;
        this.professionalDegree = professionalDegree;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public ProfessionalDegree getProfessionalDegree() {
        return professionalDegree;
    }

    public void setProfessionalDegree(ProfessionalDegree professionalDegree) {
        this.professionalDegree = professionalDegree;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "WP{" + "date=" + date + ", worker=" + worker;
    }

    @Override
    public String getTableName() {
        return "wp";
    }

    @Override
    public List<Odo> getList(ResultSet rs) throws Exception {
        List<Odo> list = new ArrayList<>();

        while (rs.next()) {
            Worker w = new Worker(rs);
            ProfessionalDegree pd = new ProfessionalDegree(rs);
            LocalDate date = rs.getDate("wp.date").toLocalDate();
            WP wp = new WP(date, w, pd);
            list.add(wp);
        }
        return list;
    }

    @Override
    public String getColumnForInsert() {
        return "date, worker, pd";
    }

    @Override
    public String getValueForInsert() {
        return "'" + date + "', " + worker.getIdWorker() + ", " + professionalDegree.getIdProfessionalDegree();
    }

    @Override
    public String getGeneretedKey() {
        if (worker != null && professionalDegree != null) {
            return "  wp.pd=" + professionalDegree.getIdProfessionalDegree() + " AND wp.worker=" + worker.getIdWorker();
        }
        if (worker == null && professionalDegree != null) {
            return "    wp.pd=" + professionalDegree.getIdProfessionalDegree();
        }
        if (worker != null && professionalDegree == null) {
            return "  wp.worker=" + worker.getIdWorker();
        }
        return "";
    }

    @Override
    public Odo getObject(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getValueForUpdate() {
        return " date='" + date + "'";
    }

    @Override
    public String getWhere() {
        if(condition!=null) return condition;
//        if (worker != null && professionalDegree != null) {
//            return " WHERE wp.pd=" + professionalDegree.getIdProfessionalDegree() + " AND wp.worker=" + worker.getIdWorker();
//        }
//        if (worker == null && professionalDegree != null) {
//            return " WHERE wp.pd=" + professionalDegree.getIdProfessionalDegree();
//        }
//        if (worker != null && professionalDegree == null) {
//            return " WHERE wp.worker=" + worker.getIdWorker();
//        }
        return "";
    }

    @Override
    public Object[] getObjectArray() {
        Object[] o = {date, worker.getIdWorker() + " - " + worker.getName(), professionalDegree.getIdProfessionalDegree() + " - " + professionalDegree.getName()};
        return o;
    }

    @Override
    public String join() {
        return " JOIN professionaldegree ON professionaldegree.idProfessionaldegree=wp.pd JOIN worker ON worker.idWorker=wp.worker";
    }

    @Override
    public String[] getColumnName() {
        String[] s = {"Date", "Worker", "PD"};
        return s;
    }

    @Override
    public String getWhereRb() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setCondition() {
        if (getWorker() != null && getWorker().getIdWorker()> 0) {
            setCondition(getWorker());
        }
        if (getProfessionalDegree() != null && getProfessionalDegree().getIdProfessionalDegree()> 0) {
            setCondition(getProfessionalDegree());
        }
    }

    public void setCondition(WP wp) {
        if (wp.getWorker() != null && wp.getWorker().getIdWorker() > 0) {
            System.out.println("Setovao sam Where :" + condition);
            setCondition(wp.getWorker());

        }
        if (wp.getProfessionalDegree()!= null && wp.getProfessionalDegree().getIdProfessionalDegree()> 0) {
            setCondition(wp.getProfessionalDegree());
        }

    }

     public void setCondition(Worker w) {
        if (condition == null || condition.length() == 0) {
            condition = " WHERE wp.worker = " + w.getIdWorker();
        } else {
            condition = " AND wp.worker = " + w.getIdWorker();
        }
    }

    public void setCondition(ProfessionalDegree pd) {
        if (condition == null || condition.length() == 0) {
            condition = " WHERE wp.worker = " + pd.getIdProfessionalDegree();
        } else {
            condition = " AND wp.worker = " + pd.getIdProfessionalDegree();
        }
    }

}
