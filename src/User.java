public class User{
  ///attributes///
  private String name;
  ArrayList<Book> borrowedBooks;


  ///constants///


  ///constructor///
  public User(String name){
    this.name = name;
    this.borrowedBooks = new ArrayList<Book>();
  }

  ///methods///
  public void borrowBook(String bookTitle){
    /*1
    put in borrowedBooks
    remove book from library
    */

  }
  public void returnBook(String bookTitle){
    /*
    put book in library
    remove book from borrowedBooks
    */
  }


  ///setters///
  public void setName(String name){
    this.name = name;
  }


  ///getters///
  public String getName(){
    return this.name;
  }
}
