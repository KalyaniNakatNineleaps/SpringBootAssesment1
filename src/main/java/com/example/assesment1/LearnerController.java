package com.example.assesment1;
import com.example.assesment1.Entity.Learners;
import com.example.assesment1.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController     //t is typically used to build RESTful web services by combining the @Controller and @ResponseBody annotations.
@RequestMapping("/learners")
public class LearnerController {
    @Autowired  //dep injection,@Autowired is used to automatically inject dependencies into a Spring bean
    LearnerService learnerService;
    @GetMapping("/getAll") //for get request
    public List<Learners> getAllLearners(){
        return learnerService.getAllLearnerss();
    }
    @GetMapping("/{id}")
    public Learners getLearnersById(@PathVariable int id){
        return learnerService.getLearnersById(id);
    }
    @PostMapping("/add")
    public  Learners addLearners(@RequestBody Learners Learners){
        return  learnerService.createLearners(Learners);
    }
    @GetMapping("/del/{id}")
    public void removeLearnersById(@PathVariable int id){
        learnerService.removeLearnersById(id);
    }
    @GetMapping("/delAll")
    public  void removeAll(){
        learnerService.removeAllLearnerss();
    }
    @GetMapping("/findcount")
    public long findAll(){
        return learnerService.findCountLearnerss();
    }

    @GetMapping("/indicateID/{id}")
    public String indicateID(@PathVariable int id){
        return learnerService.indicateLearnersById(id);
    }


}
