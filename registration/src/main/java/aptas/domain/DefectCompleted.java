package aptas.domain;

import aptas.domain.*;
import aptas.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DefectCompleted extends AbstractEvent {

    private Long defectId;
    private String status;
    private Date defectDt;
    private String defectType;
    private String address;
    private String phoneNumber;
}
