package pb;
import jakarta.persistence.*;


@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname,lastname,birthdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "people_id", referencedColumnName = "id")
    private Bank bank;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate
				+ ", bank=" + bank + "]";
	}

    
}
