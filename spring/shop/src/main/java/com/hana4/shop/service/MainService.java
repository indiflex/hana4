package com.hana4.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hana4.shop.dto.CustDTO;

@Service
public class MainService {
	public List<CustDTO> getCusts() {
		List<CustDTO> custs = new ArrayList<>();
		CustDTO cust = new CustDTO();
		cust.setId(1);
		cust.setName("Hong");
		cust.setTel("010-2222-3333");
		custs.add(cust);
		CustDTO cust2 = new CustDTO();
		cust2.setId(2);
		cust2.setName("김길동");
		cust2.setTel("010-2222-4444");
		custs.add(cust2);

		return custs;
	}
}
