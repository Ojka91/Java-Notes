package com.jdbc.jdbc.JDBCPractice;

import com.jdbc.jdbc.JDBCPractice.domain.Person;

import java.util.List;

public class ManagePersons {
    public static void main(String[] args) {

        //Select
        PersonJDBC personJDBC = new PersonJDBC();
        List<Person> persons = personJDBC.select();

        for (Person person:persons) {
            System.out.println(person);
        }

        //Insert
        Person person = new Person();
        person.setName("Hey");
        person.setSurname("Hoy");
        person.setPhone("ojhas");
        person.setEmail("ewed");

        personJDBC.insert(person);


        //Update
        Person person1 = new Person();
        person.setId_person(3);;
        person.setName("NameChanged");
        person.setSurname("SurnameChanged");
        person.setEmail("email");
        person.setPhone("52524");

        personJDBC.update(person1);

        //Delete
        Person person2 = new Person();
        person2.setId_person(3);
        personJDBC.delete(person);
    }
}
