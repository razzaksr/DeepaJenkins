package basics.deepa.spring.DeepaSpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/basic")
public class BasicController 
{
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String base()
	{
		return "hey";
	}
	
	@RequestMapping(value="/{phrase}",method = RequestMethod.GET)
	public String base(@PathVariable("phrase") String phrase, Model model)
	{
		model.addAttribute("data", phrase);
		return "hai";
	}
}
