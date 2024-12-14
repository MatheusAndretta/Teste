package br.com.matheus.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8081/api/user")
public interface UserClient {

@GetMapping("/{id}/exists")
Boolean userExists(@PathVariable("id") String userID);

}
