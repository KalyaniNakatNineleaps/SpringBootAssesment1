package com.example.assesment1.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="learners")
public class Learners implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int learner_id;

    private String learner_first_name;
    private String learner_last_name;
    private String learner_email;
    private String learner_password;
    private int course_id;

}
