package br.com.DanDev.spring_boot_essentials.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hello")
public class HelloWorldController {


//    @GetMapping
//    public String HelloWorld(){
//        return "Hello World";
//    }

//    @GetMapping
//    public ResponseEntity<String> helloWorld(){
//        return ResponseEntity.ok("Hello World");
//    }

//    @GetMapping
//    public ResponseEntity<String> helloWorld(){
//        return new ResponseEntity<>("Hello World", HttpStatus.OK);
//    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String get(@PathVariable("id") String id){ // Path parametros sao obrigatorios por padrao
        return "Hello World " + id;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String get1(@RequestParam(value = "name", required = true) String name){ //Request parametros dependen do required para serem obrigatorios(True) ou nao(False)
        return "Hello World " + name;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody String name){
        return "Hello World " + name;
    }
}
