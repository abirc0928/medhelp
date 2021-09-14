package com.abir.medhelp.medicine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abir.medhelp.entity.MedicineEntity;

@Service
public class MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;

	public List<MedicineEntity> getAllMedicine() {
		List<MedicineEntity> result = new ArrayList<MedicineEntity>();
		Iterable<MedicineEntity> list = medicineRepository.findAll();
		list.forEach(result::add);
		return result;
	}
}
