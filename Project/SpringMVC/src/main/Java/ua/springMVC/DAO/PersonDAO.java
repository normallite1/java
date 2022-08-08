package ua.springMVC.DAO;

import org.springframework.stereotype.Component;
import ua.springMVC.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static final String URL ="jdbc:postgresql://localhost:5432/postgres";
    private static final String USER_NAME ="postgres";
    private static final String PASS ="1111";

    private static Connection connection;

    static {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL,USER_NAME,PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonDAO(){

    }


    public List<Person> index(){
       List<Person> personList = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String SQL ="SELECT * FROM Persone";
            ResultSet resultSet = st.executeQuery(SQL);

            while (resultSet.next()){
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setMail(resultSet.getString("email"));

                personList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return personList;
    }

 public Person show(int id){
//        return personList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
     return null;
    }

    public void save(Person person){
        try {
            Statement st = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES("+1+",'"+person.getName()+
                    "',"+person.getAge()+",'"+person.getMail()+"')";

            st.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void update(int id, Person updatePerson){
//        Person personToBeUpdated = show(id);
//
//        personToBeUpdated.setName(updatePerson.getName());
//        personToBeUpdated.setAge(updatePerson.getAge());
//        personToBeUpdated.setMail(updatePerson.getMail());
    }
    public void delete(int id){
        //personList.removeIf(p -> p.getId() == id);
    }
}
