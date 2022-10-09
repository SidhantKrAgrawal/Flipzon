package CategoriesAndProducts;

public class Deals {

    private float Prod_ID1;
    private float Prod_ID2;

    private static int Id=0;
    private float Price;

    public void setProd_ID1(float prod_ID1) {
        Prod_ID1 = prod_ID1;
    }

    public void setProd_ID2(float prod_ID2) {
        Prod_ID2 = prod_ID2;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public float getProd_ID1() {
        return Prod_ID1;
    }

    public float getProd_ID2() {
        return Prod_ID2;
    }

    public float getPrice() {
        return Price;
    }

    public static void setId() {
        Id++;
    }
}
