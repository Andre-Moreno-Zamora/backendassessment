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
import com.example.backendassessment.dao.UsersDao;
import com.example.backendassessment.models.Tbl_Profiles;
import com.example.backendassessment.models.Tbl_Users;

@Controller
public class UsersController {

	@Autowired
	UsersDao usersDao;
	
	@Autowired
	ProfilesDao profilesDao;
	
	// Show all users
	@RequestMapping("/users")
	public String getUsers(Model model) {
		List<Tbl_Users> users = usersDao.findAll();
		model.addAttribute("users", users);
		
		return "usersList";
	}
	
	// Show create users view
	@RequestMapping("/create-user")
	public String showCreateUser(Model model) {
		List<Tbl_Profiles> profiles = profilesDao.findAll();
		model.addAttribute("profiles", profiles);
		model.addAttribute("users", new Tbl_Users());
		
		return "createUser";
	}
	
	// Show update users view
	@RequestMapping("/update-user/{id}")
	public String showUpdateUser(Model model, @PathVariable int id) {
		int u_id = id;
		List<Tbl_Users> users = usersDao.findById(u_id);
		model.addAttribute("users", users);
		
		List<Tbl_Profiles> profiles = profilesDao.findAll();
		model.addAttribute("profiles", profiles);
		
		
		return "updateUser";
	}
	
	// Update user in Database
	@PostMapping("/update-user-action")
	public String updateUser(HttpServletRequest request,  @ModelAttribute Tbl_Users tbl_users) {
		usersDao.update(tbl_users);
		return "redirect:/users";
	}
	
	// Create user in Database
	@PostMapping("/create-user-action")
	public String createUser(HttpServletRequest request,  @ModelAttribute Tbl_Users tbl_users) {
		usersDao.save(tbl_users);
		return "redirect:/users";
	}
	
	// Delete user from Database
	@RequestMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable int id) {
		int u_id = id;
		usersDao.delete(u_id);
		return "redirect:/users";
	}
	
}
