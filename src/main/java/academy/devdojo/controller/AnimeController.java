package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(path = {"/v1/animes", "/v1/animes/"})
public class AnimeController {


    @GetMapping
    public List<Anime> list() {
        return Anime.getAnimesList();
    }

    @GetMapping("filterName")
    public Anime findByName(@RequestParam(value = "name") String name) {
        return Anime.getAnimesList().stream().filter(anime -> anime.getName().equals(name))
                .findFirst().orElse(null);
    }

    @GetMapping("/{id}")
    public Anime findById(@PathVariable(value = "id") Long id) {
        return Anime.getAnimesList()
                .stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    @PostMapping
    public Anime save(@RequestBody Anime animeRequest){
        animeRequest.setId(ThreadLocalRandom.current().nextLong(100_000));
        Anime.getAnimesList().add(animeRequest);
        System.out.println(Anime.getAnimesList());
        return animeRequest;
    }
}
