package com.jdbc.jdbc.JDBCPractice;

import com.jdbc.jdbc.JDBCPractice.domain.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonJDBC {

    //Transactional connection is used to not open and close a connection each time if we need to do different things
    //Declare what will be our transactioanlConn (a normal Connection)
    private Connection transactionalConn;

    private static final String SQL_SELECT = "SELECT id_person, name, surname, email, phone FROM person";
    private static final String SQL_INSERT = "INSERT INTO person(name, surname, email, phone) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE person SET name=?, surname=?, email=?, phone=? WHERE id_person = ?";
    private static final String SQL_DELETE = "DELETE FROM person WHERE id_person = ?";

    //For Transactional we need to add constructors
    public PersonJDBC(){

    }

    public PersonJDBC(Connection transactionalConn){
        this.transactionalConn = transactionalConn;
    }

    public List<Person> select() throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Person person = null;
        List<Person> persons = new ArrayList<>();

        try {
            conn = this.transactionalConn != null ? this.transactionalConn : Conn.getConnection(); //if transCon is not open, it will create single connection for this method
                                                                                    //otherwise wont use this private connection and will use transactional one
            preparedStatement = conn.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id_person = resultSet.getInt("id_person");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");

                person = new Person();
                person.setEmail(email);
                person.setName(name);
                person.setPhone(phone);
                person.setSurname(surname);

                persons.add(person);
            }
            //We took off catch exception bc testing transactional methods it must propagate the exception so the method transactional catches and process it
        } finally {
            if(this.transactionalConn == null){ //if we are not using transactional connection ->we are using private one and has to be close
            Conn.close(conn);
            }
            Conn.close(preparedStatement);
            Conn.close(resultSet);
        }
        return persons;
    }


    public int insert(Person person) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rows = 0;

        try {
            conn = this.transactionalConn != null ? this.transactionalConn : Conn.getConnection(); //if transCon is not open, it will create single connection for this method
            //otherwise wont use this private connection and will use transactional one
            preparedStatement = conn.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setString(4, person.getPhone());


            System.out.println("Execute query: " + SQL_INSERT);
            rows = preparedStatement.executeUpdate();
            System.out.println("Registers affecteds: " + rows);
            //We took off catch exception bc testing transactional methods it must propagate the exception so the method transactional catches and process it
        } finally {
            Conn.close(preparedStatement);
            if(this.transactionalConn == null){ //if we are not using transactional connection ->we are using private one and has to be close
                Conn.close(conn);
            }
        }
        return rows;
    }

    public int update (Person person) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {
            conn = this.transactionalConn != null ? this.transactionalConn : Conn.getConnection(); //if transCon is not open, it will create single connection for this method
            //otherwise wont use this private connection and will use transactional one
            System.out.println("executing query " + SQL_UPDATE);
            preparedStatement = conn.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setString(4, person.getPhone());
            preparedStatement.setInt(5, person.getId_person());

            rows = preparedStatement.executeUpdate();
            System.out.println("Registers updateds " + rows);
            //We took off catch exception bc testing transactional methods it must propagate the exception so the method transactional catches and process it
        } finally {
            Conn.close(preparedStatement);
            if(this.transactionalConn == null){ //if we are not using transactional connection ->we are using private one and has to be close
                Conn.close(conn);
            }
        }
        return rows;
    }

    public int delete(Person person) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {
            connection = this.transactionalConn != null ? this.transactionalConn : Conn.getConnection(); //if transCon is not open, it will create single connection for this method
            //otherwise wont use this private connection and will use transactional one
            System.out.println("Executing query " + SQL_DELETE);
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, person.getId_person());
            rows = preparedStatement.executeUpdate();
            System.out.println("Registers eliminated " + rows);
            //We took off catch exception bc testing transactional methods it must propagate the exception so the method transactional catches and process it
        }finally {
            Conn.close(preparedStatement);
            if(this.transactionalConn == null){ //if we are not using transactional connection ->we are using private one and has to be close
                Conn.close(connection);
            }
        }
        return rows;
    }
}
