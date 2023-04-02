package hometask.jdbc.db;

import hometask.jdbc.Person;

import java.sql.*;
import java.util.ArrayList;

public class DBView {
    private static final String URL = "jdbc:mysql://localhost:3306/dictionary";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


    public void getAllPersons() {
        Connection connection = getConnection();
        ArrayList<Person> people = new ArrayList<>();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                people.add(new Person(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4)));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        people.forEach(person -> System.out.println(person.toString()));
    }

    public void getPersonOlderByAge(int personAge) {
        Connection connection = getConnection();
        ArrayList<Person> people = new ArrayList<>();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(
                    "SELECT * FROM person WHERE age >= " + personAge + "");
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                people.add(new Person(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4)));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (people.isEmpty()) {
            System.out.println("Person who older is " + personAge + " years old is not in the table.");
        } else {
            people.forEach(person -> System.out.println(person.toString()));
        }
    }

    public void getPersonByFirstName(String firstName) {
        Connection connection = getConnection();
        ArrayList<Person> people = new ArrayList<>();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(
                    "SELECT * FROM person WHERE firstName LIKE '%" + firstName + "%'");
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                people.add(new Person(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4)));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (people.isEmpty()) {
            System.out.println("Person who firstName is " + firstName + " not in the table.");
        } else {
            people.forEach(person -> System.out.println(person.toString()));
        }
    }

    public void getPersonById(Integer id) {
        Connection connection = getConnection();
        ArrayList<Person> people = new ArrayList<>();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(
                    "SELECT * FROM person WHERE id = " + id + "");
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                people.add(new Person(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4)));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (people.isEmpty()) {
            System.out.println("Person who id is " + id + " not in the table.");
        } else {
            people.forEach(person -> System.out.println(person.toString()));
        }
    }

    public void addPerson(Person person) {
        Connection connection = getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(
                    "INSERT INTO person (firstName, lastName, age) values(?,?,?)");
            prepareStatement.setString(1, person.getFirstName());
            prepareStatement.setString(2, person.getLastName());
            prepareStatement.setInt(3, person.getAge());
            prepareStatement.execute();
            connection.close();
            System.out.println("ADD PERSON - " + person.getFirstName() + " " + person.getLastName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePersonById(Integer id) {
        Connection connection = getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(
                    "DELETE FROM person WHERE id = " + id + "");
            int statementUpdate = prepareStatement.executeUpdate();
            connection.close();
            if (statementUpdate == 0) {
                System.out.println("Person does not exist in ID " + id);
            } else {
                System.out.println("DELETE PERSON - by id " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePerson(Person person) {
        Connection connection = getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(
                    "UPDATE person SET firstName = ?, lastName = ?, age = ? WHERE id = " + person.getId() + "");
            prepareStatement.setString(1, person.getFirstName());
            prepareStatement.setString(2, person.getLastName());
            prepareStatement.setInt(3, person.getAge());
            prepareStatement.executeUpdate();
            connection.close();
            System.out.println("UPDATE PERSON - " + person.getFirstName() + " " + person.getLastName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
