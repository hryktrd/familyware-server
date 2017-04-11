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

import info.familyware.domain.FamilyUserKey;

@Entity(name="family_user")
@IdClass(value=FamilyUserKey.class)
public class FamilyUser {
	
	@Id
	@NotNull
	private Long family_id;
	
	@Id
	@NotNull
	private Long user_id;
	
	@NotNull
	private Boolean confirm; 
	
	public Long getFamily_id() {
		return family_id;
	}

	public void setFamily_id(Long family_id) {
		this.family_id = family_id;
	}
	
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Boolean getConfirm() {
		return confirm;
	}

	public void setConfirm(Boolean confirm) {
		this.confirm = confirm;
	}

	
}
