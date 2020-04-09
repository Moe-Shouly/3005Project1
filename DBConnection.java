//import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
Connection Connection;
String url = "jdcb:postgresql://192.168.0.22:1365/bookstore";
String username  = "postgres";
String password  = "hamoody12";

public Connection dbconnection() {
    try {Class.forName("org.postgresql.Driver");} catch (ClassNotFoundException e) {}
    try {Connection = DriverManager.getConnection(url, username, password);JOptionPane.showMessageDialog(null, "Connected");} catch (SQLException e) {
        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,e);JOptionPane.showMessageDialog(null, "Couldn't Connect to DB");}
       return Connection;
   
}

    public static void main(String[] args){
        DBConnection db= new DBConnection();
        db.dbconnection();
    //     String input;
    //     int quit = 0;
    //     error e = new error();
    //     Scanner obj = new Scanner(System.in);
    //     System.out.println("Hey! Welcome to our book store if you would like to go back a page at any point enter b and if you want to quit enter q.");
    //     System.out.println("If you want to change the database please enter d in this menu.");
    //     System.out.println("Note if you decide to go back/quitat any point the changes to the database you have done wouldnt be undone.");
    //     while(true){
    //         System.out.println("Please enter c if your a customer or o if your a owner");
    //         input = obj.nextLine().toLowerCase();
    //             if(input == "o"){
    //                 while(true){
    //                     //show report
    //                     //ask if they want to add or delete books
    //                     // if they add a book the ask for the publishers details and add it
    //                 }
    //             }
    //             else if(input == "c"){
    //                 while(true){
    //                     System.out.println("Please enter s if your want to shop and t if you want to track your order");
    //                     input = obj.nextLine().toLowerCase();
    //                     if(input == "b"){}
    //                     else if(input == "t"){

    //                     }
    //                     else if(input == "b" || input == "q" || quit == 1){
    //                         if(input == "q")
    //                         quit = 1;
    //                         break;
    //                     }
    //                 }
    //             }
    //             else if(input == "b" || input == "q" || quit == 1){
    //                 if(input == "q")
    //                 quit = 1;
    //                 break;
    //             }
    //             else{
    //                 e.print();
    //             }
    //     }
    //     obj.close();  
     }
}

class error{
    public error(){}
    public void print(){System.out.println("Error please Try Again");}
}