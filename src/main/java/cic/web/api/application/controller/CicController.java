package cic.web.api.application.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cic.web.api.application.model.Cic;
import cic.web.api.application.model.RequestBodyModel;
import cic.web.api.application.services.CicServices;

//import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CicController {
	@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/cic", method = RequestMethod.POST)
    public Cic saveCic(@RequestBody RequestBodyModel body) {
    	Cic cic = new Cic();
        try {
			cic = CicServices.insertCic(body.getEmailId(), body.getEmailName(), body.getEmailAddress(), body.getCicId(), body.getCicType(), body.getSubject(), body.getBody(), body.getSourceSystem());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cic;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/cic/{cicid}", method = RequestMethod.GET)
	public Cic getCic(@PathVariable("cicid") long cicid) {
    	Cic cic = new Cic();
        try {
			cic = CicServices.getCic(cicid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cic;
	}
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/cic-all", method = RequestMethod.GET)
	public List<Cic> getCicAll() {
    	List<Cic> list = new ArrayList<Cic>();
        try {
			list = CicServices.getCicAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}