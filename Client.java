import java.util.ArrayList;
import java.util.List;

public class Client {
	private char status = 'C';
	List<Cassette> loanedCassettes = new ArrayList();
	protected int id;
	protected String name;
	protected String firstName;
	protected String idCardNum;
	protected String adress;
	protected String email;
	protected String haslo;
	protected int phoneNum;
	
	public Client(String name, String firstName, String idCardNum, String adress, String email, int phoneNum,String haslo) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.idCardNum = idCardNum;
		this.adress = adress;
		this.email = email;
		this.phoneNum = phoneNum;
		this.haslo=haslo;
	}
	
	public char getStatus() {
		return status;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getIdCardNum() {
		return idCardNum;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	
	public ArrayList<Cassette> getCassetteList() {
		ArrayList<Cassette> tempList = new ArrayList();
		for(int i = 0; i<loanedCassettes.size();i++) {
			tempList.add(loanedCassettes.get(i));
		}
		return tempList;
	}
	
	
}
