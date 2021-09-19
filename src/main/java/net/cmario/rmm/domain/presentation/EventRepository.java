package net.cmario.rmm.domain.presentation;

import net.cmario.rmm.domain.presentation.model.Event;
import net.cmario.rmm.domain.value.EventId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Event entity.
 */
public interface EventRepository extends JpaRepository<Event, EventId> {}
