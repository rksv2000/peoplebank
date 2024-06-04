package pb;
import java.util.Objects;

import jakarta.persistence.*;


@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name, phonenumber;

    @OneToOne(mappedBy = "bank")
    private People people;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	@Override
	   public boolean equals(Object o) {
	       if (this == o) return true;
	       if (o == null || getClass() != o.getClass()) return false;
	       Bank bank = (Bank) o;
	       return Objects.equals(id, bank.id);
	   }

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + "]";
	}


    
}

