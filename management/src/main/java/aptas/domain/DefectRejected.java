package aptas.domain;

import aptas.domain.*;
import aptas.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DefectRejected extends AbstractEvent {

    private Long defectId;
    private String defectType;
    private String defectImage;
    private String defectVideo;
    private String address;
    private String description;
    private String phoneNumber;
    private Date defectmanagementDt;
    private String status;

    public DefectRejected(DefectManagement aggregate) {
        super(aggregate);
    }

    public DefectRejected() {
        super();
    }
}
//>>> DDD / Domain Event
