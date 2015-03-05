package com.zhang3r.travel;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhang3r.travel.util.UUIDUtil;

@Controller
public class MainController {
	@Autowired
	private UUIDUtil uuidService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		String userId = uuidService.generateId();
		userId = userId.substring(0, 10);
		return "redirect:/" + userId + "/";
	}
}
