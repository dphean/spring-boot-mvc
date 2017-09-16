package com.dmp.demo.controller;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmp.demo.domain.Greet;
import com.dmp.demo.error.YouException;

@RestController
@RequestMapping("/greeting/{grp}")
public class GreetingController {
	private final static Log log = LogFactory.getLog(GreetingController.class);
	
	@RequestMapping(path = "/greet/{id}", method = RequestMethod.GET)
	public Greet greet(@PathVariable int grp
			, @PathVariable long id
			, @MatrixVariable(name="color", pathVar="id", required=true , defaultValue="-1") int q
			, @MatrixVariable(name="back", pathVar="id", required=true , defaultValue="") String b
			, @MatrixVariable(name="arra", pathVar="id", required=true, defaultValue="") String[] a
			) throws YouException {
		
		// /greeting/23;rr=34/greet/50455;color=90;back=ffss;arra=[were,here]
		// WebConfig - requestMappingHandlerMapping.setRemoveSemicolonContent(false);

		log.debug(grp);
		log.info(id);
		log.info(q);
		log.info(b);
		log.info(ToStringBuilder.reflectionToString(a, ToStringStyle.DEFAULT_STYLE));
		return new Greet(grp, id, q, b);
	}
}
