package net.cmario.rmm.domain;

import java.io.Serializable;

/**
 * Abstract class for Value Object.
 */
public abstract class ValueObject implements Serializable {

  @Override
  public abstract boolean equals(Object opponent);

  @Override
  public abstract int hashCode();

}
