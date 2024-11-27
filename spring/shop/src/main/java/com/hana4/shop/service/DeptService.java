package com.hana4.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hana4.shop.dao.DeptRepository;
import com.hana4.shop.dto.Dept;

@Service
public class DeptService {
	private final DeptRepository repository;

	public DeptService(DeptRepository repository) {
		this.repository = repository;
	}

	public List<Dept> getList() {
		return repository.getList();
	}

	public Dept find(Integer id) {
		return repository.find(id);
	}
}
