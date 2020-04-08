
public class Book {
    private final int isbn;
    private final String title;
    private final int price;
    private final String author;
    private final int edition;
    private final String genre;
    private final int percentage;
    private final int copiesleft;

    public Book( final int isbn, final String title, final int price, final String author, final int edition,
            final String genre, final int percentage, final int copiesleft) {
    this.isbn = isbn;
    this.title = title;
    this.price = price;
    this.author = author;
    this.edition = edition;
    this.genre = genre;
    this.percentage = percentage;
    this.copiesleft = copiesleft;
    }
    public int getisbn(){return isbn;}
    public int getprice(){return price;}
    public int getedition(){return edition;}
    public int getpercentage(){return percentage;}
    public int getcopiesleft(){return copiesleft;}
    public String getauthor(){return author;}
    public String gettitle(){return title;}
    public String getgenre(){return genre;}

    public String tostring(){return "Book Details ISBN:" + isbn +", Title:" + title + ", Author:" + author + ", Edition:" + edition + ", Genre:" + genre + ", Price" + price;}
    public void printdetails(){System.out.println(tostring());}
}