package aptas.infra;

import aptas.config.kafka.KafkaProcessor;
import aptas.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DefectManagementRepository defectManagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DefectRegistered'"
    )
    public void wheneverDefectRegistered_DefectRegistrationRequest(
        @Payload DefectRegistered defectRegistered
    ) {
        DefectRegistered event = defectRegistered;
        System.out.println(
            "\n\n##### listener DefectRegistrationRequest : " +
            defectRegistered +
            "\n\n"
        );

        // Sample Logic //
        DefectManagement.defectRegistrationRequest(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DefectCancelled'"
    )
    public void wheneverDefectCancelled_RequestToRejectDefect(
        @Payload DefectCancelled defectCancelled
    ) {
        DefectCancelled event = defectCancelled;
        System.out.println(
            "\n\n##### listener RequestToRejectDefect : " +
            defectCancelled +
            "\n\n"
        );

        // Sample Logic //
        DefectManagement.requestToRejectDefect(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
