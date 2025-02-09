package com.citizenservicesportal.entities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int startID = 1001;

    @Override
    public synchronized Object generate(SharedSessionContractImplementor session, Object object) {
        Integer lastId = fetchLastId(session);
        return (lastId != null) ? lastId + 1 : startID;
    }

    private Integer fetchLastId(SharedSessionContractImplementor session) {
        Integer lastId = null;
        try {
            // Get connection using doReturningWork in Hibernate 6+
            lastId = session.doReturningWork(connection -> {
                try (PreparedStatement ps = connection.prepareStatement("SELECT MAX(userid) FROM users");
                     ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
                return null;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastId;
    }
}
