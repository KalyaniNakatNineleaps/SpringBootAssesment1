package com.example.assesment1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.assesment1.Entity.Learners;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;
@Service
public class LearnerService {
    @Autowired
    LearnerRepository learnerRepository;

    public List<Learners> getAllLearnerss(){
        return learnerRepository.findAll();
    }
    //get Learnerss by id

    public Learners getLearnersById( int id){
        return learnerRepository.findById(id).get();
    }
    //create Learners
    public Learners createLearners(Learners learners){
        return learnerRepository.save(learners);
    }
    //remove Learners
    public void removeLearnersById( int id){
        Optional<Learners> tempLearners=learnerRepository.findById(id);
        if(tempLearners.isEmpty()){
            throw new RuntimeException("Learners id"+ id +"doesn't exist");
        }
        learnerRepository.deleteById(id);
    }
    //remove all Learnerss
    public void removeAllLearnerss(){
        learnerRepository.deleteAll();
    }
    public long findCountLearnerss(){
        return learnerRepository.findAll().size();
    }

    public String indicateLearnersById( int id){
        Optional<Learners> tempLearners=learnerRepository.findById(id);
        if(tempLearners.isEmpty()){
            return "ID does not exist";
        }
        return "ID is PRESENT";
    }



}




/*
* package com.springh2.springh2database;
import com.springh2.springh2database.Entity.Learners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service  //
public class LearnersService {
    @Autowired
    LearnersRepository LearnersRepository;
    // for list of objects
    //Get all Learnerss
    public List<Learners> getAllLearnerss(){
        return LearnersRepository.findAll();
    }
    //get Learnerss by id

    public Learners getLearnersById( int id){
        return LearnersRepository.findById(id).get();
    }
    //create Learners
    public Learners createLearners(Learners Learners){
        return LearnersRepository.save(Learners);
    }
    //remove Learners
    public void removeLearnersById( int id){
        Optional<Learners> tempLearners=LearnersRepository.findById(id);
        if(tempLearners.isEmpty()){
            throw new RuntimeException("Learners id"+ id +"doesn't exist");
        }
         LearnersRepository.deleteById(id);
    }
    //remove all Learnerss
     public void removeAllLearnerss(){
        LearnersRepository.deleteAll();
     }
     public long findAllLearnerss(){
        return LearnersRepository.findAll().size();
     }

}

* */
