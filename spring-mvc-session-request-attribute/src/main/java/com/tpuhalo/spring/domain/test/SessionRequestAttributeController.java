package com.tpuhalo.spring.domain.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(names = { "visitordata", "visitorcount" })
@RequestMapping("/visitorRegister")
public class SessionRequestAttributeController {

	@Autowired
	public VisitorService visitorService;

//	private static Logger logger = LoggerFactory.getLogger(SessionRequestAttributeController.class);

	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("test/sessionRequestAttributeViews/sessionRequestAttributeHome", "visitorstats",
				new VisitorData());
	}

	@ModelAttribute("visitordata")
	public VisitorData addVisitorData() {
		List<Visitor> visitors = new ArrayList<Visitor>();
		VisitorData vData = new VisitorData(null, null, visitors);
		return vData;
	}

	@ModelAttribute("visitorcount")
	public VisitorCount countVisitors() {
		return new VisitorCount(0);
	}

	@RequestMapping(value = "/visitor")
	public String getVisitors(@ModelAttribute("visitor") VisitorData currentVisitor, HttpSession session,
			SessionStatus status, HttpServletRequest request,
			@SessionAttribute(name = "sessionStartTime") LocalDateTime startTime,
			@RequestAttribute(name = "currentTime") LocalDateTime clockTime, Model model) {
		VisitorData visitorDataFromSession = (VisitorData) session.getAttribute("visitordata");
		visitorService.registerVisitor(visitorDataFromSession, currentVisitor);
		VisitorCount visitorCount = (VisitorCount) session.getAttribute("visitorcount");
		visitorService.updateCount(visitorCount);

		Long currentSessionDuration = visitorService.computerDuration(startTime);

		if (visitorCount.getCount() == 5) {
			status.setComplete();
//			session.invalidate();
		}

//		model.addAttribute("timeHeading", visitorService.describeCurrentTime(clockTime));
//		model.addAttribute("durationHeading", visitorService.describeCurrentDuration(currentSessionDuration));

		Map<String, Object> modelMap = model.asMap();
		modelMap.put("timeHeading", visitorService.describeCurrentTime(clockTime));
		modelMap.put("durationHeading", visitorService.describeCurrentDuration(currentSessionDuration));
		
		
		// // debug code
		// logger.info(visitorDataFromSession.toString());
		// if (request.getMethod().equals("POST")) {
		// logger.info("This is POST request");
		// } else {
		// logger.info("This is GET request");
		// }

		return "test/sessionRequestAttributeViews/sessionRequestAttributeResult";
	}
}
