package org.openmrs.module.facesreception.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
 * Created by obungejrn on 3/15/17
 * .
 */

@Controller

public class FacesReceptionModulePatientlistController {

    protected final Log log = LogFactory.getLog(getClass());
/*
    @RequestMapping(value = "/module/facesreception/patientlist", method = RequestMethod.POST)
    public void searchPatient(ModelMap model, @RequestParam(value="startdate",
            required=true)String startDate, @RequestParam(value="enddate", required=true)String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        FacesReceptionModuleService frms = Context.getService(FacesReceptionModuleService.class);
        try {
            List<DemoPerson> personList = frms.getPersonList(sdf.parse(startDate), sdf.parse(endDate));
            model.addAttribute("persondetails", personList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }*/
}
