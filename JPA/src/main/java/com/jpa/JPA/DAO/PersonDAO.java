package com.jpa.JPA.DAO;
import com.jpa.JPA.Entity.Person;

import java.util.List;

public interface PersonDAO {
    public List<Person> findAllPersonas();

    public Person findPersonaById(Person persona);

    public Person findPersonaByEmail(Person persona);

    public void insertPersona(Person persona);

    public void updatePersona(Person persona);

    public void deletePersona(Person persona);

}
