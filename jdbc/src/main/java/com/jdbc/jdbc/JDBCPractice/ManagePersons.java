package com.jdbc.jdbc.JDBCPractice;

import com.jdbc.jdbc.JDBCPractice.domain.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ManagePersons {
    public static void main(String[] args) {
/*
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

 */


        //Transactioanl -> We make more than one action with only one connection
        Connection connection = null;
        try {
            connection = Conn.getConnection();
            if (connection.getAutoCommit()){
                connection.setAutoCommit(false);  //Do not auto commit. By default is always true

                PersonJDBC personJDBC = new PersonJDBC(connection);

                Person person = new Person();
                person.setId_person(1);
                person.setName("ChanegdNameTransactional");
                person.setPhone("newphine");

                Person person1 = new Person();
                person1.setName("NewPerson");
                person1.setSurname("NewSurname");

                personJDBC.update(person);
                personJDBC.insert(person1);
                connection.commit(); //We set autoComit false. We must do it manualy

                personJDBC.select();

            }
            //if try block fails, we roll back all the actions we declared (inserts updates.....)
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Into rollback");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

    }
}
