package jdbc_no_facade;

import java.sql.Date;


public class Facture {
    private int Number;
    private String Date;
    private String Provider;
    private String Receiver;
    private String Goods;
    private double Price;

    public Facture() {
    }

    public Facture(int Number, String Date, String Provider, String Receiver, String Goods, double Price) {
        this.Number = Number;
        this.Date = Date;
        this.Provider = Provider;
        this.Receiver = Receiver;
        this.Goods = Goods;
        this.Price = Price;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setProvider(String Provider) {
        this.Provider = Provider;
    }

    public void setReceiver(String Receiver) {
        this.Receiver = Receiver;
    }

    public void setGoods(String Goods) {
        this.Goods = Goods;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getNumber() {
        return Number;
    }

    public String getDate() {
        return Date;
    }

    public String getProvider() {
        return Provider;
    }

    public String getReceiver() {
        return Receiver;
    }

    public String getGoods() {
        return Goods;
    }

    public double getPrice() {
        return Price;
    }    
}
