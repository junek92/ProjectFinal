package jdbc_no_facade;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DialogDecorator extends Dialog{
    
    protected Dialog  dialog;
    private int i = 7;
    private int j = 2;
    protected Panel[][] panelHolder = new Panel[i][j];    
    private   Button  btnCancel  = new Button("Close");
    
    public DialogDecorator(Frame owner) {
        
        super(owner);
        setBounds(200,200,300,300);
        setLayout(new GridLayout(i,j,5,5));
                   
        for(int m = 0; m < i; m++) {
           for(int n = 0; n < j; n++) {
              panelHolder[m][n] = new Panel();
              add(panelHolder[m][n]);
           }
        }
        
        panelHolder[6][1].add(btnCancel);        
       
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
            }
        });
        
        addWindowListener(new WindowAdapter(){
        @Override
            public void windowClosing(WindowEvent e){
               dispose();
               setVisible(false);
            }
        });
    }
    
    
}
