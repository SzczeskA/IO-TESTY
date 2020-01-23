
public class Cassette {
	private int id;
	private String title;
	private int relaseDate;
	private char status;
	private String director;
	
	public Cassette(String title, int relaseDate, char status, String director) {
		super();
		this.title = title;
		this.relaseDate = relaseDate;
		this.status = status;
		this.director = director;
	}

	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id=i;
	}

	public String getTitle() {
		return title;
	}

	public int getRelaseDate() {
		return relaseDate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		if(status !='U' || status !='A')
			throw new Exception("Bad_StatusException");
		this.status = status;
	}

	public String getDirector() {
		return director;
	}
	
}
