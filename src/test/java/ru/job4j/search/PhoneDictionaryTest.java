package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFNotFind() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Igor");
        assertThat(persons.size(), is(0));
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Evgen", "Kadenko", "534872", "Msk")
        );
        ArrayList<Person> persons = phones.find("Kadenko");
        assertThat(persons.size(), is(1));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Evgen", "Kadenko", "534872", "Msk")
        );
        ArrayList<Person> persons = phones.find("34872");
        assertThat(persons.size(), is(1));
    }

    @Test
    public void whenFindByAdres() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Evgen", "Kadenko", "534872", "Msk"));
        phones.add(new Person("Evgen", "Ivanovich", "35673", "Saratov"));
        ArrayList<Person> persons = phones.find("Saratov");
        assertThat(persons.size(), is(1));
    }
}