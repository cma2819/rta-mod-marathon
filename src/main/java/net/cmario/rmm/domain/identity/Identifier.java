package net.cmario.rmm.domain.identity;

import lombok.Getter;
import net.cmario.rmm.domain.ValueObject;

/**
 * Abstract identifier value.
 */
public abstract class Identifier<T> extends ValueObject {
  
  @Getter
  private T id;

  @Override
  public boolean equals(Object opponent) {
    if (this == opponent) {
      return true;
    }

    if (opponent == null || this.getClass() != opponent.getClass()) {
      return false;
    }

    @SuppressWarnings("unchecked")
    Object value = ((Identifier<Object>) opponent).id;

    return this.id.equals(value);
  }

  @Override
  public int hashCode() {
    return this.id.hashCode();
  }

  @Override
  public String toString() {
    return this.id.toString();
  }
}
