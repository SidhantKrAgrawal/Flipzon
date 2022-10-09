package login;

import CategoriesAndProducts.Category;
import CategoriesAndProducts.Deals;
import CategoriesAndProducts.Product;

import java.util.ArrayList;

public class Shop {
    public static ArrayList<Category> Categories = new ArrayList<Category>();
    public static ArrayList<Deals> Deal = new ArrayList<Deals>();

    public static Product findProduct(float id){
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

    public static void Product_Catalog(){
        for(int i =0;i<Categories.size();i++){
            System.out.println(" ");
            System.out.println(Categories.get(i).getName());
            System.out.println(" ");
            for(int j =0;j<Categories.get(i).Products.size();j++){
                System.out.println(Categories.get(i).Products.get(i).getName());
            }
        }
    }

    public static void Available_Deals(){
        for(int i=0;i<Deal.size();i++){
            System.out.println("Product 1: "+Deal.get(i).getProd_ID1()+" Product 2: "+ Deal.get(i).getProd_ID2()+" Price : "+ Deal.get(i).getPrice());
        }
    }
}


