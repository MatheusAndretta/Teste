package br.com.matheus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheus.entities.Meme;
import br.com.matheus.service.MemeService;

@RestController
@RequestMapping("/meme")
public class MemeController {

    @Autowired
    private MemeService memeService;

        @PostMapping("/create")
   public ResponseEntity<Meme> createUser(@RequestBody Meme meme){
    System.out.println("Meme: " + meme.getNome() + " Foi cadastrado com sucesso!" );
    return ResponseEntity.ok(memeService.createMeme(meme));
   }

    @GetMapping("/all")
    public List<Meme> getAllUsers() {
        return memeService.getAllMemes();
    }

     @GetMapping("/get/{id}")
    public ResponseEntity<Meme> getById(@PathVariable(value = "id")String id){
        System.out.println("ID do meme : " + id + "foi encontrado!");
        return ResponseEntity.ok(memeService.getMemeById(id));
    }

     @PutMapping("/update/{id}")
    public ResponseEntity<Meme> updateUser(@RequestBody Meme meme){
        System.out.println("O Meme: " + meme.getId() + " foi alterado com sucesso");
        return ResponseEntity.ok(memeService.updateMeme(meme));
    }

    @GetMapping("/memeday")
    public Meme memeOfDay(){
        System.out.println("Foi encontado um Meme aleatorio");
        return memeService.memeOfDay();
    }


    @DeleteMapping("/del/{id}")
    public void deleteMeme(@PathVariable(value = "id")String id){
        System.out.println("Meme: " + id + " foi deletado com sucesso");
        memeService.deleteMeme(id);
    }

}
