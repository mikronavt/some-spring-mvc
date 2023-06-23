package ru.springcourse.dao;

import ru.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOOld {
    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = new ArrayList<>(List.of(new Person[]{new Person(++PEOPLE_COUNT, "Vasya", 17, "abraba@gmail.com"),
                new Person(++PEOPLE_COUNT, "Petya", 55, "bubub@yandex.ru"),
                new Person(++PEOPLE_COUNT, "Sasha", 33, "pepepe@mail.ru"),
                new Person(++PEOPLE_COUNT, "Vova", 77, "nunun@bubu.com")}));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToUpdate = show(id);
        personToUpdate.setName(updatedPerson.getName());
        personToUpdate.setAge(updatedPerson.getAge());
        personToUpdate.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }

}
