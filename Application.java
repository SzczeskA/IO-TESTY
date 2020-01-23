import java.util.ArrayList;

public class Application  {
	private ArrayList<Cassette> cassetteList = new ArrayList();
	private ArrayList<Cassette> tempCassetteList = new ArrayList();
	private ArrayList<Client> personList = new ArrayList();
	private ArrayList<Client> tempPersonList = new ArrayList();
	private int lastUsedCassId=1;
	private int lastUsedPersonId=1;
	
	public Application(ArrayList<Cassette> cassetteList,
			 ArrayList<Client> personList) {
		super();
		this.cassetteList = cassetteList;
		this.personList = personList;
	}


	public ArrayList<Cassette> getCassetteList() {
		return cassetteList;
	}

	public void setCassetteList(ArrayList<Cassette> cassetteList) {
		this.cassetteList = cassetteList;
	}

	public ArrayList<Cassette> getTempCassetteList() {
		return tempCassetteList;
	}

	public void setTempCassetteList(ArrayList<Cassette> tempCassetteList) {
		this.tempCassetteList = tempCassetteList;
	}

	public ArrayList<Client> getPersonList() {
		return personList;
	}

	public void setPersonList(ArrayList<Client> personList) {
		this.personList = personList;
	}

	public ArrayList<Client> getTempPersonList() {
		return tempPersonList;
	}

	public void setTempPersonList(ArrayList<Client> tempPersonList) {
		this.tempPersonList = tempPersonList;
	}
	public void main() {
	
		System.out.println("main");
	}
	public Boolean addPerson(char status,String name,String firstName, String idCardNum, String adress, String email, int phone, String haslo) {
		Client c = null;
		if(status =='C')
			c = new Client(name,firstName,idCardNum,adress,email,phone,haslo);
		if(status =='E')
			c= new Employee(name,firstName,idCardNum,adress,email,phone,haslo);
		if(status == 'A')
			c = new Admin(name,firstName,idCardNum,adress,email,phone,haslo);
		c.id = lastUsedPersonId;
		for(int i=0;i<personList.size();i++) {
			if(personList.get(i).getEmail()==c.getEmail()) {
				return false;
			}
		}
		lastUsedPersonId++;
		personList.add(c);
		return true;
	}
	public void addCassette(String title,int relaseDate, char status,String director) {
		Cassette c = new Cassette(title,relaseDate,status,director);
		c.setId(lastUsedCassId);
		lastUsedCassId++;
		cassetteList.add(c);
	}
	public void rentCass(int clientId, Cassette c) {
		tempCassetteList = searchCassette2(c);
		for(int i = 0; i<tempCassetteList.size();i++) {
			if(tempCassetteList.get(i).getStatus()=='A') {
				searchPerson(clientId).loanedCassettes.add(tempCassetteList.get(i));
				searchCassette(tempCassetteList.get(i).getId()).setStatus('U');
				break;
			}
		}
	}
	public void returnCass(int clientId, Cassette c) {
		tempCassetteList = searchPerson(clientId).getCassetteList();
		for(int i = 0; i<tempCassetteList.size();i++) {
			if(tempCassetteList.get(i).getId() == c.getId()) {
				searchPerson(clientId).loanedCassettes.remove(i);
				searchCassette(tempCassetteList.get(i).getId()).setStatus('A');
				break;
			}
		}
	}
	public Client searchPerson(int person_ID)
	{
		 for(int i=0;i<personList.size();i++)  
	       {  
			 	if(personList.get(i).getId()==person_ID)
			 		{return personList.get(i);}
	       }  
		 return null;
	}
	//wyszukaj wszystkie osoby zgodne ze wzorcem
	public ArrayList<Client> searchPerson2(Client person)
	{
		tempPersonList.addAll(personList);
		for(int index=0;index<tempPersonList.size();index++)  
	       {  
			 	if(tempPersonList.get(index).getId()!= person.id && person.id != 0)
					{tempPersonList.remove(index);}
			 	else if(tempPersonList.get(index).getName()!= person.name && person.name != null)
					{tempPersonList.remove(index);}
			 	else if(tempPersonList.get(index).getFirstName()!= person.firstName && person.firstName != null)
					{tempPersonList.remove(index);}
			 	else if(tempPersonList.get(index).getIdCardNum()!= person.idCardNum && person.idCardNum != null)
					{tempPersonList.remove(index);}
			 	else if(tempPersonList.get(index).getAdress()!= person.adress && person.adress != null)
					{tempPersonList.remove(index);}
			 	else if(tempPersonList.get(index).getEmail()!= person.email && person.email != null)
					{tempPersonList.remove(index);}
			 	else if(tempPersonList.get(index).getPhoneNum()!= person.phoneNum && person.phoneNum != 0)
					{tempPersonList.remove(index);}
	       }
		return tempPersonList;
	}
	
	//
	public Cassette searchCassette(int cassette_ID){
			 for(int i=0;i<cassetteList.size();i++)  
		       {  
				 	if(cassetteList.get(i).getId()==cassette_ID)
				 		{return cassetteList.get(i);}
		       }  
			 return null;
	}
	
	//wyszukaj wszystkie kasety zgodne ze wzorcem
	public ArrayList<Cassette> searchCassette2(Cassette cassete){
		tempCassetteList.addAll(cassetteList);
		for(int index=0;index<cassetteList.size();index++)  
	       {  
			  	if(cassetteList.get(index).getId()!= cassete.getId() || cassete.getId() != 0)
					{tempCassetteList.remove(index);}
			 	else if(cassetteList.get(index).getTitle()!= cassete.getTitle() || cassete.getTitle() !=null)
					{tempCassetteList.remove(index);}
			 	else if(cassetteList.get(index).getRelaseDate()!= cassete.getRelaseDate() || cassete.getRelaseDate()!= 'd')
					{tempCassetteList.remove(index);}
			 	else if(cassetteList.get(index).getStatus()!= cassete.getStatus() || cassete.getStatus()!= '0')
					{tempCassetteList.remove(index);}
			 	else if(cassetteList.get(index).getDirector()!= cassete.getDirector() || cassete.getDirector() != null)
					{tempCassetteList.remove(index);}
	       } 
		return tempCassetteList;
	}
	
	public char logowanie(String mail, String haslo)
	{	int temp = 0;
		String haslo2 = new String();
		Client c = new Client(null,null,null,null,mail,0,null);
		tempPersonList = searchPerson2(c);
		if(tempPersonList.size()>0) {
		haslo2 = tempPersonList.get(0).getHaslo();
		}else {
			return 'N';
		}
		if(haslo==haslo2) {
			return tempPersonList.get(0).getStatus();
		}
		
		return 'N';
	}
}
