package net.cmario.rmm.domain.identity.generator;

/**
 * Identifier value generator.
 */
public interface IdentifierGenerator<T> {
  
  public T generate();
}
