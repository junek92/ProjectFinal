package jdbc_no_facade;

public class ValidatorProxy implements ValidatorInterface{

    public void writeData(Facture facture) {
        if (!(facture.getNumber() < 99999999 && facture.getNumber() > 0) ||
            !(facture.getPrice()  > 0 && facture.getPrice() < 999999)){
                System.out.println("EROR");                
        }
        else{
//---       btnOK->ValidateProxy->Adapter            
            AdapterInterface adapterInterface = new Adapter();
            adapterInterface.saveToDb(facture);
            
//---       btnOK->Adapter->ValidateProxy
//            DbRead.getInstance().writeData(facture, tablename);
        }
    }
    
}
