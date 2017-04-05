import  library.Library;
import library.Book;
public class User{
  //attributes
  private String name;
  Book borrowedBooks[];// gagawin pang array list


  //constants


  //constructor


  //methods
  public void borrowBook(String bookTitle){
    /*
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


  //setters
  public void setName(String name){
    this.name = name;
  }


  //getters
  public String getName(){
    return this.name;
  }
}
