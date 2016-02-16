package jdbc_no_facade;

import java.util.ArrayList;
import java.util.Collections;

public class SortProxy implements SortInterface{
    
    public ArrayList getColumnData(){
       
        ArrayList<Integer> arrayList = DbRead.getInstance().getColumnData();
        Collections.sort(arrayList);
        
        return arrayList;
    }    
}
