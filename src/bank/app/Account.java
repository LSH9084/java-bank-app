package bank.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Account {
	private String ano;
	private String owner;
	private int balance;
	
	@Override
	public String toString() {
		return ano+" "+owner+" "+balance;
	}
}
