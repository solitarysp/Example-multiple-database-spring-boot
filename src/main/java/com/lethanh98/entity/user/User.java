package com.lethanh98.entity.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Table(name = "user")
@Entity
public class User {

  public User() {
  }

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "career")
  private String career;

}
