package net.cmario.rmm.domain.identity;

/**
 * Provide next identifier value.
 */
public interface NextIdentifierProvider<T extends Identifier> {
  
  public T nextIdentifier();
}
