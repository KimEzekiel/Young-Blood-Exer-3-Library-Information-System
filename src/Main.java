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
	int year;
	Library myLib = new Library("my Library");
	User user = new User("user", "user", myLib);

	/**/
	do{
		System.out.print("[1].BorrowBook\n[2].Return Book\n[3].View Books in the Library\n[4].View your borrowed books\n[5]Add book to library\n[0]Exit\nchoice: " );
		choice = numScan.nextInt();
		switch(choice){
			case 1:	//borrow a book
				System.out.println("Input book title");
				bookTitle = strScan.nextLine();
				user.borrowBook(bookTitle);
				break;
			case 2:	//return a book
				System.out.println("Input book title");
				bookTitle = strScan.nextLine();
				user.returnBook(bookTitle);
				break;
			case 3:	//show book collection
				myLib.showBookCollection();
				break;
			case 4:	//view borrowed books
				user.showBorrowedBooks();
				break;
			case 5:
				System.out.print("input title: " );
				bookTitle = strScan.nextLine();
				System.out.print("input author: " );
				author = strScan.nextLine();
				System.out.print("input year: " );
				year = numScan.nextInt();
				System.out.print("input type: " );
				type = strScan.nextLine();
				Book newBook = new Book(bookTitle, author, year, type);
				myLib.addBook(newBook);
				break;
			default:
				break;

		}
	}while(choice != 0);


    //let user borrow a book
    //let user return a book

    //view book in library
    //view borrowed books in library
    //save borrowedBooks before exit
    //save library hashmap before exit
    //save library hashmap before exi

  }
}
