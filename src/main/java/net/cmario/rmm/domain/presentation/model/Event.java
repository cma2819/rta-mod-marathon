package net.cmario.rmm.domain.presentation.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.cmario.rmm.domain.value.EventId;

/**
 * Event entity present information.
 */
@Entity
@NoArgsConstructor
public class Event {
  
  @EmbeddedId
  @Getter
  private EventId id;

  @Embedded
  @Getter
  private EventPresentation presentation;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "name", column = @Column(name = "LOCATION_NAME")),
    @AttributeOverride(name = "address", column = @Column(name = "LOCATION_ADDRESS")),
  })
  @Getter
  private Location location;

  @Getter
  private boolean isOnsite;

  /**
   * Create Event entity.
   */
  public static Event create(
      @NonNull EventId id,
      @NonNull EventPresentation presentation,
      Location location,
      boolean isOnsite
  ) {
    Event event = new Event();

    event.id = id;
    event.presentation = presentation;
    event.location = location;
    event.isOnsite = isOnsite;

    return event;
  }

  public Event editPresentation(EventPresentation presentation) {
    this.presentation = presentation;
    return this;
  }

  public Event changeLocation(Location location) {
    this.location = location;
    return this;
  }
}
