package CategoriesAndProducts;

import java.util.Scanner;

public class Product {
    private String name;
    private float id;
    private float price ;
    private String details;

    private float discount_normal =0;

    private float discount_prime =0;
    private float discount_elite = 0;

    public Product(String name, float id, float price , String details){
        this.name = name;
        this.id = id;
        this.price = price;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public float getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void discount(){
        System.out.println("Enter discount for Elite, Prime and Normal customers respectively (in % terms)");
        Scanner obj = new Scanner(System.in);
        float e_d = obj.nextFloat();
        float p_d = obj.nextFloat();
        float n_d = obj.nextFloat();
        this.discount_elite = e_d;
        this.discount_prime = p_d;
        this.discount_normal = n_d;
    }

    public float getDiscount_elite() {
        return discount_elite;
    }

    public float getDiscount_normal() {
        return discount_normal;
    }

    public float getDiscount_prime() {
        return discount_prime;
    }
}
