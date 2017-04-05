package library;

public class Book{
	private String id;
	private String title;
	private String author;
	private int year;
	private String type;
	static int bookNo=0;

	public Book( String title, String author,int year,String type){
		this.title = title;
		this. author = author;
		this.year= year;
		this.type=type;
		this.id= Integer.toHexString(bookNo);
		Book.bookNo++;
	}
	String getId(){
		return this.id;
	}
	String getTitle(){
		return this.title;
	}
	String getAuthor(){
		return this.author;
	}
	int getYear(){
		return this.year;
	}
	String getType(){
		return this.type;
	}
	void setId(String id){
		this.id = id;
	}
	void setTitle(String title){
		this.title = title;
	}
	void setAuthor(String author){
		this.author = author;
	}
	void setYear(int year){
		this.year = year;
	}
	void setType(String type){
		this.type = type;
	}





	
}