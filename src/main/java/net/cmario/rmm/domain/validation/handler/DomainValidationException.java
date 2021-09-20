package net.cmario.rmm.domain.validation.handler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.cmario.rmm.domain.DomainEntity;

/**
 * Exception about illegal state of domain entity.
 */
public class DomainValidationException extends IllegalStateException {
  
  @Getter
  @Setter(AccessLevel.PRIVATE)
  private DomainEntity entity;

  public DomainValidationException(DomainEntity entity, String message) {
    super(message);
    this.setEntity(entity);
  }

}
