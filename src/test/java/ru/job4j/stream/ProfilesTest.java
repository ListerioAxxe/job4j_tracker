package ru.job4j.stream;

import org.junit.Test;
import ru.job4j.stream.profiles.Address;
import ru.job4j.stream.profiles.Profile;
import ru.job4j.stream.profiles.Profiles;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfilesTest {
    @Test
    public void whenDifferentAddresses() {
        Profiles func = new Profiles();
        List<Address> expect = List.of(
                new Address("Moscow", "Biruz", 55, 3),
                new Address("Kerch", "Vorosh", 30, 3),
                new Address("Saratov", "Koroleva", 11, 1)
        );
        List<Profile> input = expect.stream()
                .map(Profile::new)
                .collect(Collectors.toList());
        List<Address> rsl = func.collect(input);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenSameAddresses() {
        Profiles func = new Profiles();
        List<Address> list = List.of(
                new Address("Moscow", "Biruz", 30, 3),
                new Address("Kerch", "Vorosh", 30, 3),
                new Address("Saratov", "Koroleva", 12, 1)

        );
        List<Profile> input = list.stream()
                .map(Profile::new)
                .collect(Collectors.toList());
        List<Address> expect = List.of(
                new Address("Moscow", "Biruz", 30, 3),
                new Address("Kerch", "Vorosh", 30, 3),
                new Address("Saratov", "Koroleva", 12, 1)

        );
        List<Address> rsl = func.collect(input);
        assertThat(rsl, is(expect));
    }
}