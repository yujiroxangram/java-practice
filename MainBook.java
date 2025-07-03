class Book {
    //Fields
    private String title;
    private String author;
    private int year;

    //constructor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //utility method
    public boolean isOld() {
        return year < 1900;
    }

    //toString method
    public String toString() {
        return title + " by " + author + " (" + year + ")";
    }
}

public class MainBook {

    public static void main(String[] args) {
        //creating book objects
        Book book1 = new Book("A Letter To God", "G.L. Funetes", 1940);
        Book book2 = new Book("The Brook", "Lord Alfred Tennyson", 1855);

        //storing books in array
        Book book[] = {book1, book2};

        //Looping and printing
        for(Book b : book) {
            System.out.println(b.toString());
            if(b.isOld()) {
                System.out.println("This is an old classic! 😊👍");
            }
        }
    }
}