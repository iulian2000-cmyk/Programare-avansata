package com.example.demo.Controllers;


import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/demo")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewPerson (@RequestParam String name
            , @RequestParam String email) {
        Person n = new Person();
        n.setName(name);
        n.setEmail(email);
        personRepository.save(n);
        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Person> getAllPersons() {
        // This returns a JSON or XML with the users
        return personRepository.findAll();
    }
    @DeleteMapping(path = "/delete/person/")
    public void deletePerson(@RequestBody Person person)
    {
        personRepository.delete(person);
    }
    @PutMapping(path="/update/{id}")
    public void updatePerson(@PathVariable("id") Integer id , @RequestParam String name )
    {
        Optional<Person> person = personRepository.findById(id);
        Person newPerson = person.get();
        newPerson.setName(name);
        personRepository.save(newPerson);
    }
}