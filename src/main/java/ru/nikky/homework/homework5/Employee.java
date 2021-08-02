package ru.nikky.homework.homework5;

public class Employee {

    private String fullName;
    private String position;
    private String eMail;
    private String phoneNumber;
    private int salary;
    private int age;

    Employee(String fullName, String position, String eMail, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    int getAge() {
        return age;
    }

    //по заданию нужно было реализовать метод а ля printInfo(),
    //но почему бы это не выводить информацию через toString() :)
    @Override
    public String toString() {
        return "Employee{" +
                "\n\tfullName='" + fullName + '\'' +
                ";\n\tposition='" + position + '\'' +
                ";\n\teMail='" + eMail + '\'' +
                ";\n\tphoneNumber='" + phoneNumber + '\'' +
                ";\n\tsalary=" + salary +
                ";\n\tage=" + age +
                ".\n}";
    }
}
