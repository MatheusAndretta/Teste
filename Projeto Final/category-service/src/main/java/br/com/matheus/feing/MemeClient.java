package br.com.matheus.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "meme-service", url = "http://localhost:8083/meme")
public interface MemeClient {

@GetMapping("/{id}/exists")
Boolean userExists(@PathVariable("id") String userID);

}
