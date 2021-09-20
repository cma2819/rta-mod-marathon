package net.cmario.rmm.domain.presentation.repository;

import lombok.RequiredArgsConstructor;
import net.cmario.rmm.domain.identity.EventId;
import net.cmario.rmm.domain.identity.generator.UuidGenerator;

/**
 * {@inheritDoc}
 */
@RequiredArgsConstructor
public class NextEventIdProviderImpl implements NextEventIdProvider {

  private final UuidGenerator uuidGenerator;

  @Override
  public EventId nextIdentifier() {
    return new EventId(this.uuidGenerator.generate());
  }
  
}
