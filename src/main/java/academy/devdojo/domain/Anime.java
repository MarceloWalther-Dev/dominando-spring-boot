package academy.devdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Anime {

    private Long id;

    private String name;

    private static List<Anime> animesList = new ArrayList<Anime>();

    static {
        var anime1 = new Anime(1L, "Naruto");
        var anime2 = new Anime(2L, "Dragon Ball");
        var anime3 = new Anime(3L, "Pokemon");
        var anime4 = new Anime(4L, "Shurato");
        animesList.addAll(List.of(anime1, anime2, anime3, anime4));
    }

    public static List<Anime> getAnimesList() {
        return animesList;
    }
}
