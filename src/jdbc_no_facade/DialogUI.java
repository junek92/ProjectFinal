package jdbc_no_facade;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DialogUI extends DialogDecorator
{
     Button  btnMore    = new Button("More");     
     Label   labelText;
     
     public static Frame frame;
     public static String factureNumber;
     
    public DialogUI(Frame frame, String factureNumber)
    {        
        super(frame);
        this.frame = frame;
        this.factureNumber = factureNumber;
         
        panelHolder[2][0].add(labelText = new Label("Number: " + factureNumber));
        panelHolder[2][1].add(labelText = new Label(""));
        
        panelHolder[6][0].add(btnMore);
         
        btnMore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogMoreUI(DialogUI.frame, DialogUI.factureNumber);
                dispose();
            }
        });
        
        setVisible(true);
    }
}
    

