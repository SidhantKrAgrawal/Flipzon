package CategoriesAndProducts;

import CategoriesAndProducts.Category;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private String username = "Beff Jezos";
    private String password = "JeffBezos";
    private ArrayList<Category> Categories = new ArrayList<Category>();
    ArrayList<Deals> Deal = new ArrayList<Deals>();

    private boolean Authentication(){
        Scanner obj = new Scanner(System.in);
        String user = obj.nextLine();
        String pass = obj.nextLine();

        if(user == username && pass == password){
            return true;
        }
        return false;
    }

    public void welcomeAdmin(){
        boolean p = Authentication();
        if(p==false){
            System.out.println("Wrong Username and password");
            return;
        }

        System.out.println("Welcome "+username+"!!!!!");
        System.out.println("");
        System.out.println("Please choose any one of the following actions:");
        System.out.println("1) Add category");
        System.out.println("2) Delete category");
        System.out.println("3) Add Product");
        System.out.println("4) Delete Product");
        System.out.println("5) Set Discount on Product");
        System.out.println("6) Add giveaway deal");
        System.out.println("7) Back");

        Scanner obj = new Scanner(System.in);
        int key = obj.nextInt();

        if(key==1){
            addCategory();
        }else if (key==2){

        } else if (key==3) {
            AddProduct();
        } else if (key==4) {

        } else if (key==5) {
            setDiscount();
        } else if (key==6) {
            GiveAway();
        } else if (key==7) {
            return;
        }
    }

    private void addCategory(){
        int m =0;
        do {
            m=0;
            System.out.println("Add Category ID");
            Scanner obj = new Scanner(System.in);
            int key = obj.nextInt();
            for (int i = 0; i < Categories.size(); i++) {
                if (key == Categories.get(i).getId()) {
                    System.out.println("Dear Admin, the category ID is already used!!! Please set a different and a unique category ID");
                    m=1;
                }
            }
            if(m==0){
                System.out.println("Add name of the category");
                Scanner ob = new Scanner(System.in);
                String name_cat = ob.nextLine();
                Category Cat = new Category(name_cat,key);
                Cat.addProduct();
            }
        }while (m==1);
    }

    private void AddProduct(){
        System.out.println("Enter Category ID");
        Scanner obj = new Scanner(System.in);
        int key = obj.nextInt();
        for (int i = 0; i < Categories.size(); i++) {
            if (key == Categories.get(i).getId()) {
                Categories.get(i).addProduct();
                return;
            }
        }
        System.out.println("ID Invalid!!!");
        return;
    }

    private void GiveAway(){
        System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for");

        System.out.println("");
        Scanner obj = new Scanner(System.in);


        System.out.println("Enter the first Product ID :");
        float id1 = obj.nextFloat();
        float Price1=priceProduct(id1);

        System.out.println("Enter the second Product ID :");
        float id2 = obj.nextFloat();
        float Price2=priceProduct(id2);

        System.out.println("Enter the combined price(Should be less than their combined price)");
        float Price = obj.nextFloat();

        if(Price > Price1 + Price2){
            System.out.println("Invalid Deal!!!!");
        }
        else {
            Deals D = new Deals();
            D.setProd_ID1(id1);
            D.setProd_ID2(id2);
            D.setPrice(Price);
            Deal.add(D);
        }
    }

    private float priceProduct(float id){
        float Price= findProduct(id).getPrice();
        return Price;
    }

    private Product findProduct(float id){
        int I = (int) id;
        for (int i = 0; i < Categories.size(); i++) {
            if (I == Categories.get(i).getId()) {
                for(int j =0 ; j<Categories.get(i).Products.size();j++){
                    if(Categories.get(i).Products.get(j).getId()==id){
                        return Categories.get(i).Products.get(j);
                    }
                }
            }
        }
        return null;
    }
    private void setDiscount(){
        System.out.println("Dear Admin give the Product ID you want to add discount for ");
        System.out.println("Enter the Product ID: ");

        Scanner obj = new Scanner(System.in);
        float id = obj.nextFloat();
        Product p = findProduct(id);
        p.discount();


    }


}
