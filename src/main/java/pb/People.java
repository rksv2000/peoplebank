package pb;
import jakarta.persistence.*;

@Entity
public class People {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int person_id;
	private String First_Name,Last_Name,BirthDate;
	@OneToOne(cascade=CascadeType.ALL)
	private Bank bank;
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	@Override
	public String toString() {
		return "People [person_id=" + person_id + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name
				+ ", BirthDate=" + BirthDate + ", bank=" + bank + "]";
	}
	
}
