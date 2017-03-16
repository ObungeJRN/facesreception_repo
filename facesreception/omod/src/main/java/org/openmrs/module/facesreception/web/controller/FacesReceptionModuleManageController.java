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
package org.openmrs.module.facesreception.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.api.context.Context;
import org.openmrs.module.facesreception.DemoPerson;
import org.openmrs.module.facesreception.api.FacesReceptionModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * The main controller.
 */
@Controller
public class  FacesReceptionModuleManageController {
	
	protected final Log log = LogFactory.getLog(getClass());

	@RequestMapping(value = "/module/facesreception/manage", method = RequestMethod.GET)
	public void manage(ModelMap model) {
		model.addAttribute("user", Context.getAuthenticatedUser());
	}

	@RequestMapping(value = "/module/facesreception/manage", method = RequestMethod.POST)
	public void getConcepts(ModelMap model, @RequestParam(value = "searchstr",required = true) String searchstr) {

		List<Concept> listOfConcepts = Context.getConceptService().getConceptsByName(searchstr);
		model.addAttribute("conceptList", listOfConcepts);
	}



	@RequestMapping(value = "/module/facesreception/patientlist", method = RequestMethod.GET)
    public void loadPatient(ModelMap model) {
    }

    @RequestMapping(value = "/module/facesreception/patientlist", method = RequestMethod.POST)
    public void searchPatient(ModelMap model, @RequestParam(value="startdate",
            required=true)String startDate,@RequestParam(value="enddate", required=true)String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		FacesReceptionModuleService frms = Context.getService(FacesReceptionModuleService.class);
		try {
			List<DemoPerson> personList = frms.getPersonList(sdf.parse(startDate), sdf.parse(endDate));
			model.addAttribute("persondetails", personList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}




}
