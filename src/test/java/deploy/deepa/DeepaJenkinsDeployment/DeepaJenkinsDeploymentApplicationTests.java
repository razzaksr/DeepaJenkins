package deploy.deepa.DeepaJenkinsDeployment;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class DeepaJenkinsDeploymentApplicationTests {
	@MockBean
	ForumResposoitory repo;
	
	@Autowired
	JpaService serv;
	
	@Test
	public void testFindAll()
	{
		Forum for1=new Forum(12, "ML", "Python", 23, "Sobin", 45);
		Forum for2=new Forum(91, "DS", "Python", 45, "Adharsh", 90);
		Forum for3=new Forum(56, "MERN", "Javascript", 50, "Razak Mohamed", 60);
		Forum for4=new Forum(3, "Web", "Java", 44, "Rasheedha", 50);
		
		when(repo.findAll()).thenReturn(Stream.of(for1,for2,for3,for4).collect(Collectors.toList()));
		
		assertTrue(serv.every().size()>=4);
		
		//assertEquals(for3, serv.every().get(3));
	}
	
	@Test
	//@org.junit.Test(timeout = 00001)
	public void testAdding()
	{
		Forum for1=new Forum(12, "ML", "Python", 23, "Sobin", 45);
		Forum for2=new Forum(91, "DS", "Python", 45, "Adharsh", 90);
		Forum for3=new Forum(56, "MERN", "Javascript", 50, "Razak Mohamed", 60);
		Forum for4=new Forum(3, "Web", "Java", 44, "Rasheedha", 50);
		
		when(repo.save(for1)).thenReturn(for1);when(repo.save(for2)).thenReturn(for2);
		when(repo.save(for3)).thenReturn(for3);when(repo.save(for4)).thenReturn(for4);
		
		//assertSame(for2, serv.insertings(for1));
		assertNotSame(for2, serv.insertings(for1));
	}
	
	@Test
	public void getHai()
	{
		Forum for1=new Forum(12, "ML", "Python", 23, "Sobin", 45);
		Forum for2=new Forum(91, "DS", "Python", 45, "Adharsh", 90);
		Forum for3=new Forum(56, "MERN", "Javascript", 50, "Razak Mohamed", 60);
		Forum for4=new Forum(3, "Web", "Java", 44, "Rasheedha", 50);
		
		
		when(repo.getById(56)).thenReturn(for3);when(repo.getById(91)).thenReturn(for2);
		when(repo.getById(12)).thenReturn(for1);//when(repo.getById(3)).thenReturn(for4);
		
		
		//Assert.assertNull(serv.reachedOne(3));
		assertNotNull(serv.reachedOne(56));
		//assertNotNull(serv.reachedOne(3));
		
	}
	
	@Test
	public void testDelete()
	{
		Forum for1=new Forum(12, "ML", "Python", 23, "Sobin", 45);
		Forum for2=new Forum(91, "DS", "Python", 45, "Adharsh", 90);
		Forum for3=new Forum(56, "MERN", "Javascript", 50, "Razak Mohamed", 60);
		Forum for4=new Forum(3, "Web", "Java", 44, "Rasheedha", 50);
		
		when(repo.save(for1)).thenReturn(for1);when(repo.save(for2)).thenReturn(for2);
		when(repo.save(for3)).thenReturn(for3);
		
		assertEquals("MERN has deleted", serv.eraseObject(for3));
		
		//verify(repo,times(1)).delete(for4);
		
		
	}	

	@Test
	void contextLoads() {
	}

}
