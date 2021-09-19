package net.cmario.rmm.domain.presentation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.UUID;
import net.cmario.rmm.domain.presentation.model.Event;
import net.cmario.rmm.domain.presentation.model.EventPresentation;
import net.cmario.rmm.domain.presentation.model.Location;
import net.cmario.rmm.domain.value.EventId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * Unit test for EventRepository.
 */
@DataJpaTest
public class EventRepositoryTest {
  
  @Autowired
  private EventRepository repository;

  /**
   * Event エンティティの保存及び ID での取得ができること.
   */
  @Test
  public void testStoreEventAndFind() {
    EventId id = new EventId(UUID.randomUUID());
    EventPresentation presentation = new EventPresentation("Event Name", "This is RTA event.");
    Event event = Event.create(id, presentation, null, Boolean.FALSE);

    this.repository.save(event);

    Optional<Event> result = this.repository.findById(id);
    assertTrue(result.isPresent());

    EventPresentation nextPresentation
        = new EventPresentation("Event New Name", "This is next event.");
    event.editPresentation(nextPresentation);
    Location nextLocation = new Location("Tokyo Example Club", "1-4 Super city, Tokyo");
    event.changeLocation(nextLocation);

    this.repository.save(event);
    Optional<Event> nextResult = this.repository.findById(id);
    assertEquals(event.getId(), nextResult.get().getId());
    assertEquals(event.getPresentation(), nextResult.get().getPresentation());
    assertEquals(event.getLocation(), nextResult.get().getLocation());
  }
}
