package by.intexsoft.course.scheduling;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import by.intexsoft.course.model.Tour;
import by.intexsoft.course.service.TourService;

@Component
public class ScheduleTask {
	
	@Autowired
	TourService tourService;
	
	@Scheduled(fixedDelay = 100000 )
    public void fixedDelaySchedule() {
       
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		long timeInMillisNow = calendar.getTimeInMillis();
		
		List<Tour> allActiveTour = tourService.findForArchive();
		for (Tour tour : allActiveTour) {
			calendar.setTime(tour.startDate);
			long timeInMillisStartDate = calendar.getTimeInMillis();
			if (timeInMillisNow > timeInMillisStartDate){
				tour.archive = true;
				if(!tour.paid){
					tour.booking = null;
					tour.user = null;
				}
				tourService.update(tour);
			}
		}		
		
    }	
}
