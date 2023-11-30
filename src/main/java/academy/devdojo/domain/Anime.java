package academy.devdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Anime {

    private Long id;

    private String name;

    public static List<Anime> animesList(){
        var anime1 = new Anime(1L, "Naruto");
        var anime2 = new Anime(2L, "Dragon Ball");
        var anime3 = new Anime(3L, "Pokemon");
        var anime4 = new Anime(4L, "Shurato");
        return List.of(anime1, anime2, anime3, anime4);
    }
}
