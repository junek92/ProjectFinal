package jdbc_no_facade;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;

public class AddDataUI extends Frame implements UIInterface{

     TextField fNumber;
     TextField fDate;
     TextField fProvider;
     TextField fReceiver;
     TextField fGoods;
     TextField fPrice;
     Button btnOK;
     Button btnCancel;

    public AddDataUI(){
        setSize(320,200);
        
        Panel p1=new Panel();
        Panel p2=new Panel();
        Panel p3=new Panel();
        
        p1.setLayout(new GridLayout(6,0));
        p2.setLayout(new GridLayout(6,0));
        p3.setLayout(new GridLayout(0,2));
        
        // Panel 1
        p1.add(new Label("Number"));
        p1.add(new Label("Date"));
        p1.add(new Label("Provider"));
        p1.add(new Label("Receiver"));
        p1.add(new Label("Goods"));
        p1.add(new Label("Price"));        
        
        // Panel 2
        fNumber = new TextField();
        p2.add(fNumber);
        fDate = new TextField();
        p2.add(fDate);
        fProvider = new TextField();
        p2.add(fProvider);
        fReceiver = new TextField();
        p2.add(fReceiver);
        fGoods = new TextField();
        p2.add(fGoods);
        fPrice = new TextField();
        p2.add(fPrice);       
        
        // Panel 3
        btnOK = new Button("OK");
        p3.add(btnOK);
        btnCancel = new Button("Cancel");
        p3.add(btnCancel);
        
           
        add(p1, BorderLayout.WEST);           
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        
        setVisible(true);
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
        
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Facture facture = new Facture(
                                        Integer.parseInt(fNumber.getText()),
                                        fDate.getText(),
                                        fProvider.getText(),
                                        fReceiver.getText(),
                                        fGoods.getText(),
                                        Double.parseDouble(fPrice.getText()));
               
//---          btnOK->ValidateProxy->Adapter                 
               ValidatorInterface validatorInterface = new ValidatorProxy();
               validatorInterface.writeData(facture);

//---          btnOK->Adapter->ValidateProxy               
//               AdapterInterface iAdapter = new Adapter();
//               iAdapter.saveToDb(facture, "fakturi");
                                            
               dispose();
            }
        });
    }
}
