package gui;

public class Main {

	public static void main(String[] args) {
		MainScreen ms = new MainScreen();
		ms.setVisible(true);

	}
	
	public static void OpenLogin() {
		Login l = new Login();
		l.setVisible(true);
	}

	public static void OpenRegister()  {
		Register r = new Register();
		r.setVisible(true);
	}
}
