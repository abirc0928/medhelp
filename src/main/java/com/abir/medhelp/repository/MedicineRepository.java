package com.abir.medhelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abir.medhelp.entity.MedicineEntity;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity, Long>{

}
