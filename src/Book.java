package library;

import java.util.ArrayList;

public class Book{
	private String id;
	private String title;
	private String author;
	private int year;
	private String type;
	static int bookNo=0;

	public Book( String title, String author,String year,String type){
		this.title = title;
		this. author = author;
		this.year= Integer.parseInt(year);
		this.type=type;
		this.id= Integer.toHexString(bookNo);
		Book.bookNo++;

	}
	public String getId(){
		return this.id;
	}
	public String getTitle(){
		return this.title;
	}
	public String getAuthor(){
		return this.author;
	}
	public int getYear(){
		return this.year;
	}
	public String getType(){
		return this.type;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setAuthor(String author){
		this.author = author;
	}
	public void setYear(int year){
		this.year = year;
	}
	public void setType(String type){
		this.type = type;
	}

	public void showAllInfo(){
		System.out.println("############################################");
		System.out.println("Title: " + this.title);
		System.out.println("\tAuthor: " + this.author);
		System.out.println("\tYear: " + this.year);
		System.out.println("\tType: " + this.type);
		System.out.println("\tID: " + this.id);
		System.out.println("############################################\n");
	}
}
