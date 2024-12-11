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

import br.com.matheus.entities.Category;
import br.com.matheus.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

        @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
   public ResponseEntity<Category> createUser(@RequestBody Category category){
    System.out.println("Categoria de nome: " + category.getNomeDaCategoria() + " Foi cadastrado com sucesso!" );
    return ResponseEntity.ok(categoryService.createCategory(category));
   }

    @GetMapping("/all")
    public List<Category> getAllUsers() {
        return categoryService.getAllCategorys();
    }

     @GetMapping("/get/{id}")
    public ResponseEntity<Category> getById(@PathVariable(value = "id")String id){
        System.out.println("Categoria de ID: " + id + "foi encontrado!");
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

     @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateUser(@RequestBody Category category){
        System.out.println("A categoria: " + category.getId() + " foi alterado com sucesso");
        return ResponseEntity.ok(categoryService.updateCategory(category));
    }

    @DeleteMapping("/del/{id}")
    public void deleteUser(@PathVariable(value = "id")String id){
        System.out.println("Categoria: " + id + " foi deletado com sucesso");
        categoryService.deleteCategory(id);
    }
   

}
