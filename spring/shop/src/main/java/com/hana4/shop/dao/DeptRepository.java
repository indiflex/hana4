package com.hana4.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hana4.shop.dto.Dept;

@Repository
@Mapper
public interface DeptRepository {
	List<Dept> getList();

	Dept find(Integer id);
}
