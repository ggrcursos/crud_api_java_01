package com.crud.ApiCrud.controller;


//import com.crud.ApiCrud.entities.Client;
import com.crud.ApiCrud.dto.ClientDTO;
import com.crud.ApiCrud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @PostMapping("/save")
    public String save(@RequestBody ClientDTO cli){
        return service.save(cli);
    }

    @GetMapping("/getAll")
    public List<ClientDTO> getAll(){
        return service.selectAll();
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam long id){
        return service.delete(id);
    }
}
