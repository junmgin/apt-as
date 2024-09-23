package aptas.domain;

import aptas.domain.*;
import aptas.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DefectCancelled extends AbstractEvent {

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
}
