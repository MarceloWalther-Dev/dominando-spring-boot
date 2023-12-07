package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import academy.devdojo.mapper.AnimeMapper;
import academy.devdojo.request.AnimePostRequest;
import academy.devdojo.response.AnimeGetResponse;
import academy.devdojo.response.AnimePostResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"/v1/animes", "/v1/animes/"})
public class AnimeController {

    private final AnimeMapper mapper = AnimeMapper.INSTANCE;

    @GetMapping
    public List<AnimeGetResponse> list() {
        return mapper.toAnimesGetResponses(Anime.getAnimesList());
    }

    @GetMapping("filterName")
    public ResponseEntity<AnimeGetResponse> findByName(@RequestParam(value = "name") String name) {
        var animeEntity = Anime.getAnimesList().stream().filter(anime -> anime.getName().equals(name))
                .findFirst().orElse(null);
        return ResponseEntity.ok(mapper.toAnimeGetResponse(animeEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimeGetResponse> findById(@PathVariable(value = "id") Long id) {
        var animeEntity = Anime.getAnimesList()
                .stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElse(null);
        return ResponseEntity.ok(mapper.toAnimeGetResponse(animeEntity));
    }

    @PostMapping
    public ResponseEntity<AnimePostResponse> save(@RequestBody AnimePostRequest request) {
        var anime = mapper.toAnime(request);
        Anime.getAnimesList().add(anime);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(mapper.toAnimePostResponse(anime));
    }
}
