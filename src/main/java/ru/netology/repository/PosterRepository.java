package ru.netology.repository;

import ru.netology.domain.Movie;

public class PosterRepository {
    private Movie[] movies = new Movie[0];

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie item) {
        Movie[] tmp = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[tmp.length - 1] = item;
        movies = tmp;
    }

    public Movie findById(int id) {
        Movie[] tmp = new Movie[1];
        for (Movie item : movies) {
            if (item.getId() == id) {
                tmp[0] = item;
                break;
            } else {
                tmp[0] = null;
            }
        }
        return tmp[0];
    }

    public void removeById(int id) {
        Movie[] tmp = new Movie[movies.length - 1];
        int index = 0;
        for (Movie item : movies) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
//            Не нашёл взлетай на воздух! На лекции не сказали про исключение...
//            (╯ ° □ °) ╯ (┻━┻)
        }
        movies = tmp;
    }

    public void removeAll() {
        movies = new Movie[0];
    }


}
