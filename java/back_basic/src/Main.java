// javac Main.java ==> Main.class
// java Main 1 2 3
public class Main {
	public static void main(String[] args) {
		//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
		// to see how IntelliJ IDEA suggests fixing it.
		System.out.println("Hello and welcome!");
		int[] mons = {1, 3, 6, 9, 12, 24, 36, 48};
		int month = 12;
		int ret = 0;
		for (int i = mons.length - 1; i >= 0; i--) {
			if (month >= mons[i]) {
				ret = i;
				break;
			}
		}
		System.out.println("ret = " + ret + " : " + mons[ret]);

		for (int i = 1; i <= 5; i++) {
			//TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
			// for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
			System.out.println("i = " + i);
		}
	}
}
