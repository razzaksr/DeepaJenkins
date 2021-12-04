package deploy.deepa.DeepaJenkinsDeployment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ForumWebserviceController 
{
	@Autowired
	JpaService service;
	
	@GetMapping("/")
	public List<Forum> getAll()
	{
		return service.every();
	}
	
	@GetMapping(value = "/xml",produces = "application/xml")
	public List<Forum> getXml()
	{
		return service.every();
	}
	
	@GetMapping("/one/{id}")
	public Forum each(@PathVariable("id") Integer id)
	{
		return service.reachOne(id);
	}
	
	@PostMapping("/add")
	public String add(@RequestBody Forum forum)
	{
		return service.inserting(forum);
	}
	
	@PostMapping(value="/addxml",consumes = "application/xml")
	public String adding(@RequestBody Forum forum)
	{
		return service.inserting(forum);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Forum forum)
	{
		return service.inserting(forum);
	}
	
	@DeleteMapping("/del")
	public String remove(@RequestBody Forum forum)
	{
		return service.eraseObject(forum);
	}
	
	@DeleteMapping("/del/{id}")
	public String remove(@PathVariable("id") Integer id)
	{
		return service.eraseOne(id);
	}
}
