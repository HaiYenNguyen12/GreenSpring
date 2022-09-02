package com.haiyen.api;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.haiyen.service.UserNotFoundException;
import com.haiyen.service.UserService;
import com.haiyen.model.*;

@Controller
public class UserController {
	
	@Autowired private UserService service;
	
	public UserController (UserService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public String showUserList(Model model) {
		List<User> list = service.listAll();
		model.addAttribute("listUsers",list);
		return "users";
	}

	@GetMapping("users/new")
	
	public String showNewForm (Model model) {
		model.addAttribute("user",new User());
		model.addAttribute("pageTittle", "Add A New User");
		return "user_form";
	}
	
	@PostMapping("users/save")
	public String saveUser (User user, RedirectAttributes ra) {
		service.save(user);
		ra.addFlashAttribute("mess", "The user has been saved successfully");
		return "redirect:/users";
		
	}
	
	@GetMapping("/users/edit/{id}")
	public String showEditForm(@PathVariable("id") Integer id, Model model,  RedirectAttributes ra) {
		try {
			   User user = service.get(id);
			model.addAttribute("user", user);
			model.addAttribute("pageTittle", "Update A User");
			return "user_form";
			
		} catch (UserNotFoundException e){
			ra.addFlashAttribute("mess", e.getMessage());
			return "redirect:/users";
		}
	}
	
	
	@GetMapping("/users/del/{id}") 
	 
	public String deleteUser (@PathVariable("id") Integer id,  RedirectAttributes ra) {
		try {
			service.delete(id);
			ra.addFlashAttribute("mess", "The user has been deleted successfully");
		}
		
		catch (UserNotFoundException e){
			ra.addFlashAttribute("mess", e.getMessage());
		}
		
				
		return "redirect:/users";
		
	}
	}
	


     

