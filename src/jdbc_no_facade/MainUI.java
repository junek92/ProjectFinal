package jdbc_no_facade;

import java.awt.*;
import java.awt.event.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainUI extends Frame implements UIInterface{

	private ArrayList<Integer> dataList;
        
	List        data_list;
	Button      btnAdd;
        Button      btnRefresh;
	
	public MainUI(){
            setSize(240,200);
		
            Panel p1=new Panel();
            Panel p2=new Panel();
            
            p1.setLayout(new BorderLayout());
            p2.setLayout(new GridLayout(2,0));            
            
            p1.add(new Label("Factures", Label.CENTER), BorderLayout.NORTH);
            p1.add(data_list = new List(), BorderLayout.CENTER);
            
            p2.add(btnAdd = new Button("Add"));
            p2.add(btnRefresh = new Button("Refresh"));
            
            add(p1, BorderLayout.CENTER);           
            add(p2, BorderLayout.EAST);
		
            addWindowListener(new WindowAdapter(){
            @Override
		public void windowClosing(WindowEvent e){
                    System.exit(0);
		}
            });
		
            btnAdd.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
                    UIInterface myUI = UIFactory.getUI(UIInterface.GET_ADD_DATA_UI);                   
		}
            });
            
            btnRefresh.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
                    showData();
		}
            });
		
            data_list.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent e){
                    new DialogUI(MainUI.this, data_list.getSelectedItem());
                }
            });
            
            setVisible(true);
            showData();
	}
	
        public void showData(){
            data_list.removeAll();
            
            SortInterface dbProxy = new SortProxy();
            dataList = dbProxy.getColumnData();            
            
            for (int i=0; i<dataList.size(); i++){                
                data_list.add(Integer.toString(dataList.get(i)));
            }
        }
}
