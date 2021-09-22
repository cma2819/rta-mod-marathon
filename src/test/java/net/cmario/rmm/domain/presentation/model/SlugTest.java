package net.cmario.rmm.domain.presentation.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SlugTest {
  
  @ParameterizedTest
  @MethodSource("validSlugParameters")
  void testValidSlug(String value) {
    Slug slug = new Slug(value);

    assertEquals(slug.getValue(), value);
  }

  private static Stream<Arguments> validSlugParameters() {
    return Stream.of(
      Arguments.of("rtaij"),
      Arguments.of("max-length-event-slug-32-chars--"),
      Arguments.of("Use-all-usable-char-1234567890")
    );
  }

  @ParameterizedTest
  @MethodSource("invalidSlugParameters")
  void testInvalidSlug(String value) {
    assertThrows(IllegalArgumentException.class, () -> {
      new Slug(value);
    });
  }

  private static Stream<Arguments> invalidSlugParameters() {
    return Stream.of(
      Arguments.of("rtaij!!!"),
      Arguments.of("aiu"),
      Arguments.of("over-max-length-event-slug-32----"),
      Arguments.of("1-start-by-number"),
      Arguments.of("-start-by-hyphen")
    );
  }
}
