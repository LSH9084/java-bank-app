package bank.app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class BankApp {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Account> accounts = new ArrayList<Account>();
	static int cnt = 0;
	public static void main(String[] args) {
		while(true) {
			System.out.println("------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 ");
			System.out.println("------------------------------------------");
			System.out.print("선택>");
			int n = Integer.parseInt(scanner.nextLine());
			if(n==5) break;
			if(n==1) {
				createAccount();
			}
			if(n==2) {
				accountList();
			}
			if(n==3) {
				deposit();
			}
			if(n==4) {
				withdraw();
			}
		}
	}
	public static void createAccount() {
		System.out.println("-------------------계좌생성------------------");
		System.out.print("계좌번호: ");
		String acNo = scanner.nextLine();
		System.out.print("계좌주: ");
		String acName = scanner.nextLine();
		System.out.print("초기입금금액: ");
		String acBal = scanner.nextLine();
		System.out.println("결과: 계좌가 생성되었습니다.");
		Account account = new Account(acNo, acName, Integer.parseInt(acBal));
		accounts.add(account);
	}
	
	public static void accountList() {
		System.out.println("-------------------계좌목록------------------");
		accounts.forEach(System.out::println);
	}
	
	public static void deposit() {
		System.out.println("------------------- 예금 -------------------");
		System.out.print("계좌번호: ");
		String acNo = scanner.nextLine();
		System.out.print("예금액: ");
		String acBal = scanner.nextLine();
		System.out.println("결과: 예금이 성공되었습니다.");
		Account finding = findAccount(acNo);
		if(finding!=null) {
			int result = finding.getBalance()+Integer.parseInt(acBal);
			finding.setBalance(result);
		}
		accounts.set(cnt, finding);
	}
	
	public static void withdraw() {
		int result =0;
		System.out.println("------------------- 출금 -------------------");
		System.out.print("계좌번호: ");
		String acNo = scanner.nextLine();
		System.out.print("출금액: ");
		String acBal = scanner.nextLine();
		Account finding = findAccount(acNo);
		if(finding!=null) {
			result = finding.getBalance()-Integer.parseInt(acBal);
			if(result>=0) {
				System.out.println("결과: 출금이 성공되었습니다.");
				finding.setBalance(result);
			} else {
				System.out.println("잔액이 부족합니다.");
				result = finding.getBalance();
				finding.setBalance(result);
			}
			accounts.set(cnt, finding);
		}
	}
	public static Account findAccount(String ano) {
		Account selectedAccount = null;
		for(int i=0; i<accounts.size(); i++) {
			if(accounts.get(i).getAno().trim().equals(ano)) {
				selectedAccount = accounts.get(i);
				cnt = i;
			}
		}
		return selectedAccount;
	}
}
