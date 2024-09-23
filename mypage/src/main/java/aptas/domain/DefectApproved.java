package aptas.domain;

import aptas.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DefectApproved extends AbstractEvent {

    private Long defectId;
    private String defectType;
    private String defectImage;
    private String defectVideo;
    private String address;
    private String description;
    private String phoneNumber;
    private Date defectmanagementDT;
    private String status;
}
