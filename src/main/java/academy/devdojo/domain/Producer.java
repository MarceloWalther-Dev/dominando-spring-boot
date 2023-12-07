package academy.devdojo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class Producer {

    private Long id;
    private String name;
    private LocalDateTime creatAt;
    private static List<Producer> producers = new ArrayList<Producer>();

    static {
        var anime1 = Producer.builder().id(1L).name("Naruto").creatAt(LocalDateTime.now()).build();
        var anime2 = Producer.builder().id(2L).name("Dragon Ball").creatAt(LocalDateTime.now()).build();
        var anime3 = Producer.builder().id(3L).name("Pokemon").creatAt(LocalDateTime.now()).build();
        var anime4 = Producer.builder().id(4L).name("Shurato").creatAt(LocalDateTime.now()).build();
        producers.addAll(List.of(anime1, anime2, anime3, anime4));
    }

    public static List<Producer> getProducers() {
        return producers;
    }
}
