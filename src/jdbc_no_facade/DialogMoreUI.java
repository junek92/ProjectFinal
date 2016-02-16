package jdbc_no_facade;

import java.awt.Frame;
import java.awt.Label;

public class DialogMoreUI extends DialogDecorator{
    
    public DialogMoreUI(Frame frame, String factureNumber) {
        super(frame);
        
        panelHolder[0][0].add( new Label("Number: " ));
        panelHolder[1][0].add( new Label("Data: " ));
        panelHolder[2][0].add( new Label("Provider: " ));
        panelHolder[3][0].add( new Label("Receiver: " ));
        panelHolder[4][0].add( new Label("Goods: " ));
        panelHolder[5][0].add( new Label("Price: " ));
        
        Facture facture = DbRead.getInstance().getFacture(factureNumber);
        panelHolder[0][1].add( new Label(Integer.toString(facture.getNumber())));
        panelHolder[1][1].add( new Label(facture.getDate()));
        panelHolder[2][1].add( new Label(facture.getProvider()));
        panelHolder[3][1].add( new Label(facture.getReceiver()));
        panelHolder[4][1].add( new Label(facture.getGoods()));
        panelHolder[5][1].add( new Label(Double.toString(facture.getPrice())));
        
        setVisible(true);
        
    }
    
}
