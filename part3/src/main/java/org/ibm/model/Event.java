package org.ibm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event")
public class Event {

  @Id
  @Column(name = "id")
  @GeneratedValue
  private Long id;

  //pay attention on column name
  @Column(name = "peopleCount")
  private int peopleCount;

  @Column(name = "place")
  private String place;

  @ManyToMany(mappedBy = "eventSet")
  private Set<User> userSet = new HashSet<>();


  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getPlace() {
    return place;
  }


  public void setPlace(String place) {
    this.place = place;
  }
  public int getPeopleCount() {
    return peopleCount;
  }

  public void setPeopleCount(int peopleCount) {
    this.peopleCount = peopleCount;
  }

  public Set<User> getUserSet() {
    return userSet;
  }

  public void setUserSet(Set<User> userSet) {
    this.userSet = userSet;
  }

  @Override public String toString() {
    return "Event{" +
        "id=" + id +
        ", peopleCount=" + peopleCount +
        ", place='" + place + '\'' +
        '}';
  }
}