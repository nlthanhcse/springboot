package com.springbootjap.springbootjpa.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NamedQueries(
        value = {
                @NamedQuery(
                        name = "Student.findByNameIgnoreCase", query = "select s from Student s where lower(s.name) like ?1"
                )
        }
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
}
