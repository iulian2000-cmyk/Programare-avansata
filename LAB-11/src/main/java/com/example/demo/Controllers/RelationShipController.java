package com.example.demo.Controllers;

import com.example.demo.model.Relationship;
import com.example.demo.services.RelationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;



@RestController
@RequestMapping(path="/demo")
public class RelationShipController
{
    private final RelationServices relationServices;
    @Autowired
    private JdbcTemplate JdbcTemplate;

    @Autowired
    public RelationShipController(RelationServices relationServices){
        this.relationServices = relationServices;
    }



    @PostMapping(path="/addRelation/") // Map ONLY POST Requests
    public @ResponseBody
    String addNewPerson (@RequestParam Integer id1
            , @RequestParam  Integer id2) {
        Relationship relationship = new Relationship();
        relationship.setId_friend_1(id1);
        relationship.setId_friend_2(id2);
        relationServices.save(relationship);
        return "New relation added";
    }

    @GetMapping(path ="/getRelations/")
    public @ResponseBody Iterable<Relationship> getRelations(){
        return relationServices.findAll();
    }
    @GetMapping(path="/getFriends/{id}")
    public Optional<Relationship> getFriends(@PathVariable("id") Integer id)
    {
        return relationServices.getRelations(id);
    }

    @GetMapping("/getMostPopular/")
    public String getMostPopular()
    {
        String res;
        Integer first = JdbcTemplate.queryForObject("SELECT p1.id_friend_1 FROM relationship p1 JOIN relationship p2 ON p1.id_friend_2=p2.id_friend_1 LIMIT 1;", Integer.class);
        if(first != null){
            res = first.toString();
        }else{
            res = "";
        }
        return res;
    }
}
