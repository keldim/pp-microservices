package com.chrisyoo.notification;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class SearchByUuidImpl implements SearchByUuid {
    private EntityManager entityManager;

    public Notification findByUuid(String uuid) {
        Query theQuery = entityManager.createQuery("SELECT u FROM Notification u WHERE u.uuid = :uuid");
        theQuery.setParameter("uuid", uuid);

        List<Notification> result = theQuery.getResultList();
        if(result.size() == 0) {
            return null;
        } else {
            return result.get(0);
        }

    }
}
