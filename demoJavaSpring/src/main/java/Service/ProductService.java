package Service;

import Model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
        products.add(new Product(1,"Nguyễn Thị Vân",600,"https://live.staticflickr.com/4186/33831641073_ed66d06d98_z.jpg"));
        products.add(new Product(2,"Nguyễn Thị Ánh",500,"https://gamek.mediacdn.vn/133514250583805952/2021/12/18/photo-1-1639800678970926658533.jpg"));
        products.add(new Product(3,"Nguyễn Thị Nút Cán",400,"https://image.winudf.com/v2/image1/Y29tLnNzc3MudnNiZ2hvdGdfc2NyZWVuXzJfMTU1NzUzMjgzM18wMDU/screen-2.webp?fakeurl=1&type=.webp"));
        products.add(new Product(4,"Nguyễn thị Ngân Hà",400,"https://thptlevantamsoctrang.edu.vn/wp-content/uploads/2023/03/vsbg-5.jpg"));
        products.add(new Product(5,"Nguyễn Thị Vân Anh",400,"https://gamek.mediacdn.vn/133514250583805952/2021/12/18/photo-1-1639800841076808022272.jpg"));
        products.add(new Product(6,"Nguyễn Thị liên",400,"https://biztime.com.vn/upload/photos/2019/05/xtNWdVWaVDGDPuH7IN1n_31_c8c20cf5237587dd4a00ad1a72b494f8_image.jpg"));
    }

    public Product findById(int id){
        for (Product product :products) {
         if(product.getId() == id){
             return product;
         }
        }
        return null;
    }
    public void edit(Product product1){
        Product product = findById(product1.getId());
        product.setName(product1.getName());
        product.setPrice(product1.getPrice());
        product.setImage(product1.getImage());
    }
    public void add(Product product){
        int id = product.getId();
        String name =  product.getName();
        double price = product.getPrice();
        String image = product.getImage();
        products.add(new Product(id , name,price,image));
    }
    public void delete(int id){
        products.remove(findById(id));
    }

    public List<Product> findAll(){
        return products;
    }

    public List<Product> findByName(String name) throws SQLException {
        List<Product> searchList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(products.get(i).toString());
                searchList.add(products.get(i));
            }
        }
        return searchList;
}