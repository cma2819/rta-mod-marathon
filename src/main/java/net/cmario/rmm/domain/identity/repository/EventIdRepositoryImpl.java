package net.cmario.rmm.domain.identity.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import net.cmario.rmm.domain.identity.EventId;
import net.cmario.rmm.domain.identity.generator.UuidGenerator;
import org.springframework.stereotype.Repository;

/**
 * {@inheritDoc}
 */
@Repository
@RequiredArgsConstructor
public class EventIdRepositoryImpl implements EventIdRepository {

  private final UuidGenerator uuidGenerator;

  @PersistenceContext
  private final EntityManager entityManager;

  @Override
  public EventId nextIdentifier() {
    EventId nextId = new EventId(this.uuidGenerator.generate());

    if (this.exists(nextId)) {
      throw new RuntimeException("UUID duplicated.");
    }
    
    return nextId;
  }

  @Override
  public boolean exists(EventId eventId) {
    Query query = this.entityManager
        .createQuery("from Event where id = :id")
        .setParameter("id", eventId)
        .setMaxResults(1);

    return (query.getResultList().size() > 0);
  }
  
}
