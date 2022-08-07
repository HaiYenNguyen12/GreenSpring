package demo1.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import demo1.model.Person;

public interface PersonDao {
	
	int insertPerson (UUID id, Person person) ;
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
	List<Person> allPerson();
	
	Optional<Person> selectPersonById (UUID id);
	
	int deletePerson (UUID id);
	
	int updatePerson (UUID id, Person person);
	

}
