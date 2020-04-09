import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection { 
    private Connection Connection;
    public static void main(String[] args){

        String url = "jdbc:postgresql://192.168.0.22:1365/bookstore";
        String username  = "postgres";
        String password  = "hamoody1!";
        DBConnection db= new DBConnection();
        db.dbconnection(url,username,password);

        String input;
        Scanner obj = new Scanner(System.in);

        System.out.println("Hey! Welcome to our book store.");
        System.out.println("If you want to change the database please enter D in this menu if not enter S.");
        input = obj.nextLine().toLowerCase();
        if(("d").compareTo(input) == 0){db.changedb(obj);}
        
        System.out.println("Please enter C if your a customer or O if your a owner");
        input = obj.nextLine().toLowerCase();
        if(("o").compareTo(input) == 0){
            Owner owner = new Owner();
            while(true){
                System.out.println("Please enter R if your want the report and M if you want to manage the books");
                input = obj.nextLine().toLowerCase();
                if(("r").compareTo(input) == 0){owner.viewreport();}
                else if(("m").compareTo(input) == 0){owner.bookandpublishermanager();}
            }
        }
        else if(("c").compareTo(input) == 0){
            Customer customer = new Customer();
            customer.getdb(db);
            while(true){
                System.out.println("Please enter s if your want to shop and t if you want to track your order");
                input = obj.nextLine().toLowerCase();
                if(("s").compareTo(input) == 0){customer.search();}
                else if(("t").compareTo(input) == 0){customer.trackorder();}
            }
        }
        obj.close();  
    }
    public Connection dbconnection(String url, String username, String password) {
        try {Class.forName("org.postgresql.Driver");} catch (ClassNotFoundException e) 
        {System.err.println(e);
            System.exit(-1);}
        try {Connection = DriverManager.getConnection(url, username, password);} catch (SQLException e) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,e);}
        return Connection;
    
    }
    public void changedb(Scanner obj){

    }
}