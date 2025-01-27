package com.citizenservicesportal.entities;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Integer startID = 1001;
	private static Integer currentID = startID;
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		return currentID++;
	}

}
