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
    DefectRegistrationRepository defectRegistrationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DefectCompleted'"
    )
    public void wheneverDefectCompleted_UpdateStatus(
        @Payload DefectCompleted defectCompleted
    ) {
        DefectCompleted event = defectCompleted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + defectCompleted + "\n\n"
        );

        // Sample Logic //
        DefectRegistration.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DefectRejected'"
    )
    public void wheneverDefectRejected_UpdateStatus(
        @Payload DefectRejected defectRejected
    ) {
        DefectRejected event = defectRejected;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + defectRejected + "\n\n"
        );

        // Sample Logic //
        DefectRegistration.updateStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
