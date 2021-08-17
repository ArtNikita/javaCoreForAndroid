package ru.nikky.homework.homework10;

import java.util.HashMap;
import java.util.Map;

/**
 * Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get()
 * искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
 * (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 * Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
 * взаимодействие с пользователем через консоль и т.д). Консоль использовать только для
 * вывода результатов проверки телефонного справочника.
 */
public class PhoneBook {

    private HashMap<String, String> catalog = new HashMap<>();//<PhoneNumber, Surname>

    public void add(String phoneNumber, String surname){
        catalog.put(phoneNumber, surname);
    }

    public String get(String surname){
        StringBuilder sb = new StringBuilder(13);
        for (Map.Entry<String, String> entry : catalog.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(surname)){
                sb.append(entry.getKey()).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
