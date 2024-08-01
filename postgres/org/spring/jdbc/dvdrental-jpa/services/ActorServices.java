package services;

import entities.ActorReport;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ActorRepository;

import java.util.List;

public class ActorServices {
    @Autowired
    ActorRepository repository;

    public void selectActorWithFilmCount(){
        List<ActorReport> reports = repository.selectActor();
        for(ActorReport actor: reports){
            System.out.println(actor.toString());
        }
    }
}
