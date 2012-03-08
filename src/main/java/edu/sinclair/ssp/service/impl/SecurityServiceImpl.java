package edu.sinclair.ssp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sinclair.ssp.model.Person;
import edu.sinclair.ssp.security.SspUser;
import edu.sinclair.ssp.service.PersonService;
import edu.sinclair.ssp.service.SecurityService;

@Transactional(readOnly = true)
@Service
public class SecurityServiceImpl implements SecurityService{

	private Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
	
	@Autowired
	private PersonService personService;
	
	@Override
	public SspUser currentlyLoggedInSspUser() {
		SspUser sspUser = null;
		if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(principal instanceof SspUser){
				sspUser = (SspUser) principal;	
			}else if(principal instanceof String){
				logger.error("Just tried to get an sspUser object from a user that is " + principal);
			}else{
				logger.error("Just tried to get an sspUser object from an object that is really a " + principal.toString());
			}
		}
		
		if(sspUser.getPerson()==null){
			Person person = personService.personFromUsername(sspUser.getUsername());
			if(person!=null){
				sspUser.setPerson(person);
			}
		}
		
		return sspUser;
	}
}
