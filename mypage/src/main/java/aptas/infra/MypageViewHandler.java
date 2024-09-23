package aptas.infra;

import aptas.config.kafka.KafkaProcessor;
import aptas.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MypageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDefectRegistered_then_CREATE_1(
        @Payload DefectRegistered defectRegistered
    ) {
        try {
            if (!defectRegistered.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setDefectId(Long.valueOf(defectRegistered.getDefectId()));
            mypage.setDefectType(defectRegistered.getDefectType());
            mypage.setStatus(defectRegistered.getStatus());
            mypage.setQty(defectRegistered.getQty());
            mypage.setDefectId(Long.valueOf(defectRegistered.getDefectId()));
            mypage.setDefectType(defectRegistered.getDefectType());
            mypage.setStatus(defectRegistered.getStatus());
            mypage.setQty(defectRegistered.getQty());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDefectApproved_then_UPDATE_1(
        @Payload DefectApproved defectApproved
    ) {
        try {
            if (!defectApproved.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDefectRejected_then_UPDATE_2(
        @Payload DefectRejected defectRejected
    ) {
        try {
            if (!defectRejected.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDefectCompleted_then_UPDATE_3(
        @Payload DefectCompleted defectCompleted
    ) {
        try {
            if (!defectCompleted.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
