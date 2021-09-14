package com.abir.medhelp.medicine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.abir.medhelp.entity.MedicineEntity;

@Controller
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	@GetMapping("/buyMedicine")
	public String buyMedicine(Model model) {

		List<MedicineEntity> medicineList = medicineService.getAllMedicine();

		MedicineModel medicineForm = new MedicineModel();
		medicineForm.setMedicineList(medicineList);

		model.addAttribute("medicineForm", medicineForm);
		return "buyMedicine";
	}

	@PostMapping("/orderMedicine")
	public String orderMedicine(@ModelAttribute MedicineModel form) {
		System.out.println(form.getMedicineId());
		return "redirect:/home";
	}

}
