package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "recommends")
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true)
    @Size(max = 2000)
    private String recommendation;

    @ManyToMany(mappedBy = "recommends")
    Set<Survey> surveys = new HashSet<>();
}