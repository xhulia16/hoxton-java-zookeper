package com.zookeperhoxton.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class animalController {

    @Autowired

    private AnimalRepository animalRepository;

    @GetMapping("/animals")
    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    @GetMapping("/animals/{id}")
    public Optional<Animal> getSingleAnimal(@PathVariable Integer id) {
       return animalRepository.findById(id);       
    }

    @PostMapping("/animals")
    public Animal createAnimal(@RequestBody Animal animal) {
        Animal newAnimal = animalRepository.save(animal);
        return newAnimal;
    }

    @PatchMapping("/animals/{id}")
    public Animal updateAnimal(@RequestBody Animal animal, @PathVariable Integer id){
        animal.id= id;
        return animalRepository.save(animal);
    }

    @DeleteMapping("/animals/{id}")
    public String deleteAnimal(@PathVariable Integer id){
        animalRepository.deleteById(id);
        return ("Succesfully deleted!");
    }
}

interface AnimalRepository extends JpaRepository<Animal, Integer> {
}