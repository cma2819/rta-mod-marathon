package net.cmario.rmm.domain.presentation.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.UUID;
import net.cmario.rmm.domain.identity.EventId;
import net.cmario.rmm.domain.presentation.model.Event;
import net.cmario.rmm.domain.presentation.model.EventPresentation;
import net.cmario.rmm.domain.presentation.model.Location;
import net.cmario.rmm.domain.presentation.model.Slug;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit test for EventRepository.
 */
@SpringBootTest
@AutoConfigureTestDatabase
class EventRepositoryTest {

  private Event event;
  
  @Autowired
  private EventRepository repository;

  @BeforeEach
  public void setup() {
    EventId id = new EventId(UUID.randomUUID());
    Slug slug = new Slug("rtaij");
    EventPresentation presentation = new EventPresentation("Event Name", "This is RTA event.");
    this.event = Event.create(id, slug, presentation, null, Boolean.FALSE);
  }

  @Test
  void testProvideNextId() {
    assertTrue(this.repository.findById(this.repository.nextIdentifier()).isEmpty());
  }

  @Test
  void testStoreEventAndFind() {

    this.repository.save(this.event);

    Optional<Event> result = this.repository.findById(this.event.getId());
    assertTrue(result.isPresent());

    EventPresentation nextPresentation
        = new EventPresentation("Event New Name", "This is next event.");
    this.event.editPresentation(nextPresentation);
    Location nextLocation = new Location("Tokyo Example Club", "1-4 Super city, Tokyo");
    this.event.changeLocation(nextLocation);

    this.repository.save(this.event);
    Optional<Event> nextResult = this.repository.findById(this.event.getId());
    
    assertEquals(event.getId(), nextResult.get().getId());
    assertEquals(event.getPresentation(), nextResult.get().getPresentation());
    assertEquals(event.getLocation(), nextResult.get().getLocation());
  }
}
