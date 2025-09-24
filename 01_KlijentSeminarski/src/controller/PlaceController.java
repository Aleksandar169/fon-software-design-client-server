/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Operation;
import java.util.List;
import model.Odo;
import model.Place;

/**
 *
 * @author Lenovo
 */
public class PlaceController extends ClientController{
    private static PlaceController instance;

    private PlaceController() {
    }
    public static PlaceController getInstance(){
        if(instance==null) return new PlaceController();
        return instance;
    }

    public int addPlace(Place place) throws Exception {
        return (int) sendRequest(Operation.ADD_PLACE, place);
        
    }

    public List<Odo> getPlaces() throws Exception {
        return (List<Odo>) sendRequest(Operation.SHOW_PLACES, null);
    }
    
    public void deletePlace(Place place) throws Exception{
        sendRequest(Operation.DELETE_PLACE, place);
    }
    public Place getPlace(Place p) throws Exception{
        return (Place) sendRequest(Operation.GET_PLACE, p);
    }
    
    public boolean updatePlace(Place p) throws Exception{
        return (boolean) sendRequest(Operation.UPDATE_PLACE, p);
    }

    public List<Odo> searchPlaces(String s) throws Exception {
        Place p=new Place();
        p.setCondition(s);
        return (List<Odo>) sendRequest(Operation.CONDITION_PLACE, p);
    }
    
    
}
