package basics.deepa.spring.DeepaSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import basics.deepa.spring.DeepaSpringBoot.entities.Forum;
import basics.deepa.spring.DeepaSpringBoot.services.JpaService;

@Controller
public class ForumController 
{
	@Autowired
	JpaService service;
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model)
	{
		Forum forum=service.reachOne(id);
		model.addAttribute("obj", forum);
		return "Edit";
	}
	
	@RequestMapping("/del/{id}")
	public String deletion(@PathVariable("id") Integer id,Model model)
	{
		String res=service.eraseOne(id);
		model.addAttribute("info",res);
		return home(model);
	}
	
	@RequestMapping("/home")
	public String home(Model model)
	{
		List<Forum> all = service.every();
		model.addAttribute("every", all);
		return "Home";
	}
	
	@RequestMapping("/new")
	public String newOne(Model model)
	{
		Forum forum=new Forum();
		model.addAttribute("object", forum);
		return "NewForm";
	}
	
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public String insert(Model model, Forum forum)
	{
		String res=service.inserting(forum);
		model.addAttribute("info", res);
		if(forum.getForumId()!=0)
		{
			return home(model);
		}
		else {
			return "NewForm";
		}
	}
}
