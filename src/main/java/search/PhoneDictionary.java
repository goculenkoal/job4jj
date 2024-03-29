package search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей по ключу.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        if (key != null) {
            for (Person checkPerson : persons) {
                if (checkPerson.getName().contains(key)
                        || checkPerson.getSurname().contains(key)
                        || checkPerson.getPhone().contains(key)
                        || checkPerson.getAddress().contains(key)) {
                    result.add(checkPerson);
                }
            }
        }
        return result;
    }
}
