package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class PosterRepositoryTest {
    PosterRepository posterRepository = new PosterRepository();

    Movie first = new Movie(1, "first", "ved1", "detective");
    Movie second = new Movie(2, "second", "ruby2", "horror");
    Movie tri = new Movie(3, "third", "ved3", "drama");

    @Test
    void save() {
        posterRepository.save(second);
        assertArrayEquals(new Movie[]{second}, posterRepository.findAll());
    }

    @Test
    void findById() {
        posterRepository.save(second);
        posterRepository.save(first);
        posterRepository.save(tri);

        assertEquals(first, posterRepository.findById(1));
    }

    @Test
    void removeById() {
        posterRepository.save(second);
        posterRepository.save(first);
        posterRepository.save(tri);

        posterRepository.removeById(1);

        assertArrayEquals(new Movie[]{second,tri}, posterRepository.findAll());
    }

    @Test
    void removeAll() {
        posterRepository.save(second);
        posterRepository.save(first);
        posterRepository.save(tri);

        posterRepository.removeAll();

        assertArrayEquals(new Movie[]{}, posterRepository.findAll());
    }
}