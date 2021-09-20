package net.cmario.rmm.domain.identity.generator.impl;

import java.util.UUID;
import net.cmario.rmm.domain.identity.generator.UuidGenerator;
import org.springframework.stereotype.Service;

/**
 * {@inheritDoc}
 */
@Service
public class RandomUuidGenerator implements UuidGenerator {

  @Override
  public UUID generate() {
    return UUID.randomUUID();
  }
  
}
