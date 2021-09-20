package net.cmario.rmm.domain.validation;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.cmario.rmm.domain.DomainEntity;

/**
 * Abstract entity validator.
 */
public abstract class Validator<T extends DomainEntity, NotificationT> {
  
  @Getter
  @Setter(AccessLevel.PRIVATE)
  private ValidationNotificationHandler<NotificationT> handler;

  public Validator(ValidationNotificationHandler<NotificationT> handler) {
    this.setHandler(handler);
  }

  public abstract void validate();
}
