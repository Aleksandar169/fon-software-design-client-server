/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Operation;
import java.util.List;
import model.Odo;
import model.Place;
import model.Worker;

/**
 *
 * @author Lenovo
 */
public class WorkerController extends ClientController {

    private static WorkerController instance;

    private WorkerController() {
    }

    public static WorkerController getInstance() {
        if (instance == null) {
            return new WorkerController();
        }
        return instance;
    }

    public Worker login(Worker w) throws Exception {

        return (Worker) sendRequest(Operation.LOGIN, w);
    }

    public int addWorker(Worker worker) throws Exception {
        return (int) sendRequest(Operation.ADD_WORKER, worker);

    }

    public List<Odo> getWorkers() throws Exception {
        return (List<Odo>) sendRequest(Operation.SHOW_WORKERS, null);
    }

    public void deleteWorker(Worker worker) throws Exception {
        sendRequest(Operation.DELETE_WORKER, worker);
    }

    public Worker getWorker(Worker w) throws Exception {
        return (Worker) sendRequest(Operation.GET_WORKER, w);
    }

    public boolean updateWorker(Worker w) throws Exception {
        return (boolean) sendRequest(Operation.UPDATE_WORKER, w);
    }

    public List<Odo> searchWorker(String text) throws Exception {
        Worker w = new Worker();
        w.setCondtion(text);
        return (List<Odo>) sendRequest(Operation.CONDITION_WORKER, w);
    }

}
