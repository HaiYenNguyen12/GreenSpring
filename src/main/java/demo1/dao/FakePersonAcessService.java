package demo1.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import demo1.model.Person;


@Repository("fakeDao")
public class FakePersonAcessService implements PersonDao {

	private static List<Person> list = new ArrayList<>();
	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		list.add(new Person(id, person.getUsername()));
		return 1;
	}
	@Override
	public List<Person> allPerson() {
		// TODO Auto-generated method stub
		return list;
	}
	
	
	@Override
	public Optional<Person> selectPersonById(UUID id) {
		// TODO Auto-generated method stub
		return list.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}
	
	
	@Override
	public int deletePerson(UUID id) {
		Optional<Person> old_person = selectPersonById(id);
		if (!old_person.isEmpty()) {
			list.remove(old_person.get());
			return 1;
		}
		return 0;
	
	}


	@Override
	public int updatePerson(UUID id, Person person) {
		Optional<Person> old_person = selectPersonById(id);
		if (!old_person.isEmpty()) {
;
			int index = list.indexOf(old_person.get());
	
			if (index >= 0) {
				list.set(index, new Person(id, person.getUsername()));
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			return 0;
		}

	}
	
	

}
