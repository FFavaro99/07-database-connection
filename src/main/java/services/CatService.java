package services;

import entities.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CatRepository;

import java.util.List;

@Service
public class CatService {

    private CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void addFourCats() {
        Cat[] cats = {new Cat("Margret", 4), new Cat("Shifty", 8), new Cat("Luli", 8), new Cat("Gerald", 3)};
        for (Cat cat : cats) {
            catRepository.addNewCat(cat);
        }
    }

    public void printAllCats() {
        List<Cat> catList = catRepository.getAllCats();
        System.out.println(catList);
    }

    public void printCatById(int id) {
        Cat cat = catRepository.getCatById(id);
        System.out.println(cat);
    }
}
