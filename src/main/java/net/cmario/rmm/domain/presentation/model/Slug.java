package net.cmario.rmm.domain.presentation.model;

import java.util.regex.Pattern;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.cmario.rmm.domain.ValueObject;

/**
 * Event slug.
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Slug extends ValueObject {

  @Getter
  private String value;
  
  /**
   * Slug constructor.
   * - Use only a-z, A-Z and "-"
   * - Start with a-z, A-Z only.
   * - Length 4-32 characters.
   * 
   * @param value Slug value.
   */
  public Slug(@NonNull String value) {
    if (!Pattern.matches("^([a-zA-Z])([a-zA-Z0-9]|-){3,31}$", value)) {
      throw new IllegalArgumentException("Invalid slug.");
    }

    this.value = value;
  }

  @Override
  public boolean equals(Object opponent) {
    if (this == opponent) {
      return true;
    }

    if (opponent == null || this.getClass() != opponent.getClass()) {
      return false;
    }

    String value = ((Slug) opponent).value;

    return this.value.equals(value);
  }

  @Override
  public int hashCode() {
    return this.value.hashCode();
  }
  
}
