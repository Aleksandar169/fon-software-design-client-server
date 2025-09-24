/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Odo;
import model.Phone;
import model.Place;
import model.ProfessionalDegree;
import model.Receipt;
import model.WP;
import model.Worker;

/**
 *
 * @author Lenovo
 */
public class ClientHendler extends Thread {

    Socket socket;
    Sender sender;
    Receiver receiver;
    boolean flag = false;
    Object o;
    int id = 0;

    public ClientHendler(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    @Override
    public void run() {

        while (!flag && socket != null && !socket.isClosed()) {
            //System.out.println("usao u while");
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();

                switch (request.getOperation()) {
                    case LOGIN:
                        Worker w = (Worker) request.getArgument();
                        try {
                            //System.out.println("grr");
                            w = Controller.getInstance().login(w);
                            // System.out.println("greeskaaa");
                            response.setResult(w);
                        } catch (Exception e) {
                            response.setException(e);
                        }

                        break;

                    case ADD_PLACE:
                        Place p = (Place) request.getArgument();
                        try {
                            id = Controller.getInstance().addPlace(p);
                            if (id > 0) {
                                response.setResult(id);

                            } else {
                                throw new Exception("Worker is not added!");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            response.setException(e);
                        }
                        break;

                    case ADD_PHONE:
                        Phone ph = (Phone) request.getArgument();
                        try {
                            id = Controller.getInstance().addPhone(ph);
                            if (id > 0) {
                                response.setResult(id);

                            } else {
                                throw new Exception("Worker is not added!");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            response.setException(e);
                        }
                        break;

                    case ADD_WORKER:
                        Worker wo = (Worker) request.getArgument();
                        try {
                            id = Controller.getInstance().addWorker(wo);
                            if (id > 0) {
                                response.setResult(id);

                            } else {
                                throw new Exception("Worker is not added!");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            response.setException(e);
                        }
                        break;

                    case ADD_CUSTOMER:
                        Customer c = (Customer) request.getArgument();
                        try {
                            id = Controller.getInstance().addCustomer(c);
                            if (id > 0) {
                                response.setResult(id);

                            } else {
                                throw new Exception("Customer is not added!");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            response.setException(e);
                        }
                        break;
                    case ADD_RECEIPT:
                        Receipt r = (Receipt) request.getArgument();
                        try {
                            id = Controller.getInstance().addReceipt(r);
                            if (id > 0) {
                                response.setResult(id);

                            } else {
                                throw new Exception("Receipt is not added!");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            response.setException(e);
                        }

                        break;
                    case ADD_WP:
                        WP wp = (WP) request.getArgument();

                        try {
                            id = Controller.getInstance().addWP(wp);
                            if (id > 0) {
                                response.setResult(id);

                            } else {
                                throw new Exception("WP is not added!");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            response.setException(e);
                        }

                        break;
                    case ADD_PD:
                        ProfessionalDegree pd = (ProfessionalDegree) request.getArgument();
                        try {
                            id = Controller.getInstance().addPD(pd);
                            if (id > 0) {
                                response.setResult(id);

                            } else {
                                throw new Exception("Receipt is not added!");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            response.setException(e);
                        }
                        break;

                    case SHOW_PLACES:
                        List<Odo> places = (List<Odo>) request.getArgument();
                        try {
                            //System.out.println("grr");
                            places = Controller.getInstance().getPlaces();
                            // System.out.println("greeskaaa");
                            response.setResult(places);
                        } catch (Exception e) {
                            response.setException(e);
                        }
                        break;
                    case SHOW_CUSTOMERS:
                        List<Odo> customers = (List<Odo>) request.getArgument();
                        try {
                            //System.out.println("grr");
                            customers = Controller.getInstance().getCustomers();
                            // System.out.println("greeskaaa");
                            response.setResult(customers);
                        } catch (Exception e) {
                            response.setException(e);
                        }
                        break;
                    case SHOW_PHONES:
                        List<Odo> phones = (List<Odo>) request.getArgument();
                        try {
                            //System.out.println("grr");
                            phones = Controller.getInstance().getPhones();
                            // System.out.println("greeskaaa");
                            response.setResult(phones);
                        } catch (Exception e) {
                            response.setException(e);
                        }
                        break;
                    case SHOW_WORKERS:
                        List<Odo> workers = (List<Odo>) request.getArgument();
                        try {
                            //System.out.println("grr");
                            workers = Controller.getInstance().getWorkers();
                            // System.out.println("greeskaaa");
                            response.setResult(workers);
                        } catch (Exception e) {
                            response.setException(e);
                        }
                        break;
                    case SHOW_RECEIPT:
                        List<Odo> list = (List<Odo>) request.getArgument();
                        try {
                            //System.out.println("grr");
                            list = Controller.getInstance().getReceipts();
                            // System.out.println("greeskaaa");
                            response.setResult(list);
                        } catch (Exception e) {
                            response.setException(e);
                        }

                        break;
                    case SHOW_PD:
                        List<Odo> pds = (List<Odo>) request.getArgument();
                        try {
                            //System.out.println("grr");
                            pds = Controller.getInstance().getPDs();
                            // System.out.println("greeskaaa");
                            response.setResult(pds);
                        } catch (Exception e) {
                            response.setException(e);
                        }
                        break;

                    case SHOW_WP:
                        List<Odo> wps = (List<Odo>) request.getArgument();
                        try {
                            //System.out.println("grr");
                            wps = Controller.getInstance().getWPs();
                            // System.out.println("greeskaaa");
                            response.setResult(wps);
                        } catch (Exception e) {
                            response.setException(e);
                        }
                        break;
                    case DELETE_CUSTOMER:
                       try {
                        if (Controller.getInstance().deleteCustomer((Odo) request.getArgument())) {
                            response.setResult(true);
                        } else {
                            throw new Exception("System did not delete the customer!");
                        }
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case DELETE_PHONE:
                        try {
                        if (Controller.getInstance().deletePhone((Odo) request.getArgument())) {
                            response.setResult(true);
                        } else {
                            throw new Exception("Phone is not deleted!");
                        }
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case DELETE_WORKER:
                        try {
                        if (Controller.getInstance().deleteWorker((Odo) request.getArgument())) {
                            response.setResult(true);
                        } else {
                            throw new Exception("Worker is not deleted!");
                        }
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;

                    case DELETE_PLACE:
                        try {
                        if (Controller.getInstance().deletePlace((Odo) request.getArgument())) {
                            response.setResult(true);
                        } else {
                            throw new Exception("Place is not deleted!");
                        }
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case DELETE_PD:
                        try {
                        if (Controller.getInstance().deletePD((Odo) request.getArgument())) {
                            response.setResult(true);
                        } else {
                            throw new Exception("PD is not deleted!");
                        }
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;

                    case GET_CUSTOMER:
                        try {
                        Customer c1 = Controller.getInstance().getCustomer((Odo) request.getArgument());
                        response.setResult(c1);
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case GET_PHONE:
                        try {
                        Phone p1 = Controller.getInstance().getPhone((Odo) request.getArgument());
                        response.setResult(p1);
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case GET_PLACE:
                        try {
                        Place pl1 = Controller.getInstance().getPlace((Odo) request.getArgument());
                        response.setResult(pl1);
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case GET_WORKER:
                        try {
                        Worker w1 = Controller.getInstance().getWorker((Odo) request.getArgument());
                        response.setResult(w1);
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case GET_RECEIPT:
                        try {
                        Receipt re1 = Controller.getInstance().getReceipt((Odo) request.getArgument());
                        response.setResult(re1);
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case GET_PD:
                        try {
                        ProfessionalDegree pd1 = Controller.getInstance().getPD(request.getArgument());
                        response.setResult(pd1);
                    } catch (Exception e) {
                        response.setException(e);
                    }

                    break;
                    case UPDATE_CUSTOMER:
                        try {
                        if (Controller.getInstance().updateCustomer((Odo) request.getArgument())) {
                            response.setResult(true);
                        } else {
                            throw new Exception("Customer is not updated!");
                        }
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case UPDATE_PHONE:
                        try {
                        if (Controller.getInstance().updatePhone((Odo) request.getArgument())) {
                            response.setResult(true);
                        } else {
                            throw new Exception("Phone is not updated!");
                        }
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case UPDATE_PLACE:
                    try {
                        if (Controller.getInstance().updatePlace((Odo) request.getArgument())) {
                            response.setResult(true);
                        } else {
                            throw new Exception("Place is not updated!");
                        }
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case UPDATE_WORKER:
                        try {
                        if (Controller.getInstance().updateWorker((Odo) request.getArgument())) {
                            response.setResult(true);
                        } else {
                            throw new Exception("Worker is not updated!");
                        }
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case UPDATE_PD:
                        try {
                        if (Controller.getInstance().updatePD((Odo) request.getArgument())) {
                            response.setResult(true);
                        } else {
                            throw new Exception("PD is not updated!");
                        }
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case UPDATE_RECEIPT:
                        try {
                        if (Controller.getInstance().updateReceipt((Odo) request.getArgument())) {
                            response.setResult(true);
                        } else {
                            throw new Exception("Receipt is not updated!");
                        }
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;

                    case CONDITION_PLACE:
                        try {
                        List<Odo> l = Controller.getInstance().searchPlace((Odo) request.getArgument());

                        response.setResult(l);

                    } catch (Exception e) {
                        response.setException(e);
                    }
                    break;
                    case CONDITION_CUSTOMER:
                        o = request.getArgument();
                        try {
                            if (o instanceof Place) {
                                List<Odo> l = Controller.getInstance().searchCustomer((Place) o);
                                response.setResult(l);

                            }
                            if (o instanceof Customer) {

                                List<Odo> l = Controller.getInstance().searchCustomer((Customer)o);

                                response.setResult(l);
                            }

                        } catch (Exception e) {
                            response.setException(e);
                        }
                        break;
                    case CONDITION_PHONE:
                             try {
                        List<Odo> l = Controller.getInstance().searchPhone((Odo) request.getArgument());

                        response.setResult(l);

                    } catch (Exception e) {
                        response.setException(e);
                    }

                    break;
                    case CONDITION_WORKER:
                             try {
                        List<Odo> l = Controller.getInstance().searchWorker((Odo) request.getArgument());

                        response.setResult(l);

                    } catch (Exception e) {
                        response.setException(e);
                    }

                    break;
                    case CONDITION_RECEIPT:
                        Receipt r2 = (Receipt) request.getArgument();

                        try {
                            List<Odo> l = Controller.getInstance().searchReceipt(r2);
                            response.setResult(l);

                        } catch (Exception e) {
                            response.setException(e);
                        }

                        break;

                    default:
                        System.out.println("Greska kod operacija u clientHendleru");

                }

                sender.send(response);
            } catch (Exception ex) {
                ex.printStackTrace();
                Logger.getLogger(ClientHendler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void stopThread() {
        flag = true;
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientHendler.class.getName()).log(Level.SEVERE, null, ex);
        }
        interrupt();

    }

}
