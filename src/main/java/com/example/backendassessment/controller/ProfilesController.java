package com.example.backendassessment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backendassessment.dao.ProfilesDao;
import com.example.backendassessment.models.Tbl_Profiles;

@Controller
public class ProfilesController {

	@Autowired
	ProfilesDao profilesDao;
	
	// Show all profiles
	@RequestMapping("/profiles")
	public String getProfiles(Model model) {
		List<Tbl_Profiles> profiles = profilesDao.findAll();
		model.addAttribute("profiles", profiles);
		
		return "profileList";
	}
	
	// Show update profile view
	@RequestMapping("/update-profile/{id}")
	public String updateProfile(Model model, @PathVariable int id) {
		int p_id = id;
		List<Tbl_Profiles> profiles = profilesDao.findById(p_id);
		model.addAttribute("profiles", profiles);
		
		return "updateProfile";
	}
	
	// Create profile in Database
	@PostMapping("/create-profile")
	public String createProfile(HttpServletRequest request,  @ModelAttribute Tbl_Profiles tbl_profiles) {
		profilesDao.save(tbl_profiles);
		return "redirect:/profiles";
	}
	
	// Update profile in Database
	@PostMapping("/update-profile-action")
	public String editProfile(HttpServletRequest request, @ModelAttribute Tbl_Profiles tbl_profiles){
		profilesDao.update(tbl_profiles);
		return "redirect:/profiles";
	}
	
	// Delete profile from Database
	@RequestMapping("/delete-profile/{id}")
	public String deleteProfile(@PathVariable int id) {
		int p_id = id;
		profilesDao.delete(p_id);
		
		return "redirect:/profiles";
	}
	
}
