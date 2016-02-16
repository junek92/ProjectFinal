package jdbc_no_facade;

public class UIFactory {
    public static UIInterface getUI (int intUI) {
        switch(intUI){
            case 1: return new MainUI();                               
            case 2: return new AddDataUI();           
            default: return null; 
        }
    }
}
