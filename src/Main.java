import library.Library;
import library.Book;
import java.util.Scanner;
public class Main{
  public static void main(String[] args) {
       Scanner strScan = new Scanner(System.in);
 	Scanner numScan = new Scanner(System.in);
 	int choice = 0;
 	String bookTitle;
 	String author;
 	String type;
 	String year;
 	Library myLib = new Library("my Library");
     myLib.loadLibrary();
 	User user = new User("user", "user", myLib);
     user.loadBorrowedBooks();
 	/**/
  System.out.println("=============================================================\n                  Welcome To Our Library ^_^");
 	do{
    System.out.println("=============================================================");
 		System.out.print("[1].BorrowBook\n[2].Return Book\n[3].View Books in the Library\n[4].View your borrowed books\n[5]Add book to library\n[0]Exit\n=============================================================\nchoice: " );
 		choice = numScan.nextInt();
 		switch(choice){
 			case 1:	//borrow a book
        System.out.println("\n-------------------------------------------------------------\n");
 				System.out.print("Input book title: ");
 				bookTitle = strScan.nextLine();
 				user.borrowBook(bookTitle);
        System.out.println("\n-------------------------------------------------------------\n");
 				break;
 			case 2:	//return a book
        System.out.println("\n-------------------------------------------------------------\n");
 				System.out.print("Input book title: ");
 				bookTitle = strScan.nextLine();
 				user.returnBook(bookTitle);
        System.out.println("\n-------------------------------------------------------------\n");
 				break;
 			case 3:	//show book collection
        System.out.println("\n-------------------------------------------------------------\n");
 				myLib.showBookCollection();
        System.out.println("-------------------------------------------------------------\n");
 				break;
 			case 4:	//view borrowed books
        System.out.println("\n-------------------------------------------------------------\n");
 				user.showBorrowedBooks();
        System.out.println("-------------------------------------------------------------\n");
 				break;
 			case 5:
        System.out.println("\n-------------------------------------------------------------\n");
 				System.out.print("Input title: " );
 				bookTitle = strScan.nextLine();
 				System.out.print("Input author: " );
 				author = strScan.nextLine();
 				System.out.print("Input year: " );
 				year = strScan.nextLine();
 				System.out.print("Input type: " );
 				type = strScan.nextLine();
 				Book newBook = new Book(bookTitle, author, year, type);
 				myLib.addBook(newBook);
        System.out.println("\n-------------------------------------------------------------\n");
 				break;
 			default:
 				break;

 		}
 	}while(choice != 0);
     myLib.saveLibrary();
     user.saveBorrowedBooks();
    //let user borrow a book
    //let user return a book
    //view book in library
    //view borrowed books in library
    //save borrowedBooks before exit
    //save library hashmap before exit
    //save library hashmap before exi

  }
}
