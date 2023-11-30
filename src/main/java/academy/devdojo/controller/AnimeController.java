package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"/v1/animes", "/v1/animes/"})
public class AnimeController {

    @GetMapping
    public List<Anime> list() {
        return Anime.animesList();
    }

    @GetMapping("filterName")
    public Anime findByName(@RequestParam(value = "name") String name) {
        return Anime.animesList().stream().filter(anime -> anime.getName().equalsIgnoreCase(name)).findFirst().orElse(new Anime());
    }

    @GetMapping("/{id}")
    public Anime findById(@PathVariable(value = "id") Long id) {
        return Anime.animesList().stream().filter(anime -> anime.getId().equals(id)).findFirst().orElse(new Anime());
    }
}
