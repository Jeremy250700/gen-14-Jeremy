/**
 * 
 */
package com.prodemy.mahasiswa;

import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jeremy
 *
 */
@Controller
public class MahasiswaController {
	@Autowired
	private MahasiswaService service;
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	@RequestMapping("/listData")
	public String display() {
		return "index";
	}
	
	@RequestMapping("/new")
	public String newMahasiswaForm(Map<String, Object> model) {
		model.put("mahasiswa", new Mahasiswa());
		return"new_mahasiswa";
	}
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String saveMahasiswa(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa) {
		service.save(mahasiswa);
		return "redirect:/home";
	}
	@GetMapping("/edit/{nim}")
	public String editMahasiswaForm(@PathVariable(value="nim") String nim, Model model) {
		Mahasiswa mahasiswa = service.get(nim);
		model.addAttribute("mahasiswa", mahasiswa);
		return "edit_mahasiswa";
	}
	@GetMapping("/delete/{nim}")
	public String deleteMahasiswa(@PathVariable(value="nim") String nim) {
		service.delete(nim);
		return "redirect:/home";
	}
	@RequestMapping("/search")
	public String search(@RequestParam String keyword, Model model) {
		List<Mahasiswa> result = service.search(keyword);
		model.addAttribute("result",result);
		return "search";
	}
}
