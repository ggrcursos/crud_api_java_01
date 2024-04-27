package com.crud.ApiCrud.repo;


import com.crud.ApiCrud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query("UPDATE Client c SET c.age = :newAge WHERE c.name = :name")
    int updateClientAgeByName(@Param("name") String name, @Param("newAge") String newAge);
}
