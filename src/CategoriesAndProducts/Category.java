package CategoriesAndProducts;

import java.util.ArrayList;
import java.util.Scanner;

public class Category {
    private int id;
    private String name;
    public ArrayList<Product> Products = new ArrayList<Product>();


    public Category(String name, int id){
        this.name = name;
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    void addProduct(){
        System.out.println("Add a Product:- ");
        Scanner obj = new Scanner(System.in);
        System.out.print("Product Name: ");
        String name = obj.nextLine();
        System.out.print("Product Id: ");
        float Id = obj.nextFloat();
        System.out.print("Price : ");
        float price = obj.nextFloat();
        System.out.print("Other Details : ");
        Scanner ob = new Scanner(System.in);
        String detail = ob.nextLine();

        Products.add(new Product(name,Id,price,detail));
    }
}
