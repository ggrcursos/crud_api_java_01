package com.crud.ApiCrud.service;

import com.crud.ApiCrud.dto.ClientDTO;
import com.crud.ApiCrud.entities.Client;


import com.crud.ApiCrud.observability.SimpleLogger;
import com.crud.ApiCrud.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public class ClientService {

    private SimpleLogger logger = new SimpleLogger(ClientService.class);
    @Autowired
    private ClientRepository repo;
    @Autowired
    private  ModelMapper mapper;

    public String save(ClientDTO cli){

        String result =  "Client "+ cli.getName() + " not saved!" ;
        try{
            repo.save(mapper.map(cli, Client.class));
            result =  "Client "+ cli.getName() + " successfully saved!";
            return result;
        }catch (Exception e){
            logger.error(e.toString());
        }
        return result;
    }

    public String update(ClientDTO cli){
        String result= "Client "+ cli.getName() + " not updated!";
        try{
            repo.updateClientAgeByName(cli.getName(), cli.getAge());
            result= "Client "+ cli.getName() + " updated successfully!";
        }catch (Exception e){
            logger.error(e.toString());
        }

        return result;
    }

    public List<ClientDTO> selectAll(){
        try{
            return repo.findAll().stream()
                    .map(client->mapper.map(client, ClientDTO.class))
                    .collect(Collectors.toList());
        }catch (Exception e){

        }

        return null;
    }

    public ClientDTO getById(Client cli){
        try{
            return repo.findById(cli.getId()).stream().map(client->mapper.map(client, ClientDTO.class)).findFirst().get();
        }catch (Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public String delete(long id){

        String result = " Client with id: "+ id + " not found!";
        try{
            long countBefore = repo.count();
            repo.delete(new Client(id));
            long countAfter = repo.count();

            if (countBefore > countAfter) {
                return result;
            } else {
                result= " Client with id: "+ id + " deleted with success!";
                return result;
            }
        }catch (Exception e){
            logger.error(e.toString());
        }

        return result;
    }
}
