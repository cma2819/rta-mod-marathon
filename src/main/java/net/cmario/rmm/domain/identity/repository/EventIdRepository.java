package net.cmario.rmm.domain.identity.repository;

import net.cmario.rmm.domain.identity.EventId;

/**
 * Provide next event id.
 */
public interface EventIdRepository {

  public EventId nextIdentifier();

  public boolean exists(EventId eventId);
}
