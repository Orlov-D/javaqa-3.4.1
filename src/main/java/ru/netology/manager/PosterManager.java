package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.PosterRepository;

public class PosterManager {
    PosterRepository repository;

    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getAll() {
        Movie[] items = repository.findAll();
        Movie[] result = new Movie[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
