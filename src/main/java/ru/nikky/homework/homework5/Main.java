package ru.nikky.homework.homework5;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("S. N. Bayrakovskiy", "Super puper developer",
                "superpuperdeveloper@mail.ru", "8-911-777-77-77", 3000000, 35);
        employees[1] = new Employee("N. A. Artamonov", "Junior Android developer",
                "nikitaartamonov@mail.ru", "8-911-000-00-00", 200000, 21);
        employees[2] = new Employee("V. V. Pupkin", "Senior Pomidor",
                "megaChel@mega.chel", "8-921-123-45-67", 1234567890, 69);
        employees[3] = new Employee("M. R. Twister", "Byvshiy ministr",
                "pochta@rf.ru", "8-112-111-01-02", 2300, 17);
        employees[4] = new Employee("V. V. Dyakov", "Middle IOS developer",
                "cool@man.ru", "8-931-000-00-00", 300000, 40);
        for (Employee employee : employees) {
            if (employee.getAge() >= 40)
                System.out.println(employee);
        }
    }
}
