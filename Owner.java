
public class Owner {
    
    public void viewreport(){
        
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

}