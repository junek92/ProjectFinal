package jdbc_no_facade;

public class Adapter implements AdapterInterface{

    public void saveToDb(Facture facture) {
//---   btnOK->Adapter->ValidateProxy
//        ValidatorInterface iValidator = new ValidatorProxy();
//        iValidator.writeData(facture, dbname);

//---   btnOK->ValidateProxy->Adapter
        DbRead.getInstance().writeData(facture); 
    }
    
}
