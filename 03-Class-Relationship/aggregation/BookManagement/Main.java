import java.util.List;

public class Main {



    class Book{

        private String title;
        private String author;

        public Book(String title,String author){
            this.title=title;
            this.author=author;

        }

        public String getTitle(){
            return title;
        }

        public String getAuthor(){
            return author;
        }
    }

    class Library{
        private String name;
        private List<Book> books;

        public Library(String name, List<Book> books){
             this.name=name;
             this.books=books;
        }

        public void showBooks(){
            System.out.println("Book available in " + name +"Library:");
            for(Book book:books){
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
            }
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
        
        Book b1 = main.new Book("Clean Code", "Robert Martin");
        Book b2 = main.new Book("The Pragmatic Programmer", "Andrew Hunt");
        List<Book> bookList = List.of(b1, b2);

        Library cityLibrary = main.new Library("City Library", bookList);
        cityLibrary.showBooks();
        
    }
    
}
