import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
public class Customer {
 
ArrayList<Book> cart;
int orderNo;
int invoiceNo;
ArrayList<String> command;
String FirstName;
DBConnection db;
String input;
Random rand;
Scanner obj = new Scanner(System.in);
Book b;
Statement st;
int invgenerator = 100000000;
int ordergenerator = 1000000000;
HashMap<String,String> m = new HashMap<String,String>();
String key;
ResultSet rs;
public Customer(){
    cart = new ArrayList<>();
    m.put("BI", "Book_ISBN");
    m.put("BN", "Book_name");
    m.put("A", "Author");
    m.put("E", "Edition");
    m.put("C", "Category");
    m.put("P", "Price");
}
public void run() throws SQLException{
    try{
        System.out.println("What would you like to search using? (enter h for a futher explination)\n");
        input = obj.nextLine().toLowerCase();  
        while(true){
            System.out.println("Please enter\n BI - to search using Book_ISBN\nBN - to search using Book_name\nA - to search using Author\n E  - to search using Edition\nC - to search using Category\nP - to search using Price"); 
            System.out.println("To add book to cart enter book_isbn");
            key = obj.nextLine(); 
            if(m.containsKey(input)){
                System.out.println("please enter" + m.get(key));
                input = obj.nextLine();
                this.selectquery(m.get(key),input , 0);  
            }
            System.out.println("Would you like to add a book to the cart? If yes please enter the book ISBN else enter n");
            input = obj.nextLine();
            if(("n").compareTo(input) != 0){this.addcart(input);}
            System.out.println("If you would like to checkout enter c");
            if(("c").compareTo(obj.nextLine()) == 0){break;}
            }
            this.checkout();
    } 
    catch(Exception sql){
        System.out.println("Exception: " + sql.toString());
    }
}
public void getst(Statement st){
this.st = st;
}
public void addcart(String input){
    this.selectquery("Book_ISBN", input, 1);  
}
public void checkout() throws SQLException {
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
if(("l").compareTo(input) == 0){
    System.out.println("Enter userid");
    input = obj.nextLine();
    System.out.println("Enter password");
    pass = obj.nextLine();
    rs = queryrunner("select User_id,Password" + "from User" + "where userid = " + input + "group by userid,password");       
    if((input).compareTo((rs.getInt("userid") + "")) == 0 && (pass).compareTo(rs.getInt("password") + "") == 0){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  
        invoiceNo = invgenerator++;
        orderNo = ordergenerator++;
        rs = queryrunner("insert Into Order(InvoiceNo,OrderNo,user_id,Amount_paid,Date) values (" + invoiceNo + ","  + orderNo + "," + input + "," + total +  "," + dtf.format(now));
        rs = queryrunner("insert Into Tracking(OrderNo,Estimatedtime,Location) values (" + orderNo + ", 0 , N/A");
    }

}else if(("r").compareTo(input) == 0){
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
    rs = queryrunner("insert Into User(Userid,Firstname,Lastname,email,password) values (" + input +  "," + firstname+ "," + lastname + "," + email + "," + pass);;
   this.checkout();
}

}
public void clearcart(){
cart.clear();
}
public void trackorder() throws SQLException {
    String input;
    System.out.println("Please Input the OrderNo");
    input = obj.nextLine(); 
    rs = queryrunner("select * from Tracking where OrderNo = " + input + " group by OrderNo,Estimated time,Location");   
    System.out.println(rs.getInt("OrderNo") + ", N/A , N/A ");
    System.out.println("choose 't' to track another order, 's' to shop, or 'e' to exit");
    input = obj.nextLine();
    if(("t").compareTo(input) == 0){ this.trackorder();}
    else if(("s").compareTo(input) == 0){
        try {
            this.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
private void selectquery(String type,String value, int add){
    ResultSet resultSet;
    try {
         resultSet = st.executeQuery("select *  from Book" + "where " + type + "= " + value + " group by Book_ISBN,Book_name,Author,Edition,Category,Price");
         while(resultSet.next()){
            System.out.printf(resultSet.getInt("Book_ISBN") + "," + resultSet.getString("Book_name")+ "," + resultSet.getString("Author")+ ","+resultSet.getString("Edition")+ "," +resultSet.getString("Category")+ "," +resultSet.getString("Price"));
            if(add == 1){
                Book b = new Book(resultSet.getInt("Book_ISBN"),resultSet.getString("Book_name"),resultSet.getInt("Price"),resultSet.getString("Author"),resultSet.getInt("Edition"),resultSet.getString("Category"),resultSet.getInt("Percentage"),resultSet.getInt("CopiesLeft"));
                cart.add(b);  
            }
            }
    } catch (Exception e) {
        System.out.println("Error happened");
    }

   
}
private ResultSet queryrunner(String query){
    try {rs = st.executeQuery(query);} 
    catch (Exception e) { System.out.println("Error happened"); return null;} 
    return rs;}
}