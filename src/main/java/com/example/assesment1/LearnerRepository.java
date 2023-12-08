package com.example.assesment1;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.assesment1.Entity.Learners;

public interface LearnerRepository extends JpaRepository<Learners,Integer> {

}

