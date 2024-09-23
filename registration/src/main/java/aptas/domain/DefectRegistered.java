package aptas.domain;

import aptas.domain.*;
import aptas.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DefectRegistered extends AbstractEvent {

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

    public DefectRegistered(DefectRegistration aggregate) {
        super(aggregate);
    }

    public DefectRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
