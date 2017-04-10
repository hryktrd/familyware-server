package info.familyware.domain;

import javax.persistence.*;

import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
public class Family {
	
	private Long id;

	@NotNull
	@Size(min=1, max=255)
	private String name;
	
	private Set<User> users;
	
//	public Family(){
//		
//	}
//	
//	public Family(String name){
//		this.name = name;
//	}
//	
//	public Family(String name, Set<User> users){
//		this.name = name;
//		this.users = users;
//	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(mappedBy="families")
	@JsonBackReference
	public Set<User> getUsers() {
		return this.users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
