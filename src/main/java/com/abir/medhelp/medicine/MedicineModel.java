package com.abir.medhelp.medicine;

import java.io.Serializable;
import java.util.List;

import com.abir.medhelp.entity.MedicineEntity;

public class MedicineModel implements Serializable {

	private long medicineId;
	private String medicineName;
	private double medicinePower;
	private int medicineQuantity;
	private List<MedicineEntity> medicineList;

	public long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(long medicineId) {
		this.medicineId = medicineId;
	}

	public List<MedicineEntity> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<MedicineEntity> medicineList) {
		this.medicineList = medicineList;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public double getMedicinePower() {
		return medicinePower;
	}

	public void setMedicinePower(double medicinePower) {
		this.medicinePower = medicinePower;
	}

	public int getMedicineQuantity() {
		return medicineQuantity;
	}

	public void setMedicineQuantity(int medicineQuantity) {
		this.medicineQuantity = medicineQuantity;
	}

}
