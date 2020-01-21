package ru.art.testTaskNordClan.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime finish;

    public Event() {
        super();
        System.out.println("Create empty Event");
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
        System.out.println("set Event" + start.toString());
        ZonedDateTime zdtAtET = ZonedDateTime.ofLocal(start, ZoneId.of("America/New_York"), ZoneOffset.UTC);

        //LocalDateTime ldt = zdtAtET.toLocalDateTime();
        System.out.println("set Event" + zdtAtET);

        this.start = start.plusHours(3);
    }


    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish.plusHours(3);
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", title=" + title + ", description=" + description + ", start=" + start
                + ", finish=" + finish + "]";
    }
}
