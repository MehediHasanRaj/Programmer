package com.example.programmer.repository;

import com.example.programmer.model.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgrammerRepo extends JpaRepository<Programmer,Integer> {

    List<Programmer> findBypLan(String pLan);

    @Query("from Programmer where pName=?1") // custom query
    List<Programmer> findP(String pName);
}
