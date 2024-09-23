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
    DefectContractorRepository defectContractorRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DefectApproved'"
    )
    public void wheneverDefectApproved_ContractorOrderRequest(
        @Payload DefectApproved defectApproved
    ) {
        DefectApproved event = defectApproved;
        System.out.println(
            "\n\n##### listener ContractorOrderRequest : " +
            defectApproved +
            "\n\n"
        );

        // Sample Logic //
        DefectContractor.contractorOrderRequest(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DefectRejected'"
    )
    public void wheneverDefectRejected_ContractorOrderCancel(
        @Payload DefectRejected defectRejected
    ) {
        DefectRejected event = defectRejected;
        System.out.println(
            "\n\n##### listener ContractorOrderCancel : " +
            defectRejected +
            "\n\n"
        );

        // Sample Logic //
        DefectContractor.contractorOrderCancel(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
