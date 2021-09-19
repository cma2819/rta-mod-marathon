package net.cmario.rmm.domain.value;

import java.util.UUID;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Identifier for Event.
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventId extends Identifier<UUID> {

  @Getter
  private UUID id;

  public EventId(UUID id) {
    this.id = id;
  }
}
