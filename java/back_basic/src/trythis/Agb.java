package trythis;

public class Agb implements Gb {
	private String[] names;
	private String[] records;

	public Agb(String[] names, String[] records) {
		this.names = names;
		this.records = records;
		this.sort();
	}

	@Override
	public int size() {
		return this.names.length;
	}

	@Override
	public String names() {
		return String.join(" ", names);
	}

	@Override
	public String records() {
		StringBuilder sb = new StringBuilder();
		for (String str : this.records) {
			if (!sb.isEmpty()) {
				sb.append(" ");
			}
			sb.append(str);
		}
		return sb.toString();
	}

	@Override
	public boolean nameExist(String name) {
		for (String str : names) {
			if (str.equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(String name, String record) {
		if (nameExist(name)) {
			System.out.println(name + " : 이미 존재하는 이름입니다!");
			return;
		}
		int len = this.names.length;
		String[] newNames = new String[len + 1];
		String[] newRecords = new String[len + 1];
		int idx = 0;
		boolean didAdd = false;
		for (String nm : this.names) {
			if (!didAdd && name.compareTo(nm) < 0) {
				newNames[idx++] = name;
				newNames[idx++] = nm;
				didAdd = true;
			} else {
				newNames[idx++] = nm;
			}
		}
		System.out.println(name + ": idx = " + idx + ", len = " + len);
		if (!didAdd) {
			newNames[idx] = name;
		}

		this.names = newNames;
		this.records = newRecords;
	}

	@Override
	public void remove(String name, String record) {
		if (!this.nameExist(name)) {
			System.out.println(name + " : 존재하지 않는 이름입니다!");
			return;
		}
		int len = this.size();
		String[] newNames = new String[len - 1];
		int idx = 0;
		for (String nm : names) {
			if (nm.equals(name)) {
				continue;
			}
			newNames[idx++] = nm;
		}
		this.names = newNames;
	}

	@Override
	public String get(String name) {
		for (int i = 0; i < size(); i++) {
			if (names[i].equals(name)) {
				return records[i];
			}
		}
		return "";
	}

	@Override
	public void sort() {
		int len = this.size() - 1;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				if (names[j].compareTo(names[j + 1]) > 0) {
					String tmp = names[j];
					names[j] = names[j + 1];
					names[j + 1] = tmp;
				}
			}
		}
	}

	@Override
	public void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size(); i++) {
			if (!sb.isEmpty()) {
				sb.append('\n');
			} else {
				sb.append("----------------\n");
			}
			sb.append(names[i]).append(records[i]);
		}
		sb.append("\n---------------");

		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		String[] names = {"Mam", "Lee", "Nee"};
		String[] records = {"mmm", "lll", "nnn"};
		Agb agb = new Agb(names, records);
		agb.print();
		agb.add("Aaaa", "aaa");
		agb.add("Obaa", "aaa");
		agb.add("Oaaa", "aaa");
		agb.add("Paaa", "aaa");
		agb.add("Mlex", "aaa");
		agb.add("Noo", "aaa");
		agb.print();
		agb.add("Noo", "aaa");
		agb.print();
	}
}
