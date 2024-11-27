package com.hana4.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dept {
	private int id, pid, captain, depth;
	private String dname;

	public boolean getIsTop() {
		return this.pid == 0;
	}

	@Override
	public String toString() {
		return "Dept{" +
			"id=" + id +
			", pid=" + pid +
			", captain=" + captain +
			", depth=" + depth +
			", dname='" + dname + '\'' +
			'}';
	}
}
