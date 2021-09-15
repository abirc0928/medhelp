package com.abir.medhelp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abir.medhelp.entity.MedicineEntity;
import com.abir.medhelp.repository.MedicineRepository;

@Service
public class MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;

	public List<MedicineEntity> getAllMedicine() {
		return medicineRepository.findAll();
	}
}
