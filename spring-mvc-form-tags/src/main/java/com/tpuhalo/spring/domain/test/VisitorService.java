package com.tpuhalo.spring.domain.test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VisitorService {

	public VisitorCount updateCount(VisitorCount vc) {
		vc.setCount(vc.getCount() + 1);
		return vc;
	}

	public void registerVisitor(VisitorData sessionData, VisitorData incomingVisitor) {
		List<Visitor> visitors = sessionData.getVisitors();
		sessionData.setCurrentVisitorName(incomingVisitor.getCurrentVisitorName());
		sessionData.setCurrentVisitorEmail(incomingVisitor.getCurrentVisitorEmail());
		visitors.add(new Visitor(incomingVisitor.getCurrentVisitorName(), incomingVisitor.getCurrentVisitorEmail()));
	}

	public Long computerDuration(LocalDateTime sessionStartTime) {
		Duration sessionDuration = Duration.between(sessionStartTime, LocalDateTime.now());
		return sessionDuration.getSeconds();
	}

	public String describeCurrentTime(LocalDateTime currentTime) {
		return new StringBuilder().append("Current local time is ").append(currentTime.getHour()).append(":")
				.append(currentTime.getMinute()).append(":").append(currentTime.getSecond()).toString();
	}

	public String describeCurrentDuration(Long currentDuration) {
		long second = (currentDuration).longValue();
		return new StringBuilder().append(" Session duration is ").append(second).append(" seconds.").toString();
	}
}
