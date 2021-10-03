package com.spring.designpatternsapp.controller;


import com.spring.designpatternsapp.factory.Pet;
import com.spring.designpatternsapp.factory.PetFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {

    private final PetFactory petFactory;

    @Autowired
    public AppController(PetFactory petFactory) {
        this.petFactory = petFactory;
    }

    @GetMapping
    public String getDefault(){
        return "{\"message\": \"Hello World\"}";
    }


    @PostMapping("adoptPet/{type}/{name}")
    public Pet adoptPet(@PathVariable String type, @PathVariable String name) {
        Pet pet = this.petFactory.createPet(type);
        pet.setName(name);
        pet.feed();

        return pet;
    }

}
