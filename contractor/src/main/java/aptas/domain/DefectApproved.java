package aptas.domain;

import aptas.domain.*;
import aptas.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DefectApproved extends AbstractEvent {

    private Long defectId;
    private String defectType;
    private String defectImage;
    private String defectVideo;
    private String address;
    private String description;
    private String phoneNumber;
    private Date defectmanagementDt;
    private String status;
}
