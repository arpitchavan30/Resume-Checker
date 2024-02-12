package com.example.Job.Seeker.Application.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
@Builder
@RequiredArgsConstructor
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String contactInformation;
    @ManyToOne
    @JoinColumn
    private User users;

}
