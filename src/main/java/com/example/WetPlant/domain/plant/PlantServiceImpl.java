package com.example.WetPlant.domain.plant;

import com.example.WetPlant.core.EmailServiceImpl;
import com.example.WetPlant.core.generic.ExtendedRepository;
import com.example.WetPlant.core.generic.ExtendedServiceImpl;
import com.example.WetPlant.domain.user.User;
import com.example.WetPlant.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@EnableScheduling
public class PlantServiceImpl extends ExtendedServiceImpl<Plant> implements PlantService {

    @Autowired
    private final PlantRepository plantRepository;
    private final UserService userService;
    private final EmailServiceImpl emailService;

    protected PlantServiceImpl(ExtendedRepository<Plant> repository, PlantRepository plantRepository, UserService userService, EmailServiceImpl emailService) {
        super(repository);
        this.plantRepository = plantRepository;
        this.userService = userService;
        this.emailService = emailService;
    }

    @Override
    public List<Plant> findAllbyUser() {
        return plantRepository.getPlantsByCreatedBy(userService.getCurrentUser());
    }

    //@Scheduled(cron = "0 0 0 * * 1") every Monday check
   // @Scheduled(cron = "*/10 * * * * *")
    public void sendAMail() {

        List<User> allUsers = userService.findAll();
        System.out.println(allUsers);
        allUsers.forEach(user -> {
            if(isDateTimeOlderThanWeek(plantRepository.findLatestPlantByUser(user.getId()).getDate())) {
                //emailService.sendSimpleMessage("basil.peter@hotmail.ch","PLANTS","We are Thirsty");
            }
        });
    }

    public boolean isDateTimeOlderThanWeek(LocalDate localDate) {
        LocalDate now = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(localDate, now);
        return daysBetween > 7;
    }


}
