/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.facesreception.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.openmrs.module.facesreception.DemoPerson;
import org.openmrs.module.facesreception.api.db.FacesReceptionModuleDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * It is a default implementation of  {@link FacesReceptionModuleDAO}.
 */
public class HibernateFacesReceptionModuleDAO implements FacesReceptionModuleDAO {
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	/**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
    }
    
	/**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
	    return sessionFactory;
    }


	public List getPersonList(Date startDate, Date endDate) {
		List<DemoPerson> lp = new ArrayList<DemoPerson>();
		StringBuilder strSql = new StringBuilder();
		strSql.append("SELECT  p.person_id,p.birthdate,p.gender, concat_WS('',pn.given_name,pn.family_name) as name ");
		strSql.append("from person p ");
		strSql.append("join person_name pn on pn.person_id=p.person_id ");
		strSql.append("where p.voided=0 and birthdate between :startDate and :endDate");

		Query queryResults=sessionFactory.getCurrentSession().createSQLQuery(strSql.toString());

		//PASS PARAMETERS

		if(startDate!=null)
		{
			queryResults.setParameter("startDate",startDate);
		}
		if(endDate!=null)
		{
			queryResults.setParameter("endDate",endDate);
		}

	 List list = queryResults.list(); //convert the generated array into a list	object

		Iterator it = list.iterator();
		while(it.hasNext()){

			Object[] row =(Object[])it.next();
			DemoPerson p = new DemoPerson();
			p.setId((Integer)row[0]);
			p.setDOB((Date)row[1]);
			p.setGender((String)row[2]);
			p.setName((String)row[3]);

			lp.add(p);
		}

		return lp;
	}

	@Override
	public DemoPerson getPersonDetails() {
		DemoPerson p = new DemoPerson();
		return p;
	}

}