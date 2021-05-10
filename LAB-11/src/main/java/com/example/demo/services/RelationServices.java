package com.example.demo.services;


import com.example.demo.model.Relationship;
import com.example.demo.repositories.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RelationServices {

    private final RelationshipRepository relationshipRepository;
    private final List<Optional<Relationship>> friendships;

    @Autowired
    RelationServices(RelationshipRepository relationshipRepository){
        this.relationshipRepository = relationshipRepository;
        friendships = new ArrayList<>();
    }

    public void save (Relationship relationship){
        relationshipRepository.save(relationship);
    }
    public Iterable<Relationship> findAll(){
        return relationshipRepository.findAll();
    }
    public Optional<Relationship> getRelations(Integer id){
        return relationshipRepository.findById(id);
    }
}
