package net.cmario.rmm.domain.presentation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.UUID;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import net.cmario.rmm.domain.identity.EventId;
import net.cmario.rmm.domain.presentation.model.Event;
import net.cmario.rmm.domain.presentation.model.EventPresentation;
import net.cmario.rmm.domain.presentation.model.Location;
import net.cmario.rmm.domain.validation.ValidationNotificationHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EventTest {

  class NeverCalledNotificationHandler extends ValidationNotificationHandler<String> {
    @Override
    public void handleError(String error) {
      fail();
    }
  }

  @RequiredArgsConstructor
  class MustCalledNotificationHandler extends ValidationNotificationHandler<String> {
    private final String message;

    @Override
    public void handleError(String error) {
      assertEquals(message, error);
    }
  }

  @ParameterizedTest
  @MethodSource("passValidationArguments")
  void testPassValidation(EventPresentation presentation, Location location, boolean isOnsite) {

    EventId id = new EventId(UUID.randomUUID());

    Event event = Event.create(id, presentation, location, isOnsite);
    event.validate(new NeverCalledNotificationHandler());
    return;
  }

  private static Stream<Arguments> passValidationArguments() {
    return Stream.of(
      Arguments.of(
        new EventPresentation("Event Name", "This is RTA event."),
        null,
        Boolean.FALSE
      ),
      Arguments.of(
        new EventPresentation("Event Name", "This is RTA event."),
        null,
        Boolean.TRUE
      ),
      Arguments.of(
        new EventPresentation("Event Name", "This is RTA event."),
        new Location("Tokyo Example Club", "1-4 Super city, Tokyo"),
        Boolean.TRUE
      )
    );
  }

  @ParameterizedTest
  @MethodSource("failValidationArguments")
  void testFailValidation(
      EventPresentation presentation, Location location, boolean isOnsite, String error
  ) {
    EventId id = new EventId(UUID.randomUUID());

    Event event = Event.create(id, presentation, location, isOnsite);
    event.validate(new MustCalledNotificationHandler(error));
  }

  private static Stream<Arguments> failValidationArguments() {
    return Stream.of(
      Arguments.of(
        new EventPresentation("Event Name", "This is RTA event."),
        new Location("Tokyo Example Club", "1-4 Super city, Tokyo"),
        Boolean.FALSE,
        "Location must not set for online event."
      )
    );
  }
}
