package ru.art.testTaskNordClan.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 *
 */
@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;

    public Event() {
    }

    private LocalDateTime convertToTimeZone(LocalDateTime time)
    {
        ZonedDateTime zdtAtET = ZonedDateTime.of(time, ZoneOffset.UTC);
        ZoneId ms = ZoneId.of("Europe/Moscow");
        ZonedDateTime ldt = zdtAtET.withZoneSameInstant(ms);
        return ldt.toLocalDateTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = convertToTimeZone(start);
    }


    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime finish) {
        this.end = convertToTimeZone(finish);
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", title=" + title + ", description=" + description + ", start=" + start
                + ", finish=" + end + "]";
    }
}
