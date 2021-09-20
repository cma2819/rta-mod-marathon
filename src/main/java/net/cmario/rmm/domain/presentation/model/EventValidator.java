package net.cmario.rmm.domain.presentation.model;

import lombok.AccessLevel;
import lombok.Setter;
import net.cmario.rmm.domain.validation.ValidationNotificationHandler;
import net.cmario.rmm.domain.validation.Validator;

/**
 * Event entity validator.
 */
public class EventValidator extends Validator<Event, String> {

  @Setter(AccessLevel.PRIVATE)
  private Event event;

  public EventValidator(
      Event event,
      ValidationNotificationHandler<String> handler
  ) {
    super(handler);
    this.setEvent(event);
  }

  @Override
  public void validate() {
    if (!this.event.isOnsite() && (this.event.getLocation() != null)) {
      this.getHandler().handleError("Location must not set for online event.");
    }
  }
  
}
