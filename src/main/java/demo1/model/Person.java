package demo1.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class Person {
	private final UUID id;
	
@NotBlank
	private final String username;
	public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String username) {
		this.id = id;
		this.username = username;
	}
	
//	public Person( @JsonProperty("name") String username) {
//		this.id =
//		this.username = username;
//	}
//	
	
	public UUID getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	
	

}
