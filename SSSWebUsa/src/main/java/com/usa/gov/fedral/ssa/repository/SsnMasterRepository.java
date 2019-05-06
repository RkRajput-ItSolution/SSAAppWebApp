package com.usa.gov.fedral.ssa.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usa.gov.fedral.ssa.entity.SsnMasterEntity;

@Repository("ssnMasterRepository")
public interface SsnMasterRepository extends JpaRepository<SsnMasterEntity, Serializable> {

	@Query("select ssn from SSN_MASTER")
	public Optional<SsnMasterEntity> findById(long ssn);

}
