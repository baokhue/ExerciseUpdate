package bean;

public class OrderDetail {
    private int oId;
    private int pId;

    public OrderDetail() {
    }

    public OrderDetail(int oId, int pId) {
        this.oId = oId;
        this.pId = pId;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

}
