package aptas.domain;

import aptas.ManagementApplication;
import aptas.domain.DefectApproved;
import aptas.domain.DefectRejected;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DefectManagement_table")
@Data
//<<< DDD / Aggregate Root
public class DefectManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long defectId;

    private String defectType;

    private String defectImage;

    private String defectVideo;

    private String address;

    private String description;

    private String phoneNumber;

    private Date defectmanagementDt;

    private String status;

    @PostPersist
    public void onPostPersist() {
        DefectApproved defectApproved = new DefectApproved(this);
        defectApproved.publishAfterCommit();

        DefectRejected defectRejected = new DefectRejected(this);
        defectRejected.publishAfterCommit();
    }

    public static DefectManagementRepository repository() {
        DefectManagementRepository defectManagementRepository = ManagementApplication.applicationContext.getBean(
            DefectManagementRepository.class
        );
        return defectManagementRepository;
    }

    public void defectApproved() {
        //implement business logic here:

        DefectApproved defectApproved = new DefectApproved(this);
        defectApproved.publishAfterCommit();
    }

    public void defectRejected() {
        //implement business logic here:

        DefectRejected defectRejected = new DefectRejected(this);
        defectRejected.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void defectRegistrationRequest(
        DefectRegistered defectRegistered
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        DefectManagement defectManagement = new DefectManagement();
        repository().save(defectManagement);

        */

        /** Example 2:  finding and process
        
        repository().findById(defectRegistered.get???()).ifPresent(defectManagement->{
            
            defectManagement // do something
            repository().save(defectManagement);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void requestToRejectDefect(DefectCancelled defectCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        DefectManagement defectManagement = new DefectManagement();
        repository().save(defectManagement);

        */

        /** Example 2:  finding and process
        
        repository().findById(defectCancelled.get???()).ifPresent(defectManagement->{
            
            defectManagement // do something
            repository().save(defectManagement);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
