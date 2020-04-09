import java.util.Scanner;

public class Owner {
    String input;
    Scanner obj = new Scanner(System.in);
    public void viewreport(){




        System.out.println("If you want to manage the books or add publishers please enter b if not enter q to end the application");
        input = obj.nextLine().toLowerCase();
        if(("b").compareTo(input) == 0){this.bookandpublishermanager();}
    }
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
        



        System.out.println("If you want to view the sales report please enter v if not enter q to end the application");
        input = obj.nextLine().toLowerCase();
        if(("v").compareTo(input) == 0){this.viewreport();}
    }
}