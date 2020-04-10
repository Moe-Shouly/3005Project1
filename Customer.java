import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
public class Customer {
 
ArrayList<Book> cart;
int orderNo;
ArrayList<String> command;
String FirstName;
DBConnection db;
String input;
Random rand;
Scanner obj = new Scanner(System.in);
Book b;
Statement st = null;
public Customer(){
cart = new ArrayList<>();
command = new String();
}

public void run(Connection con) throws SQLException{

try{
   
    System.out.println("What would you like to search using? (enter h for a futher explination)\n");
    input = obj.nextLine().toLowerCase(); 
    if(("h").compareTo(input) == 0){
        while(true){
        System.out.println("If you know the book_isbn enter it and checkout if no\n");
        System.out.println("Please enter\n BI - to search using Book_ISBN\nBN - to search using Book_name\nA - to search using Author\n E  - to search using Edition\nC - to search using Category\nP - to search using Price\n"); 
        System.out.println("To add book to cart enter book_isbn\n");
        input = obj.nextLine(); 
        
     if(("BI").compareTo(input) == 0 || ("y").compareTo(input)){
            System.out.println("please enter Book_ISBN");
            input.obj.nextLine();
        ResultSet resultSet = statement.executeQuery(select +"Book_ISBN"
        + "from instructor"
        + "where Book_ISBN = input"
        + "group by Book_ISBN,Book_name,Author,Edition,Category,Price");
        while(resultSet.next()){
        System.out.printf(resultSet.getInt("Book_ISBN") + "," + resultSet.getString("Book_name")+ "," + resultSet.getString("Author")+ ","+resultSet.getString("Edition")+ "," +resultSet.getString("Category")+ "," +resultSet.getString("Price"));
        Book b = new Book(resultSet.getInt("Book_ISBN"),getString("Book_name"),resultSet.getString("Price"),resultSet.getString("Author"),resultSet.getString("Edition"),resultSet.getString("Category"),resultSet.getString("copiesleft"));
         cart.add(b);

        }
      }
    if(("BN").compareTo(input) == 0){
          System.out.println("please enter book name");
          input = obj.nextLine();
        ResultSet resultSet = statement.executeQuery(select +"Book_name"
        + "from instructor"
        + "where Book_name= input"
        + "group by Book_ISBN,Book_name,Author,Edition,Category,Price");
        while(resultSet.next()){
        System.out.printf(resultSet.getInt("Book_ISBN") + "," + resultSet.getString("Book_name")+ "," + resultSet.getString("Author")+ ","+resultSet.getString("Edition")+ "," +resultSet.getString("Category")+ "," +resultSet.getString("Price"));
        }


  }
  if(("A").compareTo(input) == 0){
    System.out.println("please enter Author");
    input = obj.nextLine();
    ResultSet resultSet = statement.executeQuery(select +"Author"
    + "from instructor"
    + "where Author = input"
    + "group by Book_ISBN,Book_name,Author,Edition,Category,Price");
    while(resultSet.next()){
    System.out.printf(resultSet.getInt("Book_ISBN") + "," + resultSet.getString("Book_name")+ "," + resultSet.getString("Author")+ ","+resultSet.getString("Edition")+ "," +resultSet.getString("Category")+ "," +resultSet.getString("Price"));
    }

    
    }  
    if(("E").compareTo(input) == 0){
        System.out.println("please enter Edition");
        input = obj.nextLine();
        ResultSet resultSet = statement.executeQuery(select +"Edition"
        + "from instructor"
        + "where Edition = input"
        + "group by Book_ISBN,Book_name,Author,Edition,Category,Price");
        while(resultSet.next()){
        System.out.printf(resultSet.getInt("Book_ISBN") + "," + resultSet.getString("Book_name")+ "," + resultSet.getString("Author")+ ","+resultSet.getString("Edition")+ "," +resultSet.getString("Category")+ "," +resultSet.getString("Price"));
        }
    }
    if(("C").compareTo(input) == 0){
        System.out.println("please enter Category");
        input = obj.nextLine();
        ResultSet resultSet = statement.executeQuery(select +"Category"
        + "from instructor"
        + "where Category = input"
        + "group by Book_ISBN,Book_name,Author,Edition,Category,Price");
        while(resultSet.next()){
        System.out.printf(resultSet.getInt("Book_ISBN") + "," + resultSet.getString("Book_name")+ "," + resultSet.getString("Author")+ ","+resultSet.getString("Edition")+ "," +resultSet.getString("Category")+ "," +resultSet.getString("Price"));
        }
           
    }
    if(("P").compareTo(input) == 0){
        System.out.println("please enter Price");
        input = obj.nextLine();
        ResultSet resultSet = statement.executeQuery(select +"Price"
        + "from instructor"
        + "where Price = input"
        + "group by Book_ISBN,Book_name,Author,Edition,Category,Price");
        while(resultSet.next()){
        System.out.printf(resultSet.getInt("Book_ISBN") + "," + resultSet.getString("Book_name")+ "," + resultSet.getString("Author")+ ","+resultSet.getString("Edition")+ "," +resultSet.getString("Category")+ "," +resultSet.getString("Price"));
        }
    
  
    }
    System.out.println("Would you like to add book to cart? Choose y for yes n for no\n");
    input = obj.nextLine();
    if(("no").compareTo(input) == 0){
        continue;
    }
    System.out.println("Would you like to Checkout? Choose y for yes n for no\n");
    String check = obj.nextLine();
    if(("y").compareTo(check)){
        this.checkout();
    }
    
}
 } catch(Exception sql){
        System.out.println("Exception: " + sqle);
    }
    



}

public void getdb(DBConnection db){
this.db = db;
}
public void search(){
   
    
}
public void checkout(){
int total = 0;
for(int i = 0; i < cart.size();i++){
     total += cart.get(i).getprice();
}

System.out.println("Please choose l to login or r to register\n");
String input;
String pass;
String city;
String Country;
String Postalcode;
String 
input = obj.nextLine();
if(("l").compareto()){
    System.out.println("Enter userid\n");
    input = obj.nextLine();
    System.out.println("Enter password\n");
    pass = obj.nextLine();
    Resultset rs = st.executeQuery(select +"userid"
    + "from User"
    + "where userid = input"
    + "group by userid,password");       
    if((input).compareto(rs.getInt("userid")) == 0 && (pass).compareto(rs.getInt("password"))){
    System.out.println("Enter Billing address\n");
    System.out.println("Enter city\n");

      //
        invoiceNo = rand.nextInt()
        orderNo = 
        rs = st.executeQuery("insert Into Order(InvoiceNo,OrderNo,user_id,Amount_paid,Date,Shippingadressid,Billingaddressid) values (" + invoiceNo + ","  + orderNo + "," + input + "," + total + "," + PhoneNo + "," + Address_id + ");";

    }

}

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