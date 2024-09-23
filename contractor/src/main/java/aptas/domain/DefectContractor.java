package aptas.domain;

import aptas.ContractorApplication;
import aptas.domain.DefectCompleted;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DefectContractor_table")
@Data
//<<< DDD / Aggregate Root
public class DefectContractor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long defectId;

    private String status;

    private Date defectDt;

    private String defectType;

    private String address;

    private String phoneNumber;

    @PostUpdate
    public void onPostUpdate() {
        DefectCompleted defectCompleted = new DefectCompleted(this);
        defectCompleted.publishAfterCommit();
    }

    public static DefectContractorRepository repository() {
        DefectContractorRepository defectContractorRepository = ContractorApplication.applicationContext.getBean(
            DefectContractorRepository.class
        );
        return defectContractorRepository;
    }

    //<<< Clean Arch / Port Method
    public static void contractorOrderRequest(DefectApproved defectApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        DefectContractor defectContractor = new DefectContractor();
        repository().save(defectContractor);

        */

        /** Example 2:  finding and process
        
        repository().findById(defectApproved.get???()).ifPresent(defectContractor->{
            
            defectContractor // do something
            repository().save(defectContractor);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void contractorOrderCancel(DefectRejected defectRejected) {
        //implement business logic here:

        /** Example 1:  new item 
        DefectContractor defectContractor = new DefectContractor();
        repository().save(defectContractor);

        */

        /** Example 2:  finding and process
        
        repository().findById(defectRejected.get???()).ifPresent(defectContractor->{
            
            defectContractor // do something
            repository().save(defectContractor);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
