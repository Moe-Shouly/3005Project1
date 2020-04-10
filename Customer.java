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
int invgenerator = 100000000;
int ordergenerator = 1000000000;
public void run(Connection con) throws SQLException{
String isbn;
try{
    System.out.println("To search for a book choose 'b', to track order choose 't' \n");
    input = obj.nextLine();
    if(("t").compareTo(input) == 0){
        this.trackorder();
    }else{
   
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
            isbn = obj.nextLine();
        ResultSet resultSet = statement.executeQuery(select +"Book_ISBN"
        + "from instructor"
        + "where Book_ISBN = isbn"
        + "group by Book_ISBN,Book_name,Author,Edition,Category,Price");
        while(resultSet.next()){
        System.out.printf(resultSet.getInt("Book_ISBN") + "," + resultSet.getString("Book_name")+ "," + resultSet.getString("Author")+ ","+resultSet.getString("Edition")+ "," +resultSet.getString("Category")+ "," +resultSet.getString("Price"));


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
    if(("y").compareTo(input) == 0){
        this.addcart(isbn);
    }else{
        continue;
    }
    System.out.println("Would you like to Checkout? Choose y for yes n for no\n");
    String check = obj.nextLine();
    if(("y").compareTo(check) == 0){
        this.checkout();
    }else{
        this.run(con);
    }
    
        
 } catch(Exception sql){
        System.out.println("Exception: " + sqle);
    }
    
    }
    }

}

public void getdb(DBConnection db){
this.db = db;
}
public void addcart(String input){

   input.obj.nextLine();
        ResultSet resultSet = statement.executeQuery(select +"Book_ISBN"
        + "from Book"
        + "where Book_ISBN = input"
        + "group by Book_ISBN,Book_name,Author,Edition,Category,Price");
        while(resultSet.next()){
        Book b = new Book(resultSet.getInt("Book_ISBN"),getString("Book_name"),resultSet.getString("Price"),resultSet.getString("Author"),resultSet.getString("Edition"),resultSet.getString("Category"),resultSet.getString("copiesleft"));
         cart.add(b);
        }
    
}
public void checkout(){
int total = 0;
for(int i = 0; i < cart.size();i++){
     total += cart.get(i).getprice();
}

System.out.println("Please choose l to login or r to register\n");
String input;
String pass;
String firstname;
String lastname;
String email;
input = obj.nextLine();
if(("l").compareto() == 0){
    System.out.println("Enter userid\n");
    input = obj.nextLine();
    System.out.println("Enter password\n");
    pass = obj.nextLine();
    Resultset rs = st.executeQuery(select +"userid"
    + "from User"
    + "where userid = input"
    + "group by userid,password");       
    if((input).compareto(rs.getInt("userid")) == 0 && (pass).compareto(rs.getInt("password"))){
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  
      
        invoiceNo = invgenerator++;
        orderNo = ordergenerator++;
        rs = st.executeQuery("insert Into Order(InvoiceNo,OrderNo,user_id,Amount_paid,Date) values (" + invoiceNo + ","  + orderNo + "," + input + "," + total +  "," + dtf.format(now));;
        rs = st.executeQuery("insert Into Tracking(OrderNo,Estimatedtime,Location) values (" + OrderNo + ","  + null + "," + null );;
    }

}else if(("r").compareto() == 0){
    System.out.println("Enter Firstname\n");
    firstname = obj.nextLine();
    System.out.println("Enter lastname\n");
    lastname = obj.nextLine();
    System.out.println("Enter userid u want\n");
    input = obj.nextLine();
    System.out.println("Enter password u want \n");
    pass = obj.nextLine();
    System.out.println("Enter email\n");
    email = obj.nextLine();
    Resultset rs = st.executeQuery("insert Into User(Userid,Firstname,Lastname,email,password) values (" + input +  "," + firsname+ "," + lastname + "," + email + "," + pass);;
   this.checkout();
}

}
public void clearcart(){
cart.clear();
}
public void trackorder(){
    String input;
    System.out.println("Please Input the OrderNo");
    input = obj.nextLine(); 
    Resultset rs = st.executeQuery(select +"orderNo"
    + "from Tracking"
    + "where OrderNo = input"
    + "group by OrderNo,Estimated time,Location");   
    System.out.println(resultSet.getInt("OrderNo") + "," + resultSet.getTime(Estimatedtime)+ "," + resultSet.getString(Location)) ;;
    System.out.println("choose 't' to track another order or 'e' to exit\n");
    input = obj.nextLine();
    if(("t").compareTo(input) == 0){
        this.trackorder();
    }else if(("e").compareTo(input) == 0){
        this.run();
    }
}


}