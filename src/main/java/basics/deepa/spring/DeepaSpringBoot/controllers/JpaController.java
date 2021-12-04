package basics.deepa.spring.DeepaSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import basics.deepa.spring.DeepaSpringBoot.entities.Forum;
import basics.deepa.spring.DeepaSpringBoot.repositories.ForumResposoitory;

@Controller
@RequestMapping("/jpa")
public class JpaController 
{
	@Autowired
	ForumResposoitory repo;
	
	@RequestMapping("/")
	public String yet()
	{
		return "change";
	}
	
	@RequestMapping("/insert")
	public void insertion()
	{
		Forum forum1=new Forum("ML", "Machine Learning", 35, "Vijayalakshmi", 35);
		System.out.println(repo.save(forum1)+" has saved");
	}
	
	@RequestMapping("/insertion/{nm}/{tech}/{count}/{incharge}/{hours}")
	public void insertions(@PathVariable("nm") String nm,@PathVariable("tech") String tech,@PathVariable("count") int count,@PathVariable("incharge") String incharge,@PathVariable("hours") int hours)
	{
		Forum forum1=new Forum(nm, tech, count, incharge, hours);
		System.out.println(repo.save(forum1)+" has saved");
	}
	
	@RequestMapping("/get/{id}")
	public void getSome(@PathVariable("id") int id)
	{
		System.out.println(repo.findById(id));
	}
	
	@RequestMapping("/gets/{count}")
	public void getSomeCount(@PathVariable("count") int count)
	{
		System.out.println(repo.findByMembersCount(count));
	}
	
	@RequestMapping("/geth/{count}")
	public void getSomeHours(@PathVariable("count") int count)
	{
		System.out.println(repo.findByProductionHours(count));
	}
	
	@RequestMapping("/getn/{count}")
	public void getNamesCount(@PathVariable("count") int count)
	{
		System.out.println(repo.gettingNamesByCount(count));
	}
	
}
