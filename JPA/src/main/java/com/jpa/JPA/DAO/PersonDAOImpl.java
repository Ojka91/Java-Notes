package com.jpa.JPA.DAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

import com.jpa.JPA.Entity.Person;

@Stateless
public class PersonDAOImpl implements PersonDAO{

    @PersistenceContext(unitName="PersonaPU")
    EntityManager em;

    @Override
    public List<Person> findAllPersonas() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Person findPersonaById(Person persona) {
        return em.find(Person.class, persona.getIdPersona());
    }

    @Override
    public Person findPersonaByEmail(Person persona) {
        Query query = em.createQuery("from Persona p where p.email =: email");
        query.setParameter("email", persona.getEmail());
        return (Person) query.getSingleResult();
    }

    @Override
    public void insertPersona(Person persona) {
        em.persist(persona);
    }

    @Override
    public void updatePersona(Person persona) {
        em.merge(persona);
    }

    @Override
    public void deletePersona(Person persona) {
        em.remove(em.merge(persona));
    }

}