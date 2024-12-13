package org.example.Demo1;


import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class PersonController {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		// TODO Auto-generated method stub

		File file = new File("C:\\Users\\Qapitol QA\\eclipse-workspace\\Demo1\\Repository\\person1.yaml");
		
		Person person = new Person();
		Address address1 = new Address();
		Address address2 = new Address();
		Address address3 = new Address();

		address1.setStreeName("BTM");
		address1.setPincode(12345);
		address1.setCompleteAddr("Residential ");
		
		address2.setStreeName("HSR");
		address2.setPincode(1213345);
		address2.setCompleteAddr(" Permanant");
			
		address3.setStreeName("Indiranager");
		address3.setPincode(1213345);
		address3.setCompleteAddr(" Permanant");
		
		List<Address> listOfAddress = new LinkedList<Address>();
		listOfAddress.add(address1);
		listOfAddress.add(address2);
		listOfAddress.add(address3);
		person.setName("ABCD");
		person.setAge(10);
		person.setMbNo(1243655234);
		person.setAddr(listOfAddress);
		
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//		Person person = mapper.readValue(file, Person.class);
		

		
//		List<Person> listOfPerson = mapper.readValue(file, new TypeReference<LinkedList<Person>>(){});
		
//		listOfPerson.add(person);
		
//		System.out.println(listOfPerson);
		
		
//		System.out.println(person.toString());
		
//		mapper.writeValue();
		mapper.writerWithDefaultPrettyPrinter().writeValue(file, person);

//		System.out.println(person.toString());
		
		
	}

}
