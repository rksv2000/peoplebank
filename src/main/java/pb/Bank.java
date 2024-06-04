package pb;
import jakarta.persistence.*;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bank_id;
	private String Bank_Name;
	private int Phone_Number;
	public int getBank_id() {
		return bank_id;
	}
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	public String getBank_Name() {
		return Bank_Name;
	}
	public void setBank_Name(String bank_Name) {
		Bank_Name = bank_Name;
	}
	public int getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(int phone_Number) {
		Phone_Number = phone_Number;
	}
	@Override
	public String toString() {
		return "Bank [bank_id=" + bank_id + ", Bank_Name=" + Bank_Name + ", Phone_Number=" + Phone_Number + "]";
	}
	
	
}
