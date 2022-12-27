package demo.tricentis.demowebshop.model;

import org.python.antlr.ast.Str;

public class Person {
    private String gender;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Person(String gender, String firstName, String lastName, String email, String password) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
