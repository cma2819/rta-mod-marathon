package net.cmario.rmm.domain.presentation;

import net.cmario.rmm.domain.identity.EventId;
import net.cmario.rmm.domain.presentation.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Event entity.
 */
public interface EventRepository extends JpaRepository<Event, EventId> {}
