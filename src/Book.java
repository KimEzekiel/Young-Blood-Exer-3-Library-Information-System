public class Book{
  //attributes
  private String title;
  private String id; // must be unique, decimal
  private String author;
  private int yearPublished;
  private String type; // could be "textbook","novel","dictionary","encyclopedia"

  //constants

  //constructor
  public Book(String title, String author, int yearPublished, String type){
    this.title = title;
    this.id;//di pa to tapos
    this.author = author;
    this.yearPublished = yearPublished;
    this.type = type;
  }

  //methods


  //setters
  public void setTitle(String title){
    this.title = title;
  }
  public void setID(String id){
    this.id = id;
  }
  public void setAuthor(String author){
    this.author = author;
  }
  public void setYearPublished(int yearPublished){
    this.yearPublished = yearPublished;
  }
  public void setType(String type){
    this.type = type;
  }

  //getters
  public String getTitle(){
    return this.title;
  }
  public String getID(){
    return this.id;
  }
  public String getAuthor(){
    return this.author;
  }
  public int getYearPublished(){
    return this.yearPublished;
  }
  public String getType(){
    return this.type;
  }
}
