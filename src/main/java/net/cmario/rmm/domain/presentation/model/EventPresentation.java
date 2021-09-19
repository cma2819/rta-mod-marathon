package net.cmario.rmm.domain.presentation.model;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.cmario.rmm.domain.ValueObject;

/**
 * Presentation value about event.
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventPresentation extends ValueObject {
  
  @Getter
  private String name;

  @Getter
  private String description;

  public EventPresentation(
      @NonNull String name,
      @NonNull String description
  ) {
    this.name = name;
    this.description = description;
  }

  @Override
  public boolean equals(Object opponent) {
    if (this == opponent) {
      return true;
    }

    if (opponent == null || this.getClass() != opponent.getClass()) {
      return false;
    }

    EventPresentation presentation = (EventPresentation) opponent;

    return (this.name.equals(presentation.name)
      && this.description.equals(presentation.description));
  }

  @Override
  public int hashCode() {
    return (this.name + this.description).hashCode();
  }
}
