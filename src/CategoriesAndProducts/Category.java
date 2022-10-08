package CategoriesAndProducts;

import java.util.ArrayList;
import java.util.Scanner;

public class Category {
    private int id;
    private String name;
    ArrayList<Product> Products = new ArrayList<Product>();


    public Category(String name, int id){
        this.name = name;
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    void addProduct(){
        System.out.println("Add a Product:- ");
        Scanner obj = new Scanner(System.in);
        System.out.println("Product Name: ");
        String name = obj.nextLine();
        System.out.println("Product Id: ");
        Float Id = obj.nextFloat();
        System.out.println("Price : ");
        float price = obj.nextFloat();
        System.out.println("Other Details : ");
        String detail = obj.nextLine();

        Products.add(new Product(name,Id,price,detail));
    }
}
