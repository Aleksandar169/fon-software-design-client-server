/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Dules
 */
public enum Operation implements Serializable{
    LOGIN, ADD_PLACE, ADD_PHONE, ADD_WORKER, ADD_CUSTOMER, ADD_PD, ADD_RECEIPT, ADD_WP,
    UPDATE_PLACE, UPDATE_PHONE, UPDATE_WORKER, UPDATE_CUSTOMER, UPDATE_PD, UPDATE_RECEIPT,UPDATE_WP,
    DELETE_PLACE, DELETE_PHONE, DELETE_WORKER, DELETE_CUSTOMER,DELETE_PD, DELETE_RECEIPT,DELETE_WP,
    SHOW_PLACES, SHOW_PHONES, SHOW_WORKERS, SHOW_CUSTOMERS, SHOW_PD, SHOW_RECEIPT,SHOW_WP,
    GET_PLACE, GET_PHONE, GET_WORKER, GET_CUSTOMER, GET_PD, GET_RECEIPT, GET_WP,
    CONDITION_PLACE, CONDITION_CUSTOMER,CONDITION_WORKER, CONDITION_PHONE, CONDITION_PD, CONDITION_RECEIPT, CONDITION_WP;
}
