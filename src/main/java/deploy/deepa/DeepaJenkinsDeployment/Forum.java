package deploy.deepa.DeepaJenkinsDeployment;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forum implements Serializable
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int forumId;
	private String name;
	private String technology;
	private int membersCount;
	private String head;
	private int productionHours;
	public Forum() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Forum(int forumId, String name, String technology, int membersCount, String head, int productionHours) {
		super();
		this.forumId = forumId;
		this.name = name;
		this.technology = technology;
		this.membersCount = membersCount;
		this.head = head;
		this.productionHours = productionHours;
	}
	public Forum(String name, String technology, int membersCount, String head, int productionHours) {
		super();
		this.name = name;
		this.technology = technology;
		this.membersCount = membersCount;
		this.head = head;
		this.productionHours = productionHours;
	}
	@Override
	public String toString() {
		return "Forum [forumId=" + forumId + ", name=" + name + ", technology=" + technology + ", membersCount="
				+ membersCount + ", head=" + head + ", productionHours=" + productionHours + "]";
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public int getMembersCount() {
		return membersCount;
	}
	public void setMembersCount(int membersCount) {
		this.membersCount = membersCount;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public int getProductionHours() {
		return productionHours;
	}
	public void setProductionHours(int productionHours) {
		this.productionHours = productionHours;
	}
}
