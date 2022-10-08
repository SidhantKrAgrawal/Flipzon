import CategoriesAndProducts.Admin;

import java.util.Scanner;

public class FLIPZON {
    Admin Beff = new Admin();
    private void Welcome_Menu(){
        while(true){
            System.out.println("1) Enter as Admin");
            System.out.println("2) Explore the Product Catalog");
            System.out.println("3) Show Available Deals");
            System.out.println("4) Enter as Customer");
            System.out.println("5) Exit the Application");

            Scanner obj = new Scanner(System.in);
            int key = obj.nextInt();

            if(key==1){
                Beff.welcomeAdmin();
            }else if (key==2){

            } else if (key==3) {

            } else if (key==4) {
                Enter_Customer();
            } else if (key==5) {
                return;
            }
        }
    }

    private void Enter_Customer(){
        System.out.println("1) Sign up");
        System.out.println("2) Log in");
        System.out.println("3) Back");

        Scanner obj = new Scanner(System.in);
        int key = obj.nextInt();

        if(key==1){

        } else if (key==2) {

        } else if (key==3) {
            return;
        }
    }
    public static void main(String[] args) {
        System.out.println("WELCOME TO FLIPZON");
        System.out.println(" ");
        FLIPZON Shop = new FLIPZON();
        Shop.Welcome_Menu();
    }
}