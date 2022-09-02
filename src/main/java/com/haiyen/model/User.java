package com.haiyen.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;



@Entity
@Data
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(nullable = false, unique = true, length = 45)
	@NotEmpty
	@Email(message= "{errors.invalid_email}")
	private String email;
	
	@NotEmpty
	@Column(length = 15, name = "first_name")
	
	private String firstname;
	@Column(length = 15, name = "last_name")
	private String lastname;
	@Column(length = 15, nullable = false)
	private String password;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_role",
			joinColumns= {@JoinColumn(name = "USER_ID", referencedColumnName="ID")},
		    inverseJoinColumns = {@JoinColumn (name="ROLE_ID", referencedColumnName ="ID")}
			)
	
	private List<Role> roles;
	
	
	public User(User user) {
	
		this.id = user.getId();
		this.email = user.getEmail();
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}
	public User() {
		
	}
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
//				+ ", password=" + password + "]";
//	}
//	
	
	
	

}
