package org.ibm.repository;

import org.ibm.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

  //ukazat podporu JPA bez query, musi vratit iba jedno
  Event findByplace(String place);




  //manualne query
  @Query(value = "select * from event where place = ?1", nativeQuery = true)
  Set<Event> getEventByPlaceName(String name);

  //  @Query(value = "select * from party where place = ?1", nativeQuery = true)
  //  Set<PartyEvent> getPartiesByPlaceName(String place);


}