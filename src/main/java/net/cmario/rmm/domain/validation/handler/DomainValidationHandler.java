package net.cmario.rmm.domain.validation.handler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.cmario.rmm.domain.DomainEntity;
import net.cmario.rmm.domain.validation.ValidationNotificationHandler;

/**
 * Validation notification handler for domain entity.
 */
public class DomainValidationHandler<T extends DomainEntity>
    extends ValidationNotificationHandler<String> {

  @Getter
  @Setter(AccessLevel.PRIVATE)
  private T entity;

  public DomainValidationHandler(T entity) {
    this.setEntity(entity);
  }


  @Override
  public void handleError(String error) {
    throw new DomainValidationException(this.entity, error);
  }
  
}
