package net.cmario.rmm.domain.presentation.repository;

import net.cmario.rmm.domain.identity.EventId;
import net.cmario.rmm.domain.identity.NextIdentifierProvider;

/**
 * Provide next event id.
 */
public interface NextEventIdProvider extends NextIdentifierProvider<EventId> {}
