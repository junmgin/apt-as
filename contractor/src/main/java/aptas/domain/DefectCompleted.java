package aptas.domain;

import aptas.domain.*;
import aptas.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DefectCompleted extends AbstractEvent {

    private Long defectId;
    private String status;
    private Date defectDt;
    private String defectType;
    private String address;
    private String phoneNumber;

    public DefectCompleted(DefectContractor aggregate) {
        super(aggregate);
    }

    public DefectCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
