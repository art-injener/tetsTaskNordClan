package ru.art.testTaskNordClan.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * Event description class
 * @author Danilchenko Artem
 */
@Entity
@Table(name="event")
public class Event {

    /** property identifier of event*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** property identifier of owner*/
    @JoinColumn(name = "user_id")
    private Long userId;
    /** property title event*/
    private String title;
    /** property identifier event*/
    private String description;
    /** property start date and time of event*/
    private LocalDateTime start;
    /** property end date and time of event*/
    private LocalDateTime end;

    public Event() {
    }

    public Event(Long id,
                 String title,
                 String description,
                 LocalDateTime start,
                 LocalDateTime finish) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = finish;
    }

    /** method for convert time to Moscow time Zone*/
    private LocalDateTime convertToTimeZone(LocalDateTime time) {
        ZonedDateTime zdtAtET = ZonedDateTime.of(time, ZoneOffset.UTC);
        ZoneId ms = ZoneId.of("Europe/Moscow");
        ZonedDateTime ldt = zdtAtET.withZoneSameInstant(ms);
        return ldt.toLocalDateTime();
    }
     /** get identifier of event */
    public Long getId() {
        return id;
    }
    /** set identifier of event */
    public void setId(Long id) {
        this.id = id;
    }
    /** get identifier of event's owner*/
    public Long getUserId() {
        return userId;
    }

    /** set identifier of event's owner*/
    public void setUserId(Long user_id) {
        this.userId = user_id;
    }
    /** get title of event*/
    public String getTitle() {
        return title;
    }
    /**set title of event */
    public void setTitle(String title) {
        this.title = title;
    }
    /** get description of event*/
    public String getDescription() {
        return description;
    }
    /** set description of event*/
    public void setDescription(String description) {
        this.description = description;
    }
    /**get start date and time of event */
    public LocalDateTime getStart() {
        return start;
    }
    /** set start date and */
    public void setStart(LocalDateTime start) {
        this.start = convertToTimeZone(start);
    }
    /** get end date and time of event*/
    public LocalDateTime getEnd() {
        return end;
    }
    /**set end date and time of event */
    public void setEnd(LocalDateTime finish) {
        this.end = convertToTimeZone(finish);
    }
    /** method fo create string value of class */
    @Override
    public String toString() {
        return "Event [id=" + id + ", title=" + title + ", description=" + description + ", start=" + start
                + ", finish=" + end + "]";
    }

}
