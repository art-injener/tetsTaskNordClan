package ru.art.testTaskNordClan.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.art.testTaskNordClan.repository.EventRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EventControllerIntegratingTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventRepository mockRepository;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testAllEvents() throws Exception {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        LocalDateTime event_1_start = LocalDateTime.parse("2020-01-26 01:00:00", formatter);
//        LocalDateTime event_1_end = LocalDateTime.parse("2020-01-26 01:30:00", formatter);
//
//        LocalDateTime event_2_start = LocalDateTime.parse("2020-01-26 02:00:00", formatter);
//        LocalDateTime event_2_end = LocalDateTime.parse("2020-01-26 02:30:00", formatter);
//
//        List<Event> events = Arrays.asList(
//                new Event(1L, "event1",
//                        "description1",
//                        event_1_start,
//                        event_1_end),
//
//                new Event(2L, "event2",
//                        "description2",
//                        event_2_start,
//                        event_2_end));
//        events.get(0).setUserId(1L);
//        events.get(1).setUserId(1L);
//
//        when(mockRepository.findAll()).thenReturn(events);
//
//        mockMvc.perform(get("/allevents"))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[0].title", is("event1")))
//                .andExpect(jsonPath("$[0].description", is("description1")))
//                .andExpect(jsonPath("$[0].id", is(2)))
//                .andExpect(jsonPath("$[0].title", is("event2")))
//                .andExpect(jsonPath("$[0].description", is("description2")));;
//
//        verify(mockRepository, times(1)).findAll(1L);
    }

    @Test
    public void findEventIdNotFound_404() throws Exception {
//       mockMvc.perform(get("/event/6")).andExpect(status().isNotFound());
    }

    @Test
    public void removeEventTest() {

    }

    @Test
    public void addEventTest() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        LocalDateTime event_1_start = LocalDateTime.parse("2020-01-26 01:00:00", formatter);
//        LocalDateTime event_1_end = LocalDateTime.parse("2020-01-26 01:30:00", formatter);
//
//        Event newEvent = new Event(1L, "event1", "description1", event_1_start, event_1_end);
//        when(mockRepository.save(any(Event.class))).thenReturn(newEvent);
//
//        try {
//            mockMvc.perform(post("/event")
//                    .accept("application/json")
//                    .contentType("application/json")
//                    .content(om.writeValueAsString(newEvent))
//                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8))
//                    .andExpect(status().isCreated())
//                    .andDo(MockMvcResultHandlers.print())
//                    .andExpect(jsonPath("$.id", is(1)))
//                    .andExpect(jsonPath("$.title", is("Spring Boot Guide")));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        verify(mockRepository, times(1)).save(any(Event.class));

    }
}