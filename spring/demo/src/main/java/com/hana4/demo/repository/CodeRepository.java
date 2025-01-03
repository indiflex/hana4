package com.hana4.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.hana4.demo.entity.Code;

public interface CodeRepository extends JpaRepository<Code, Integer>, QuerydslPredicateExecutor<Code> {
	List<Code> findFirstByOrderById(Pageable pageable);

	List<Code> findFirstByCodeInfoNotNull(Pageable pageable);

	List<Code> findByCodeUsersNotEmpty();

	List<Code> findBySubcodesIsNotEmpty();

	Optional<Code> findByCodeName(String codeName);
}
