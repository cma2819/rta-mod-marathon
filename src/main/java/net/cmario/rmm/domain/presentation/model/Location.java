package net.cmario.rmm.domain.presentation.model;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.cmario.rmm.domain.ValueObject;

/**
 * Event placed location.
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Location extends ValueObject {

  @Getter
  private String name;

  @Getter
  private String address;

  public Location(
      @NonNull String name,
      @NonNull String address
  ) {
    this.name = name;
    this.address = address;
  }

  @Override
  public boolean equals(Object opponent) {
    if (this == opponent) {
      return true;
    }

    if (opponent == null || this.getClass() != opponent.getClass()) {
      return false;
    }

    Location location = (Location) opponent;

    return (this.name.equals(location.name) && this.address.equals(location.address));
  }

  @Override
  public int hashCode() {
    return (this.name + this.address).hashCode();
  }
  
}
