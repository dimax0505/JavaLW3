package java3.lesson2DB;

public class Goods {
    private int id;
    private int prodid;
    private String title;
    private double price;

    public Goods(int id, int prodid, String title, double price) {
        this.id = id;
        this.prodid = prodid;
        this.title = title;
        this.price = price;
    }



    @Override
    public String toString() {
        return String.format("Товар [id=%d, prodID=%s, наименование-%s, цена-%s]",id,String.valueOf(prodid),title,String.valueOf(price));
    }

    public int getId() {
        return id;
    }

    public int getProdid() {
        return prodid;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
