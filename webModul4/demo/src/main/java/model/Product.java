package model;

public class Product {
    private int id, price;
    private String name, img;

    public Product(int id, int price, String name, String img) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.img = img;
    }

    public Product(int price, String name, String img) {
        this.price = price;
        this.name = name;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
