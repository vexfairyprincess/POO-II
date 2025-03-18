package org.samm.models;

public class Student {
    private String cif;
    private String name;
    private String surname;
    private String email;
    private String major;

    public Student() {
    }

    public Student(java.lang.String cif, java.lang.String name, java.lang.String surname, java.lang.String email, java.lang.String major) {
        this.cif = cif;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.major = major;
    }

    public java.lang.String getCif() {
        return cif;
    }

    public void setCif(java.lang.String cif) {
        this.cif = cif;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getSurname() {
        return surname;
    }

    public void setSurname(java.lang.String surname) {
        this.surname = surname;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getMajor() {
        return major;
    }

    public void setMajor(java.lang.String major) {
        this.major = major;
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.StringBuffer sb = new java.lang.StringBuffer("Student{");
        sb.append("cif=").append(cif);
        sb.append(", name=").append(name);
        sb.append(", surname=").append(surname);
        sb.append(", email=").append(email);
        sb.append(", major=").append(major);
        sb.append('}');
        return sb.toString();
    }
}

