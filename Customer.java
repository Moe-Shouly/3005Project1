import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
 
ArrayList<Book> cart;
int orderNo;
ArrayList<String> command;
String FirstName;
DBConnection db;
String input;
Scanner obj = new Scanner(System.in);

public Customer(){
run();
}

public void run(){

}

public void getdb(DBConnection db){
this.db = db;
}
public void search(){
   
    System.out.println("What would you like to search using? (enter h for a futher explination)");
    input = obj.nextLine(); 
    if(("h").compareTo(input) == 0){
        System.out.println("Please enter any book or publisher details\nfor example Author if you would like to search the book store using A Author's Name");   
        input = obj.nextLine(); 
    }
    System.out.println("What would you like to search for?");
    
}
public void checkout(){

}
public void clearcart(){
cart.clear();
}
public void trackorder(){
    System.out.println("Please Input the OrderNo");
    input = obj.nextLine(); 
}
public void adduser(){

}
public boolean userexists(){
    return false;}             
public void addaddress(){

}
public void additem(){
    
}
public void removeitem(){
    
}

}