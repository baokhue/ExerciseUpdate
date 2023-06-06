package bean;

import java.util.Date;

public class Orders {
    private int id;
    private int cId;

    private Date o_orderDate;
    private double o_total_price;

    public Orders() {
    }

    public Orders(int id, int cId, Date o_orderDate, double o_total_price) {
        this.id = id;
        this.cId = cId;
        this.o_orderDate = o_orderDate;
        this.o_total_price = o_total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public Date getO_orderDate() {
        return o_orderDate;
    }

    public void setO_orderDate(Date o_orderDate) {
        this.o_orderDate = o_orderDate;
    }

    public double getO_total_price() {
        return o_total_price;
    }

    public void setO_total_price(double o_total_price) {
        this.o_total_price = o_total_price;
    }
}
