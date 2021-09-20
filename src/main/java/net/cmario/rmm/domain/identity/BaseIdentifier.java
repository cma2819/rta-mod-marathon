package net.cmario.rmm.domain.identity;

/**
 * Abstract identifier value.
 */
public abstract class BaseIdentifier<T> implements Identifier {

  @Override
  public boolean equals(Object opponent) {
    if (this == opponent) {
      return true;
    }

    if (opponent == null || this.getClass() != opponent.getClass()) {
      return false;
    }

    @SuppressWarnings("unchecked")
    Object value = ((BaseIdentifier<Object>) opponent).getId();

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
