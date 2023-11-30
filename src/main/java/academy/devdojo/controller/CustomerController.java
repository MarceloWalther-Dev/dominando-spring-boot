package academy.devdojo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/v1/customers/", "v1/cusmotes"})
public class CustomerController {

    public static final List<String> NAMES = List.of("Marcelo", "Theo", "Arthur");

    @GetMapping("filters")
    public List<String> filters(@RequestParam String name){
        return NAMES.stream().filter(n -> n.equalsIgnoreCase(name)).toList();
        //http://localhost:8080/v1/customers/filters?name=marcelo
    }

    @GetMapping("filter")
    public List<String> filter(@RequestParam(defaultValue = "") String name){
        return NAMES.stream().filter(n -> n.equalsIgnoreCase(name)).toList();
        //http://localhost:8080/v1/customers/filter?name=marcelo
        //http://localhost:8080/v1/customers/filter
    }


    @GetMapping("filterOptional")
    public List<String> filter(@RequestParam Optional<String> name){
        return NAMES.stream().filter(n -> n.equalsIgnoreCase(name.orElse(""))).toList();
        //http://localhost:8080/v1/customers/filterOptional?name=marcelo
    }

    @GetMapping("filterList")
    public List<String> filter(@RequestParam(name = "name") List<String> names){
        return NAMES.stream().filter(names::contains).toList();
        //http://localhost:8080/v1/customers/filterList?name=Marcelo&name=Arthur
        //http://localhost:8080/v1/customers/filterList?name=Marcelo,Arthur
    }

    @GetMapping("{name}")
    public String findByName(@PathVariable String name){
        return NAMES.stream()
                .filter(n -> n.equalsIgnoreCase(name))
                .findFirst()
                .orElseGet(() -> "Nome não encontrado");
    }
}
