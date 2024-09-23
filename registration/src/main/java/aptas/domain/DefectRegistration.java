package aptas.domain;

import aptas.RegistrationApplication;
import aptas.domain.DefectCancelled;
import aptas.domain.DefectRegistered;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DefectRegistration_table")
@Data
//<<< DDD / Aggregate Root
public class DefectRegistration {

    @Id
    private String defectType;

    private String defectImage;

    private String defectVideo;

    private String address;

    private String description;

    private String status;

    private Integer qty;

    private String phoneNumber;

    private String defectId;

    private Date defectregistrationDt;

    @PostPersist
    public void onPostPersist() {
        DefectCancelled defectCancelled = new DefectCancelled(this);
        defectCancelled.publishAfterCommit();

        DefectRegistered defectRegistered = new DefectRegistered(this);
        defectRegistered.publishAfterCommit();
    }

    public static DefectRegistrationRepository repository() {
        DefectRegistrationRepository defectRegistrationRepository = RegistrationApplication.applicationContext.getBean(
            DefectRegistrationRepository.class
        );
        return defectRegistrationRepository;
    }

    public void cancelDefect() {
        //implement business logic here:

        DefectCancelled defectCancelled = new DefectCancelled(this);
        defectCancelled.publishAfterCommit();
    }

    public void registerDefect() {
        //implement business logic here:

        DefectRegistered defectRegistered = new DefectRegistered(this);
        defectRegistered.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void updateStatus(DefectCompleted defectCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        DefectRegistration defectRegistration = new DefectRegistration();
        repository().save(defectRegistration);

        */

        /** Example 2:  finding and process
        
        repository().findById(defectCompleted.get???()).ifPresent(defectRegistration->{
            
            defectRegistration // do something
            repository().save(defectRegistration);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(DefectRejected defectRejected) {
        //implement business logic here:

        /** Example 1:  new item 
        DefectRegistration defectRegistration = new DefectRegistration();
        repository().save(defectRegistration);

        */

        /** Example 2:  finding and process
        
        repository().findById(defectRejected.get???()).ifPresent(defectRegistration->{
            
            defectRegistration // do something
            repository().save(defectRegistration);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
