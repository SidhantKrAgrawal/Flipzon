package login;

import CategoriesAndProducts.Category;
import CategoriesAndProducts.Product;

import java.util.ArrayList;

public class Shop {
    public static ArrayList<Category> Categories = new ArrayList<Category>();

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
}


