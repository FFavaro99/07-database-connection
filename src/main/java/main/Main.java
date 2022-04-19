package main;

import config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CatService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);
        var service = context.getBean(CatService.class);
        service.printCatById(3);
    }
}
