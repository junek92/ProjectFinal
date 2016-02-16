package jdbc_no_facade;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbRead implements SortInterface, ValidatorInterface{
    
    public static DbRead instance = null;
    
    private String           dburl;
    private String           username;
    private String           password;
    private Facture          facture;
    
    private DbRead(){        
        dburl="jdbc:mysql://localhost/testDB";
        username = "admin";
        password = "123456";

        try{
            Class.forName("org.gjt.mm.mysql.Driver");
        }  catch (ClassNotFoundException e){
            System.out.println("Can't load class:" + e.getMessage());
        }

        try {
            DriverManager.getDriver(dburl);
        } catch (SQLException e){
            e.printStackTrace();
        }       
    }
    
    public static DbRead getInstance(){
        if(instance == null) {
            instance = new DbRead();
        }           
        return instance;
    }
    
    public ArrayList getColumnData (){            
            Connection con=null;
            ResultSet resultset=null;
            
            try {
                con = DriverManager.getConnection(dburl,username,password);
            } catch (SQLException e){
                e.printStackTrace();
            }

            try {
                 Statement st = con.createStatement();
                 resultset = st.executeQuery("select * from  fakturi");
            } catch (SQLException e){
                e.printStackTrace();
            }

            ArrayList<Integer> data = new ArrayList<Integer>();

            try{
               resultset.first();
               while (!resultset.isAfterLast()){
                   int s = resultset.getInt("Number");
                   data.add(s);
                   resultset.next();
               }
            } catch (SQLException e){
               e.printStackTrace();
            }

            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                resultset.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return data;		
	}
    
    public Facture getFacture (String facNumber){
            facture = new Facture();
            Connection con=null;
            ResultSet resultset=null;
            
            try {
                con = DriverManager.getConnection(dburl,username,password);
            } catch (SQLException e){
               e.printStackTrace();
            }

            try {
                 Statement st = con.createStatement();
                 resultset = st.executeQuery("select * from  fakturi where Number=" + facNumber + ";");
            } catch (SQLException e){
                e.printStackTrace();
            }

            try{
               resultset.first();
               while (!resultset.isAfterLast()){
               
                   int colNumber = resultset.getInt(2);                   
                   facture.setNumber(colNumber);
                   String colDate = resultset.getString(3);
                   facture.setDate(colDate);
                   String colProv = resultset.getString(4);
                   facture.setProvider(colProv);
                   String colRec = resultset.getString(5);
                   facture.setReceiver(colRec);
                   String colGoods = resultset.getString(6);
                   facture.setGoods(colGoods);
                   double colPrice = resultset.getDouble(7);
                   facture.setPrice(colPrice);
                   
                   resultset.next();
               }
            } catch (SQLException e){
               e.printStackTrace();
            }

            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                resultset.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return facture;		
	}
    
    public void writeData(Facture facture){
        Connection con=null;
        
        try {
                con = DriverManager.getConnection(dburl,username,password);
            } catch (SQLException e){
                e.printStackTrace();
            }

        try {
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO fakturi"  
                    + " (Number, Date, Provider, Receiver, Goods, Price) VALUES ("
                    + facture.getNumber() + ", " 
                    + "'" + facture.getDate() + "', "
                    + "'" + facture.getProvider() + "', "
                    + "'" + facture.getReceiver()+ "', "
                    + "'" + facture.getGoods()+ "', "
                    + "'" + facture.getPrice()+ "');" 
                ); 
        } catch (SQLException e){
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
