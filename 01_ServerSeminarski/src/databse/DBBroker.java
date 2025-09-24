/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.metal.MetalLookAndFeel;
import model.Odo;

/**
 *
 * @author Lenovo
 */
public class DBBroker {
    Connection connection;
    String url;
    String user;
    String password;

    public DBBroker() {
        url = configuration.Configuration.getInstance().getProperty("url");
        user = configuration.Configuration.getInstance().getProperty("username");
        password = configuration.Configuration.getInstance().getProperty("password");
    
    }
    
    public void openConnection() throws SQLException{
        if(connection==null || connection.isClosed()){
            connection=DriverManager.getConnection(url,user,password);
          //connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/seminarski_v2?useSSL=false&serverTimezone=Europe/Belgrade", "root", "root");
            connection.setAutoCommit(false);
        }
        System.out.println("Konekcija sa bazom - otvorena");
    }
    public void closeConnection() throws SQLException{
         
        connection.close();
        System.out.println("Konekcjia sa bazom - zatvorena");
    }
    public void commit() throws SQLException{
        connection.commit();
        System.out.println("Commit");
    }
    
    public void rollback() throws SQLException{
        
        connection.rollback();
        System.out.println("Rollback");
    }
    
    
    public List<Odo> getAll(Odo odo) throws Exception {
        List<Odo> list = new ArrayList<>();
       
        String query = "SELECT * FROM " + odo.getTableName()+ " "+  odo.getWhere();
        PreparedStatement ps=connection.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        list=odo.getList(rs);
         
        System.out.println(query);
       
        return list;
    }
     public List<Odo> getAllJoin(Odo odo) throws Exception {
        List<Odo> list = new ArrayList<>();
       
        String query = "SELECT * FROM " + odo.getTableName()+odo.join()+ " "+odo.getWhere();
        System.out.println(query);
        Statement ps=connection.createStatement();
        ResultSet rs=ps.executeQuery(query);
        list=odo.getList(rs);
         
        
       
        return list;
    }
    
   
    public int add(Odo odo) throws Exception {
       
        String query = "INSERT into " + odo.getTableName() + " (" + odo.getColumnForInsert() + ") VALUES (" + odo.getValueForInsert() + ")";
        System.out.println(query);
        Statement statement=connection.createStatement();
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs=statement.getGeneratedKeys();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
        
    }

    
    public boolean edit(Odo odo) throws Exception {
        String query = "UPDATE " + odo.getTableName() + " SET " + odo.getValueForUpdate() +" WHERE "+odo.getGeneretedKey();
        System.out.println(query);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int numberOfEditedItems=preparedStatement.executeUpdate();
        return numberOfEditedItems>0;

    }

   
    public boolean delete(Odo odo) throws Exception {      
        String query = "DELETE FROM " + odo.getTableName() + " WHERE " + odo.getGeneretedKey();
        System.out.println(query);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int numberOfDeletedItems=preparedStatement.executeUpdate();
        return numberOfDeletedItems>0;
        
    }
    
    public Odo getObject(Odo odo) throws SQLException, Exception{
        String query="SELECT * from "+odo.getTableName()+ " "+ odo.join()+" "+odo.getWhereRb();
        System.out.println(query);
        Statement statement=connection.createStatement();
        return odo.getObject(statement.executeQuery(query));
    }
    
//    public int getMaxRb(Odo odo) throws Exception {
//        try {
//            String upit = "SELECT Max(" + odo.vratiNazivPK() + ") AS " + odo.vratiNazivPK() + " FROM " + odo.getTableName() + " WHERE " + odo.getGeneretedKey();
//            //Connection konekcija = DbFabrikaKonekcije.getInstanca().getKonekcija();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(upit);
//            if (rs.next() == false) {
//                return 0;
//            } else {
//                return rs.getInt(odo.getGeneretedKey() );
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            throw ex;
//        }
//    }
    
    
}
