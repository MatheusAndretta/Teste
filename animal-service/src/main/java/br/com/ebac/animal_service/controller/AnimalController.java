package br.com.ebac.animal_service.controller;

import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ebac.animal_service.domain.Animal;
import br.com.ebac.animal_service.repository.AnimalRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalRepository repository;

    @GetMapping
    private List<Animal> findAll() {
        return repository.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal) {
        return repository.save(animal);
    }
    
    // Retorna uma lista de animais do tipo Gato
    @GetMapping("/gatos")
    public List<Animal> getCat() {
        return repository.findAllCat("Gato");
    }

    // Retorna uma lista de animais do tipo AVE
    @GetMapping("/aves")
    public List<Animal> getBird() {
        return repository.findAllCat("Ave");
    }

    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted() {
        return repository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted() {
        return repository.findAdopted();
    }

    // Retorna o nome de todos os recebedores e a quantidade de resgates, ordenados pela quantidade em ordem decrescente.
    @GetMapping("/resgates")
    public List<Object[]> regastes() {
        return repository.foundByReceiver();
    }
    
    /**
     * Retorna a contagem de animais resgatados por recebedores a partir de uma data específica.
     *
     * @param dataInicio A data a partir da qual os resgates são contabilizados.
     *
     * @example Exemplo de uso:
     * {@code
     * GET /animais/regaste_por_data?dataInicio=2023-01-01}
     */
    @GetMapping("/regaste_por_data")
    public List<Object[]> regastesData(@RequestParam Date dataInicio) {
        return repository.foundByReceiverDate(dataInicio);
    }

}
