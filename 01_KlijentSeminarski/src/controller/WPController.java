/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Operation;
import java.util.List;
import model.Odo;
import model.WP;

/**
 *
 * @author Lenovo
 */
public class WPController extends ClientController {

    private static WPController instance;

    private WPController() {
    }

    public static WPController getInstance() {
        if (instance == null) {
            return new WPController();
        }
        return instance;
    }

    public int addWP(WP wp) throws Exception {
        return (int) sendRequest(Operation.ADD_WP, wp);
    }

    public List<Odo> getWPs() throws Exception {
        return (List<Odo>) sendRequest(Operation.SHOW_WP, null);
    }
    

}
