package com.abir.medhelp.medicine;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abir.medhelp.entity.MedicineEntity;

@Repository
public interface MedicineRepository extends CrudRepository<MedicineEntity, Long>{

}
