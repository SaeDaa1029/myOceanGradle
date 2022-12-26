package com.example.myoceanproject.dtoTest;

import com.example.myoceanproject.domain.*;
import com.example.myoceanproject.entity.Alarm;
import com.example.myoceanproject.entity.Diary;
import com.example.myoceanproject.entity.QuestAchievement;
import com.example.myoceanproject.entity.User;
import com.example.myoceanproject.repository.DiaryRepository;
import com.example.myoceanproject.repository.UserRepository;
import com.example.myoceanproject.type.ReadStatus;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//import static com.example.myoceanproject.entity.QAlarm.alarm;
import static com.example.myoceanproject.entity.QDiary.diary;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class DiaryTest {
    @Autowired
    private DiaryRepository diaryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    public void saveDiaryTest(){
        Optional<User> user = userRepository.findById(326L);
//        Optional<User> receiverUser = userRepository.findById(2L);

//      diaryDTO에 필요한 값 저장
        DiaryDTO diaryDTO = new DiaryDTO();
        diaryDTO.setDiaryTitle("홍길동의 첫 번째 일기");
        diaryDTO.setDiaryContent("오늘 휴가를 냈다 사무실에 있기가 싫었다. 오전에 커피숍에 가서 생각정리도 하고 아내 지원서 작성하는 것도 봐주고 알차게 보내야지");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary1 = diaryDTO.toEntity();
        diary1.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary1);

        diaryDTO.setDiaryTitle("홍길동의 두 번째 일기, 집 근처 스벅에서");
        diaryDTO.setDiaryContent("아침에 하려고 했던 아내 지원서는 완성했다 휴가에 일하는 기분이었지만 마치고 나니 뿌듯하네. 아내가 좋은결과가 있었으면 한다.");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary2 = diaryDTO.toEntity();
        diary2.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary2);

        diaryDTO.setDiaryTitle("홍길동의 세 번째 일기, 안과에서");
        diaryDTO.setDiaryContent("갑자기 눈이 부셔서 눈 뜨기가 힘들어 안과를 갔는데, 녹내장 의심..ㅠㅠ 다행히 검사결과는 큰 문제없는데 앞으로 녹내장 가능성이...");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary3 = diaryDTO.toEntity();
        diary3.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary3);

        diaryDTO.setDiaryTitle("홍길동의 네 번째 일기, 집에서");
        diaryDTO.setDiaryContent("아..이 기분 뭐지? 정말..혹시 기대한거? 나를 보자..그 동안 나의 불평, 불만 그렇다 당연하고 옳은 결과다 자의식 해체하자!");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary4 = diaryDTO.toEntity();
        diary4.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary4);

        diaryDTO.setDiaryTitle("홍길동의 다섯 번째 일기, 아들 공부방에서");
        diaryDTO.setDiaryContent("새벽에 잠이 깨서 월드컵 축구를 봤다 아무 생각없이..이제 커피한잔을 마시고 책을 읽어야겠다 내 마음이 흘러가는대로 지켜보자");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary5 = diaryDTO.toEntity();
        diary5.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary5);

        diaryDTO.setDiaryTitle("홍길동의 여섯 번째 일기, 국수집에서");
        diaryDTO.setDiaryContent("저녁먹으러 가족 총출동..동네국수집^^ 아~ 배고파요~빨리주세요~~^^");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary6 = diaryDTO.toEntity();
        diary6.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary6);


        diaryDTO.setDiaryTitle("홍길동의 일곱 번째 일기, 거실에서");
        diaryDTO.setDiaryContent("어제 축구보고 한 잔 했다고 왜 이리 피곤한지..진짜 나이 먹은거 같음..ㅠ 세수하는데 코피도 나고..건강에 신경써야겠다.");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary7 = diaryDTO.toEntity();
        diary7.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary7);

        diaryDTO.setDiaryTitle("홍길동의 여덟 번째 일기, 주방에서");
        diaryDTO.setDiaryContent("주말은 왜 이렇게 빨리 지나가는건지..낼 출근할 생각하니 답답하다..약간의 공허함이 내 주위를 둘러싸고 있는것 같다..한숨을 휴~~");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary8 = diaryDTO.toEntity();
        diary8.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary8);

        diaryDTO.setDiaryTitle("홍길동의 아홉 번째 일기, 출근 후 사무실에서");
        diaryDTO.setDiaryContent("승진 결과를 보니 참..생각보다 마음이 차분한 이유는 뭘까..? 자의식 해체..당분간 내 모든것을 자의식해체 하는데 집중하자!할수있다!!");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary9 = diaryDTO.toEntity();
        diary9.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary9);

        diaryDTO.setDiaryTitle("홍길동의 열 번째 일기, 사무실에서");
        diaryDTO.setDiaryContent("일하기가 싫어서 계속 다른것을 하고 있다..무엇이 문제일까?내 마음이 문제겠지..그냥 지금은 제 마음이 흘러가는대로 지켜봐야겠다.");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary10 = diaryDTO.toEntity();
        diary10.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary10);

        diaryDTO.setDiaryTitle("홍길동의 열한 번째 일기, 주방에서");
        diaryDTO.setDiaryContent("어떻게 하면 정말 내면의 목소리를 듣고 솔직하게 나와 대화할 수 있을까.. 다른 사람들의 시선을 생각하지 않고..여전히 고민이다..");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary11 = diaryDTO.toEntity();
        diary11.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary11);

        diaryDTO.setDiaryTitle("홍길동의 열두 번째 일기, 사무실에서");
        diaryDTO.setDiaryContent("출근해서 노래들으며 책 읽는 시간이 참 좋다..이런저런 생각도 나고 오늘 하루는 또 어떻게 보내야 하는지..이제 딴 이야기도 해야지");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary12 = diaryDTO.toEntity();
        diary12.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary12);

        diaryDTO.setDiaryTitle("홍길동의 열세 번째 일기, 신논현역에서");
        diaryDTO.setDiaryContent("정말 춥다.. 하필 날씨가 이럴까 하다가 생각을 고쳐먹는다 넘 추워서 머리가 언것 같다 생각이 멈췄다..");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary13 = diaryDTO.toEntity();
        diary13.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary13);

        diaryDTO.setDiaryTitle("홍길동의 열네 번째 일기, 버스안에서");
        diaryDTO.setDiaryContent("행사 끝나고 집에가는길..왜 이렇게 피곤하지 올해들어 가장 추운날..추운데 있다가 따뜻한 버스안에서 졸립다..");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary14 = diaryDTO.toEntity();
        diary14.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary14);

        diaryDTO.setDiaryTitle("홍길동의 열다섯 번째 일기, 출근후 사무실에서");
        diaryDTO.setDiaryContent("청 부분이전 설명회 자료를 보니 불쑥 화가 치밀어 오른다..원래 기대도 안했는데 그럴 필요도 없다 이것 또한 자의식이겠지..탐색하자..");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary15 = diaryDTO.toEntity();
        diary15.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary15);

        diaryDTO.setDiaryTitle("홍길동의 열여섯 번째 일기, 맥주마시며 안방에서");
        diaryDTO.setDiaryContent("정답은 없다 다만 선택과 그에 대한 결과가 있을뿐..어떤 선택을 해야할까?마음은 옮기라하고 현실은 그게 아닌것 같고..모르겠다..");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary16 = diaryDTO.toEntity();
        diary16.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary16);

        diaryDTO.setDiaryTitle("홍길동의 열일곱 번째 일기, 운동하다가 거실에서");
        diaryDTO.setDiaryContent("결국 과장님께 업무조정 관련 말씀을 못드렸다..담주 월욜엔 꼭 해야겠다 주말에 정리도 좀 하고 내 마음의 소리를 따라가 보자.");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary17 = diaryDTO.toEntity();
        diary17.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary17);

        diaryDTO.setDiaryTitle("홍길동의 열여덟 번째 일기, 주방에서");
        diaryDTO.setDiaryContent("아침 커피한잔의 여유..좋다..밖에서는 눈이 소리없이 내린다 지금 이 순간을 온전히 즐기자 carpe diem!");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary18 = diaryDTO.toEntity();
        diary18.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary18);

        diaryDTO.setDiaryTitle("홍길동의 열아홉 번째 일기, 독서하며 거실에서");
        diaryDTO.setDiaryContent("경제적 자유를 위한 5가지 공부법, 내 블로그에 정리하기");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary19 = diaryDTO.toEntity();
        diary19.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary19);

        diaryDTO.setDiaryTitle("홍길동의 스무 번째 일기, 침실에서");
        diaryDTO.setDiaryContent("블로그마케팅 책을 빌렸다..첫걸음 떼는게 중요하다..이제 첫걸음 아주 조금씩 조금씩 나아가자 과정을 즐기면서 나는 이미 이루었다");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary20 = diaryDTO.toEntity();
        diary20.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary20);

        diaryDTO.setDiaryTitle("홍길동의 스물한 번째 일기, 아침 사무실에서");
        diaryDTO.setDiaryContent("어제 회식이라 차를 두고와서 아침 출근이 너무 춥고 불편했다..아침부터 피곤하지만 오늘도 힘을 내 보자 과 명칭도 바꼈으니..");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary21 = diaryDTO.toEntity();
        diary21.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary21);

        diaryDTO.setDiaryTitle("홍길동의 스물두 번째 일기, 운동하다가 거실에서");
        diaryDTO.setDiaryContent("결국 과장님께 업무조정 관련 말씀을 못드렸다..담주 월욜엔 꼭 해야겠다 주말에 정리도 좀 하고 내 마음의 소리를 따라가 보자.");
        diaryDTO.setDiaryCategory("나의 일기");
