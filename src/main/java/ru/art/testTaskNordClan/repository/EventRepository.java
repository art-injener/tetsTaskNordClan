package ru.art.testTaskNordClan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import ru.art.testTaskNordClan.model.Event;

import java.time.LocalDateTime;
import java.util.List;

/*@
*/
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select b from Event b where b.start >= ?1 and b.finish <= ?2")
    public List<Event> findBetween(@DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                   @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) LocalDateTime end);

}
