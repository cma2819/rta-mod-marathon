package net.cmario.rmm.domain.presentation.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import net.cmario.rmm.domain.DomainEntity;
import net.cmario.rmm.domain.identity.EventId;
import net.cmario.rmm.domain.validation.ValidationNotificationHandler;

/**
 * Event entity present information.
 */
@Entity
@NoArgsConstructor
public class Event extends DomainEntity {
  
  @EmbeddedId
  @Getter
  @Setter(AccessLevel.PRIVATE)
  private EventId id;

  @Embedded
  @Getter
  @Setter(AccessLevel.PROTECTED)
  private EventPresentation presentation;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "name", column = @Column(name = "LOCATION_NAME")),
    @AttributeOverride(name = "address", column = @Column(name = "LOCATION_ADDRESS")),
  })
  @Getter
  @Setter(AccessLevel.PROTECTED)
  private Location location;

  @Getter
  @Setter(AccessLevel.PROTECTED)
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

    event.setId(id);

    event.setPresentation(presentation);
    event.setLocation(location);
    event.setOnsite(isOnsite);

    return event;
  }

  public Event editPresentation(@NonNull EventPresentation presentation) {
    this.presentation = presentation;
    return this;
  }

  public Event changeLocation(Location location) {
    this.location = location;
    return this;
  }

  public void validate(ValidationNotificationHandler<String> handler) {
    (new EventValidator(this, handler)).validate();
  }
}