//        diaryDTO 엔티티화
        Diary diary22 = diaryDTO.toEntity();
        diary22.setUser(user.get());
//        diary1.setReceiverUser(receiverUser.get());

//      diary 엔티티에 해당 값들을 모두 저장
        diaryRepository.save(diary22);
    }
//
//    @Test
//    public void findAllTest(){
//        List<DiaryDTO> diaries = jpaQueryFactory.select(new QDiaryDTO(
//                diary.user.userId,
//                diary.diaryTitle,
//                diary.diaryContent,
//                diary.receiverUser.userId
//        )).from(diary).fetch();
//
//        log.info("------------------------------------------------------------");
//        diaries.stream().map(DiaryDTO::toString).forEach(log::info);
//        log.info("------------------------------------------------------------");
//
//    }
//
//    @Test
//    public void findById(){
//        List<DiaryDTO> diaries = jpaQueryFactory.select(new QDiaryDTO(
//                diary.user.userId,
//                diary.diaryTitle,
//                diary.diaryContent,
//                diary.receiverUser.userId
//        )).from(diary).where(diary.receiverUser.userId.eq(2L)).fetch();
//
//        log.info("------------------------------------------------------------");
//        diaries.stream().map(DiaryDTO::toString).forEach(log::info);
//        log.info("------------------------------------------------------------");
//    }
//
//    @Test
//    public void deleteTest(){
//        Diary diary = diaryRepository.findById(7L).get();
//        diaryRepository.delete(diary);
//    }
//

}
