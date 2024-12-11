package br.com.matheus.repositories;

import java.util.List;
import java.util.Random;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.matheus.entities.Meme;

@Repository
public interface MemeRepository extends MongoRepository<Meme,String>{

    default Meme memeOfDay(){
        long count = count();
        int randomIdex = new Random().nextInt((int) count);
        List<Meme> memes = findAll(PageRequest.of(randomIdex, 1)).getContent();
        return memes.isEmpty() ? null : memes.get(0);
    }

}
