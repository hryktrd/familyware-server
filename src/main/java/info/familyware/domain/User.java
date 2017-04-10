package info.familyware.domain;

import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import info.familyware.domain.Family;

@Entity
public class User {
	
	private Long id;
	
	@NotNull
	@Size(min=1, max=255)
	private String name;

	private Set<Family> families;
	
	@NotNull
	@Size(min=1, max=255)
	private	 String uuid;
	
//	public User(){
//		
//	}
//	
//	public User(String name, String uuid){
//		this.name = name;
//		this.uuid = uuid;
//	}
//	
//	public User(String name, String uuid, Set<Family> families){
//		this.name = name;
//		this.uuid = uuid;
//		this.families = families;
//	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getUuid() {
		return this.uuid;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name="family_user", joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"), inverseJoinColumns=@JoinColumn(name="family_id", referencedColumnName="id"))
	public Set<Family> getFamilies() {
		return this.families;
	}
	
	public void setFamilies(Set<Family> families){
		this.families = families;
	}

}
