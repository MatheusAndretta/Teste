package br.com.matheus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matheus.entities.Meme;
import br.com.matheus.feing.UserClient;
import br.com.matheus.repositories.MemeRepository;

@Service
public class MemeService {

    @Autowired
    private MemeRepository memeRepository;

    @Autowired
    private UserClient userClient;

    public Meme createMeme(Meme meme){
        if (!userClient.userExists(meme.getUserId())) {
            throw new IllegalArgumentException("Usuário não encontrado!");
        }
        return memeRepository.save(meme);
    }


    // public Meme createMeme(Meme meme){
    //     return memeRepository.save(meme);
    // }

    public List<Meme> getAllMemes(){
        return memeRepository.findAll();
    }

    public Meme getMemeById(String id){
        return memeRepository.findById(id).orElse(null);
    }

    public Meme updateMeme(Meme meme){
        return memeRepository.save(meme);
    }

    public Meme memeOfDay(){
        return memeRepository.memeOfDay();
    }

    public void deleteMeme(String id){
        memeRepository.deleteById(id);
    }

}
