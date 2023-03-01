package com.engeto.hotel;

import java.time.LocalDate;

public class Guest {

    ///region attributes
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    ///endregion

    ///region constructors
    public Guest(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
    ///endregion

    ///region getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    ///endregion

    ///region override
    @Override
    public String toString() {
        return "Guest: %s %s, (*) %s".formatted(this.name, this.surname, this.dateOfBirth.toString());
    }
    ///endregion


}
