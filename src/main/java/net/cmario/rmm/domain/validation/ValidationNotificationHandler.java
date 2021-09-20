package net.cmario.rmm.domain.validation;

/**
 * Notification handler of validated result.
 */
public abstract class ValidationNotificationHandler<T> {
  
  public abstract void handleError(T error);
}
