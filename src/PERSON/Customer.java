package PERSON;
import login.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Customer extends person {

    private float Money = 1000;
    private String status = "NORMAL";


    ArrayList<Integer> Coupons = new ArrayList<Integer>();
    ArrayList<ProductInCart> Cart = new ArrayList<ProductInCart>();

    public Customer(String name,String password){
        super(name,password);
    }

    private boolean Authentication(){
        Scanner obj = new Scanner(System.in);
        String pass = obj.nextLine();

        return super.Authentication(pass);

    }


    public void WelcomeCustomer() {
        boolean p = Authentication();
        if(p==false){
            System.out.println("Wrong password");
            return;
        }
        System.out.println("Welcome " + getName() + "!!");
        CustomerOptions();
    }
    private void CustomerOptions(){
        System.out.println(" ");
        System.out.println("1) browse products ");
        System.out.println("2) browse deals");
        System.out.println("3) add a product to cart");
        System.out.println("4) add products in deal to cart");
        System.out.println("5) view coupons");
        System.out.println("6) check account balance");
        System.out.println("7) view cart");
        System.out.println("8) empty cart");
        System.out.println("9) checkout cart");
        System.out.println("10) upgrade customer status");
        System.out.println("11) Add amount to wallet");
        System.out.println("12) back");

        Scanner obj = new Scanner(System.in);
        int key = obj.nextInt();

        if(key==1){

        } else if (key==2) {

        } else if (key==3) {
            add_product();
        } else if (key==4) {

        } else if (key==5) {

        } else if (key==6) {
            getMoney();
        } else if (key==7) {

        } else if (key==8) {

        } else if (key==9) {
            this.checkout_cart();
        } else if (key==10) {
            this.Upgrade_Status();
        } else if (key==11) {
            this.AddAmount();
        } else if (key==12) {
            return;
        }
    }

    private boolean Transact(float rupee){
        if(this.Money>rupee){
            this.Money= this.Money - rupee;
            return  true;
        }
        System.out.println("Insufficient balance!! Please try again");
        return  false;

    }
    private void updation_method(int trans,String stat){
        boolean t = Transact((trans));
        if(t==true){
            System.out.println("Status updated to "+stat);
            this.status = stat;
            return;
        }
    }
    private void Status_Prime(){
        if(this.status=="NORMAL"){
           updation_method(200,"PRIME");
           return;
        }
    }

    private void Status_Elite(){
        if(this.status=="NORMAL"){
            updation_method(300,"ELITE");
        } else if (this.status=="PRIME") {
           updation_method(100,"ELITE");
        }
    }

    private void Upgrade_Status(){
        System.out.println("Current status: "+this.status);
        System.out.println("Choose new status: ");
        Scanner obj = new Scanner(System.in);
        String status = obj.nextLine();
        if(status=="PRIME"){
            this.Status_Prime();
        } else if (status == "ELITE") {
            this.Status_Elite();
        }
    }

    private void getMoney() {
        System.out.println("Current account balance is Rupees "+this.Money);
    }

    private void AddAmount(){
        System.out.println("Enter amount to add");
        Scanner obj = new Scanner(System.in);
        float money = obj.nextFloat();

        this.Money = money + this.Money;

        System.out.println("Amount successfully added");
    }


    private void add_product(){
        System.out.println("Enter product ID and quantity : ");
        Scanner obj = new Scanner(System.in);
        float id = obj.nextFloat();
        int q = obj.nextInt();

        ProductInCart p = new ProductInCart(Shop.findProduct(id),q);
        Cart.add(p);
    }

    private void checkout_cart(){
        float price = 0;
        float pre_price =0;
        float fin_price = 0;
        for(int i=0;i< Cart.size();i++) {
            price = price +Cart.get(i).getPrice();

            if (this.status == "ELITE") {
                float disc = discount(10,Cart.get(i).getProduct().getDiscount_elite());
                Cart.get(i).setComputed_discount(disc);
                Cart.get(i).setFinal_price(((float) (price * (100-disc))/100));
                pre_price = pre_price + Cart.get(i).getFinal_price();
                fin_price = pre_price + 100;
            } else if (this.status == "PRIME") {
                float disc = discount(5,Cart.get(i).getProduct().getDiscount_prime());
                Cart.get(i).setComputed_discount(disc);
                Cart.get(i).setFinal_price(((float) (price * (100-disc))/100));
                pre_price = pre_price + Cart.get(i).getFinal_price();
                fin_price = (float) (pre_price + 100 + pre_price * (0.02));
            } else if (this.status == "NORMAL") {
                float disc = discount(0,Cart.get(i).getProduct().getDiscount_prime());
                Cart.get(i).setComputed_discount(disc);
                Cart.get(i).setFinal_price(((float) (price * (100-disc))/100));
                pre_price = pre_price + Cart.get(i).getFinal_price();
                fin_price = (float) (pre_price + 100 + pre_price * (0.05));
            }
        }

        boolean b = Transact(fin_price);
        if(b==true){
            checkout(pre_price,fin_price);
        }


    }

    private void checkout(float pre_price, float fin_price){
        System.out.println("Your Order is placed successfully. Details: ");
        for(int i=0;i< Cart.size();i++){
            String name = Cart.get(i).getProduct().getName();
            float id = Cart.get(i).getProduct().getId();
            String details = Cart.get(i).getProduct().getDetails();
            float price = Cart.get(i).getProduct().getPrice();
            int q = Cart.get(i).getQuantity();
            System.out.println(" ");
            System.out.println("Product Name : "+ name);
            System.out.println("Product ID : "+ id);
            System.out.println(details);
            System.out.println("Quantity: " +q);
            System.out.println("Price : Rs. "+price);

            System.out.println("Discount: "+Cart.get(i).getComputed_discount()+" of "+Cart.get(i).getFinal_price());
            System.out.println(" ");
        }
        System.out.println("Total Price : "+pre_price);
        System.out.println(" ");
        if(this.status == "ELITE"){
            System.out.println("Delivery charges: Rs."+100);
            System.out.println("Final Total Cost: Rs."+fin_price);
            System.out.println("Your order will be delivered within 2 days");

            int r = (int)(Math.random()*2);
            if(r==1){
                System.out.println("Congratulations you have got a free product as a surprise");
            }

            if(pre_price>5000){
                add_Coupons(3,4);
            }
        } else if (this.status == "PRIME") {
            System.out.println("Delivery charges: Rs."+100+"2% of "+pre_price+"="+(fin_price-pre_price));
            System.out.println("Final Total Cost: Rs."+fin_price);
            System.out.println("Your order will be delivered within 7 to 10 days");

            if(pre_price>5000){
                add_Coupons(1,2);
            }
        } else if (this.status == "NORMAL") {
            System.out.println("Delivery charges: Rs."+100+"5% of "+pre_price+"="+(fin_price-pre_price));
            System.out.println("Final Total Cost: Rs."+fin_price);
            System.out.println("Your order will be delivered within 7 to 10 days");
        }


    }

    private float max_3(float first,float second,float third){
        if(first>second && first >third){
            return first;
        } else if (second>first && second>third) {
            return second;
        }
        return third;
    }

    private float discount(float stat,float admin){
        Collections.sort(Coupons,Collections.reverseOrder());
        float d = max_3(stat,admin,Coupons.get(0));
        Coupons.remove(0);
        return d;
    }

    public void add_Coupons(int min, int max){
        int range = max - min +1;
        int rand = (int)(Math.random() * range) + min;

        System.out.println("Congratulations you have won "+rand+"coupons. Discount you will get on them are: ");
        for(int i=0;i<rand;i++){
            int r = (int)(Math.random() * 6) + 5;
            System.out.println(r+"%");
            Coupons.add(r);
        }
    }



}
