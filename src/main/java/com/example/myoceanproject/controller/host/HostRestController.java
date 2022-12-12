package com.example.myoceanproject.controller.host;

import com.example.myoceanproject.domain.GroupDTO;
import com.example.myoceanproject.domain.GroupScheduleDTO;
import com.example.myoceanproject.entity.Group;
import com.example.myoceanproject.entity.GroupMember;
import com.example.myoceanproject.repository.GroupMemberRepository;
import com.example.myoceanproject.repository.GroupRepository;
import com.example.myoceanproject.repository.UserRepository;
import com.example.myoceanproject.service.GroupScheduleService;
import com.example.myoceanproject.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/host/*")
public class HostRestController {

    private final GroupService groupService;
    private final GroupRepository groupRepository;
    private final GroupScheduleService groupScheduleService;
    private final GroupMemberRepository groupMemberRepository;
    private final UserRepository userRepository;


    // 모임 게시글 임시 저장
    @PostMapping(value="/index", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public Long host(@RequestBody GroupDTO groupDTO, HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session=request.getSession();

        Long userId = (Long) session.getAttribute("userId");
        groupDTO.setUserId(userId);

        /*Group 테이블 저장*/
        groupService.add(groupDTO);
//        return new ResponseEntity<>(new String("register success".getBytes(), "UTF-8"), HttpStatus.OK);
        return groupDTO.getGroupId();
    }

    // 모임 멤버 테이블 생성
    @PostMapping("/group-member/{groupId}")
    public ResponseEntity<String> groupMember(@PathVariable("groupId") Long groupId, HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session=request.getSession();
        GroupMember groupMember = new GroupMember();

        /*user 저장*/
        Long userId = (Long) session.getAttribute("userId");
        groupMember.setUser(userRepository.findById(userId).get());

        /*Group 저장*/
        groupMember.setGroup(groupRepository.findById(groupId).get());
        groupMemberRepository.save(groupMember);
        log.info(groupMember.toString());

        return new ResponseEntity<>(new String("register success".getBytes(), "UTF-8"), HttpStatus.OK);
    }

    // 모임 멤버 취소 시 테이블에서 삭제
    @PostMapping("/group-member-delete/{groupId}")
    public ResponseEntity<String> groupMemberDelete(@PathVariable("groupId") Long groupId, HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session=request.getSession();

        /*user 저장*/
        Long userId = (Long) session.getAttribute("userId");

        /*멤버삭제*/
        groupService.deleteMember(userId, groupId);

        return new ResponseEntity<>(new String("register success".getBytes(), "UTF-8"), HttpStatus.OK);
    }

    // 스케줄 저장
    @PostMapping(value="/addDate/{groupId}", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> schedule(@RequestBody GroupScheduleDTO groupScheduleDTO, @PathVariable("groupId") Long groupId) throws UnsupportedEncodingException {

        groupScheduleDTO.setGroupId(groupId);

        groupService.addSchedule(groupScheduleDTO);
        return new ResponseEntity<>(new String("register success".getBytes(), "UTF-8"), HttpStatus.OK);
    }


    // 스케줄 출력
    @GetMapping("/date-list/{groupId}")
    public List<GroupScheduleDTO> getSchedule(@PathVariable("groupId") Long groupId){
        List<GroupScheduleDTO> groupScheduleDTO = groupService.findAllByGroupId(groupId);
        return groupScheduleDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping(value="/update", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> hostUpdate(@RequestBody GroupDTO groupDTO, HttpServletRequest request) throws UnsupportedEncodingException {

        HttpSession session=request.getSession();
        Long userId = (Long)session.getAttribute("userId");
        groupDTO.setUserId(userId);
        groupDTO.setGroupStatus("임시저장");
        /*groupDTO로 받아온 값의 groupId를 엔티티화하여 group을 찾는다.*/
        Group group = groupRepository.findById(groupDTO.getGroupId()).get();
        log.info(groupDTO.toString());
        /*그룹 안에 선언한 update메소드를 통해 groupDTO로 받아온 값으로 값을 수정한다.*/
        group.update(groupDTO);
        log.info(group.toString());

        return new ResponseEntity<>(new String("register success".getBytes(), "UTF-8"), HttpStatus.OK);
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping(value="/update-status", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> hostStatusUpdate(@RequestBody GroupDTO groupDTO, HttpServletRequest request) throws UnsupportedEncodingException {

        HttpSession session=request.getSession();
        Long userId = (Long)session.getAttribute("userId");
        groupDTO.setUserId(userId);
        groupDTO.setGroupStatus("승인대기");
        /*groupDTO로 받아온 값의 groupId를 엔티티화하여 group을 찾는다.*/
        Group group = groupRepository.findById(groupDTO.getGroupId()).get();
        log.info(groupDTO.toString());
        /*그룹 안에 선언한 update메소드를 통해 groupDTO로 받아온 값으로 값을 수정한다.*/
        group.update(groupDTO);
        log.info(group.toString());

        return new ResponseEntity<>(new String("register success".getBytes(), "UTF-8"), HttpStatus.OK);
    }

    @PostMapping("/thumbnail")
    public List<GroupDTO> upload(List<MultipartFile> upload) throws IOException {
        String rootPath = "C:/upload/group";
        String uploadFileName = null;
        List<GroupDTO> files = new ArrayList<>();

        File uploadPath = new File(rootPath, createDirectoryByNow());
        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }

        for(MultipartFile multipartFile : upload){
            GroupDTO groupDTO = new GroupDTO();
            UUID uuid = UUID.randomUUID();
            String fileName = multipartFile.getOriginalFilename();
            String fileUuid = uuid.toString();
            String groupFilePath = createDirectoryByNow();
            Long groupFileSize = multipartFile.getSize();
            uploadFileName = uuid.toString() + "_" + fileName;

            log.info("==========================");
            log.info(fileName);
            log.info(fileUuid);
            log.info(uploadFileName);
            log.info(groupFilePath);
            log.info(groupFileSize+"");
            log.info("==========================");

            groupDTO.setGroupFileName(fileName);
            groupDTO.setGroupFileUuid(fileUuid);
            groupDTO.setGroupFileSize(multipartFile.getSize());
            groupDTO.setGroupFilePath(groupFilePath);

            try{
                File saveGroupFile = new File(uploadPath, uploadFileName);
                multipartFile.transferTo(saveGroupFile);
            } catch(Exception e){
                log.error(e.getMessage());
            }
            files.add(groupDTO);
        }
        return files;
    }

    @GetMapping("/display")
    public byte[] display(String fileName) throws IOException{
        File file = new File("C:/upload/group", fileName);
        return FileCopyUtils.copyToByteArray(file);
    }

    @PostMapping("/delete")
    public void delete(String uploadPath, String fileName){
        File file = new File("C:/upload/group", uploadPath + "/" + fileName);
        if(file.exists()){
            file.delete();
        }
    }

    @PostMapping("/delete-schedule/{groupId}/{scheduleDate}")
    public void deleteSchedule(@PathVariable("groupId") Long groupId, @PathVariable("scheduleDate") String scheduleDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd");
        List<GroupScheduleDTO> groupScheduleDTOs = groupService.findAllByGroupId(groupId);
        Long groupScheduleId=0L;
        for(GroupScheduleDTO groupScheduleDTO : groupScheduleDTOs){
            Date date = java.sql.Timestamp.valueOf(groupScheduleDTO.getGroupScheduleDate());
            String simpleDate = String.valueOf(date).split(" ")[0];
            log.info("simpleDate: " + simpleDate);
            log.info("scheduleDate" + scheduleDate);
            if(simpleDate.equals(scheduleDate)){
                groupScheduleId = groupScheduleDTO.getGroupScheduleId();
            };
        }
        groupScheduleService.delete(groupScheduleId);
    }

    public String createDirectoryByNow(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date now = new Date();
        return format.format(now);
    }

    public boolean checkImageType(File file) throws IOException{
        return Files.probeContentType(file.toPath()).startsWith("image");
    }


    //썸머노트
    @ResponseBody
    @PostMapping("/summernote")
    public void summerImage(MultipartFile file, HttpServletRequest request,
                            HttpServletResponse response) throws Exception {

        response.setContentType("text/html;charset=utf-8");
        String uploadPath = "C:/upload/groupUpload/";

        PrintWriter out = response.getWriter();
        String originalFileExtension = file.getOriginalFilename();
        String storedFileName = UUID.randomUUID().toString().replaceAll("-", "");// + originalFileExtension
        log.info("storedFileName : " + storedFileName);
        log.info("originalFileExtension : " + originalFileExtension);
        log.info(file.toString());
        log.info(uploadPath+storedFileName);
        file.transferTo(new File(uploadPath + storedFileName + originalFileExtension));
        out.println("/upload/groupUpload/"+storedFileName + originalFileExtension);
        out.close();
    }
}

