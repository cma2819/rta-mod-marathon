package net.cmario.rmm.domain;

import java.io.Serializable;

/**
 * Interface for Value Object.
 */
public interface ValueObject extends Serializable {

  @Override
  public abstract boolean equals(Object opponent);

  @Override
  public abstract int hashCode();

}
