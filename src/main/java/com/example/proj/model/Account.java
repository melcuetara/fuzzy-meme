package com.example.proj.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Account {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;
    private String userType;
    
    public Account(String firstName, String lastName, int age, String email, String password, String userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
    public Account() {

    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Account rhs = (Account) obj;
        return new EqualsBuilder() 
                .append(this.firstName, rhs.firstName)
                .append(this.lastName, rhs.lastName)
                .append(this.age, rhs.age)
                .append(this.email, rhs.email)
                .append(this.password, rhs.password)
                .append(this.userType, rhs.userType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder() 
                .append(firstName)
                .append(lastName)
                .append(age)
                .append(email)
                .append(password)
                .append(userType)
                .toHashCode();
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this) 
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("age",age)
                .append("email", email)
                .append("password", password)
                .append("userType", userType)
                .toString();
    }
}
