package PERSON;
import CategoriesAndProducts.*;

public class ProductInCart {
    private Product product;
    private int quantity;

    private float price;

    private float Computed_discount = 0;

    private float final_price = 0;
    public ProductInCart(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice()*quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice(){
        return price;
    }

    public float getComputed_discount() {
        return Computed_discount;
    }

    public void setComputed_discount(float computed_discount) {
        Computed_discount = computed_discount;
    }

    public float getFinal_price() {
        return final_price;
    }

    public void setFinal_price(float final_price) {
        this.final_price = final_price;
    }
}
