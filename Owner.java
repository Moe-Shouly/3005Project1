import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Owner {
    String input;
    Scanner obj = new Scanner(System.in);
    Statement st;
    public void viewreport(){




        System.out.println("If you want to manage the books or add publishers please enter b if not enter q to end the application");
        input = obj.nextLine().toLowerCase();
        if(("b").compareTo(input) == 0){this.bookandpublishermanager();}
    }
    public void getdb(Statement st){this.st = st;}
    public String addbook(Book b){
        return "insert INTO Book (Book_ISBN,BookName,Price,Author,Edition,Genre,Percentage,CopiesLeft) values (" + b.getisbn() + "," + b.gettitle() + "," + b.getprice() + "," + b.getauthor() + "," + b.getedition() + "," + b.getgenre() + "," + b.getpercentage() + "," + b.getcopiesleft() + ");";
    }
    public String deletebook(int isbn){
        return "Delete FROM Book where Book_ISBN =" + isbn + ";"; 
    }
    public String addpublisher(int Publisher_id,String FirstName,String LastName,String Email,int PhoneNo,int Address_id){
        return "insert INTO Publisher (Publisher_id,FirstName,LastName,Email,PhoneNo,Address_id) values (" + Publisher_id + ","  + FirstName + "," + LastName + "," + Email + "," + PhoneNo + "," + Address_id + ");";
    }
    public void bookandpublishermanager(){
        while(true){
        System.out.println("Welcome to the Bookstore manager if you want to add a book please press A and if you want to delete one press B.");
        input = obj.nextLine().toLowerCase();
        if(("a").compareTo(input) == 0){
            System.out.println("If the publisher doesnt exist enter N if the publisher exists then enter O");
            input = obj.nextLine().toLowerCase();
            if(("n").compareTo(input) == 0){

            }
            String[] details = new String[8];
                System.out.println("Please enter book details one by one starting with the book ISBN");
                for(int i = 0; i < 8;++i){
                    details[i] = obj.nextLine();
                }
                try {
                    ResultSet result = st.executeQuery("Input INTO Book (Book_ISBN,BookName,Price,Author,edition,Genre,)");
                    
                } catch (SQLException e) {
                    //TODO: handle exception
                }
                break;
        }
        else if(("b").compareTo(input) == 0){

            break;
        }
        }


        System.out.println("If you want to view the sales report please enter v if not enter q to end the application");
        input = obj.nextLine().toLowerCase();
        if(("v").compareTo(input) == 0){this.viewreport();}
    }
}