package academy.devdojo.response;

import academy.devdojo.domain.Producer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Builder
public class ProducerPostResponse {
    private Long id;
    private String name;

    public ProducerPostResponse(Producer producer) {
        this.id = producer.getId();
        this.name = producer.getName();
    }
}
