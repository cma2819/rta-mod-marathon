package net.cmario.rmm.domain.identity;

import net.cmario.rmm.domain.ValueObject;

/**
 * Entity Identifier.
 */
public abstract class Identifier<T> extends ValueObject {
  
  @Override
  public boolean equals(Object opponent) {
    if (this == opponent) {
      return true;
    }

    if (opponent == null || this.getClass() != opponent.getClass()) {
      return false;
    }

    @SuppressWarnings("unchecked")
    Object value = ((Identifier<Object>) opponent).getId();

    return this.getId().equals(value);
  }

  @Override
  public int hashCode() {
    return this.getId().hashCode();
  }

  @Override
  public String toString() {
    return this.getId().toString();
  }

  public abstract T getId();

}
