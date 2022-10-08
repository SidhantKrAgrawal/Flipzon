import java.util.Scanner;

public class Customer {
    private String name;
    private String password;
    private float Money = 1000;
    private String status = "NORMAL";

    private void WelcomeCustomer() {
        System.out.println("Welcome " + name + "!!");
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

        } else if (key==4) {

        } else if (key==5) {

        } else if (key==6) {
            getMoney();
        } else if (key==7) {

        } else if (key==8) {

        } else if (key==9) {

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
}
