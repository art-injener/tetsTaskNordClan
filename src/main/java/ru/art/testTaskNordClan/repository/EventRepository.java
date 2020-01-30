package ru.art.testTaskNordClan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.art.testTaskNordClan.model.Event;

import java.time.LocalDateTime;
import java.util.List;

/**
 * interface for receiving data from the JPA
 * @author Danilchenko Artem
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    /**
     * method for select events on time interval
     * @param start - start date and time of search interval
     * @param end - end date and time of search interval
     * @return list events, may be null
     */
    @Query("select b from Event b where b.start >= ?1 and b.end <= ?2")
     List<Event> findBetween(LocalDateTime start,
                             LocalDateTime end);

    /**
     * method for select events on time interval of concretely user
     * @param start - start date and time of search interval
     * @param end - end date and time of search interval
     * @param id - identifier of user
     * @return number of events
     */
    @Query("select COUNT(b.id) from Event b where ((b.start > ?1 and b.start < ?2) or (b.end > ?1 and b.end < ?2) " +
            " or (b.start >= ?1 and b.end <= ?2)) and (b.userId = ?3)")
    int checkForExistingEvent(LocalDateTime start,
                              LocalDateTime end,
                              Long id);

    /**
     * method for select all events of concretely user
     * @param id - identifier of user
     * @return list events, may be null
     */
    @Query("select b from Event b where (b.userId = ?1)")
    List<Event> findAll(Long id);
}
