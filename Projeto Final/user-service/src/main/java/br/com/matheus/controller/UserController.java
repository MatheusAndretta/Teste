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

import br.com.matheus.entities.User;
import br.com.matheus.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
   public ResponseEntity<User> createUser(@RequestBody User user){
    System.out.println("Usuario: " + user.getNome() + " Foi cadastrado com sucesso!" );
    return ResponseEntity.ok(userService.createUser(user));
   }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

     @GetMapping("/get/{id}")
    public ResponseEntity<User> getById(@PathVariable(value = "id")String id){
        System.out.println("ID: " + id + "foi encontrado!");
        return ResponseEntity.ok(userService.getUserById(id));
    }

     @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        System.out.println("O usuario: " + user.getId() + " foi alterado com sucesso");
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/del/{id}")
    public void deleteUser(@PathVariable(value = "id")String id){
        System.out.println("Usuario: " + id + " foi deletado com sucesso");
        userService.deleteUser(id);
    }
   
}
