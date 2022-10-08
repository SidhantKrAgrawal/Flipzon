import CategoriesAndProducts.Admin;
import PERSON.Customer;

import java.util.HashMap;
import java.util.Scanner;

public class FLIPZON {
    Admin Beff = new Admin();

    private HashMap<String, Customer> name_customer = new HashMap<>();
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
            add_Customer();
        } else if (key==2) {
            login_Customer();
        } else if (key==3) {
            return;
        }
    }

    private void add_Customer(){
        System.out.println("Enter name : ");
        Scanner obj = new Scanner(System.in);
        String nam = obj.nextLine();

        System.out.println("Enter password : ");
        Scanner ob = new Scanner(System.in);
        String pass = ob.nextLine();

        name_customer.put(nam,new Customer(nam,pass));
    }

    private void login_Customer(){
        System.out.println("Enter name : ");
        Scanner obj = new Scanner(System.in);
        String nam = obj.nextLine();

        if(name_customer.containsKey(nam)){
            Customer C = name_customer.get(nam);
            C.WelcomeCustomer();
        }
        else{
            System.out.println("Wrong name");
        }
    }
    public static void main(String[] args) {
        System.out.println("WELCOME TO FLIPZON");
        System.out.println(" ");
        FLIPZON Shop = new FLIPZON();
        Shop.Welcome_Menu();
    }
}