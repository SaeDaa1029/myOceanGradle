package com.example.myoceanproject.repository.chatting;

import com.example.myoceanproject.domain.ChattingDTO;
import com.example.myoceanproject.domain.GroupDTO;
import com.example.myoceanproject.domain.QChattingDTO;
import com.example.myoceanproject.domain.QGroupDTO;
import com.example.myoceanproject.entity.GroupMember;
import com.example.myoceanproject.repository.chatting.ChattingCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.myoceanproject.entity.QChatting.chatting;
import static com.example.myoceanproject.entity.QGroup.group;
import static com.example.myoceanproject.entity.QGroupMember.groupMember;

@Repository
@RequiredArgsConstructor
public class ChattingRepositoryImpl implements ChattingCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<GroupMember> findByGroupId(Long groupId) {
        return queryFactory.select(groupMember)
                .from(groupMember)
                .where(groupMember.group.groupId.eq(groupId))
                .fetch();
    }

    //    유저 아이디를 받아서 받은 유저 정보와 그룹 멤버 테이블의 유저 정보가 일치할 경우 그룹 아이디를 가지고 옴
    @Override
    public List<GroupDTO> findByUserId(Long userId) {
        return queryFactory.select(new QGroupDTO(
                group.groupId,
                group.user.userId,
                group.user.userNickname,
                group.groupName,
                group.groupCategory,
                group.groupContent,
                group.groupPoint,
                group.groupOverSea,
                group.groupLocationName,
                group.groupLocation,
                group.groupLocationDetail,
                group.groupParkingAvailable,
                group.groupMoreInformation,
                group.groupLocationType,
                group.groupStatus,
                group.groupFilePath,
                group.groupFileName,
                group.groupFileUuid,
                group.groupFileSize,
                group.groupMemberLimit.maxMember,
                group.groupMemberLimit.minMember
        )).from(group)
                .join(groupMember)
                .on(groupMember.group.groupId.eq(group.groupId))
                .where(groupMember.user.userId.eq(userId)).fetch();
    }
//
//    @Override
//    public List<ChattingDTO> findChattingContentByUserId(Long userId) {
//        return queryFactory.select(new QChattingDTO(
//                chatting.chattingId,
//                chatting.senderGroupMember.user.userId,
//                chatting.senderGroupMember.user.userNickname,
//                chatting.senderGroupMember.user.userFileName,
//                chatting.senderGroupMember.user.userFilePath,
//                chatting.senderGroupMember.user.userFileSize,
//                chatting.senderGroupMember.user.userFileUuid,
//                chatting.senderGroupMember.group.groupId,
//                chatting.senderGroupMember.group.groupName,
//                chatting.senderGroupMember.group.groupFilePath,
//                chatting.senderGroupMember.group.groupFileName,
//                chatting.senderGroupMember.group.groupFileUuid,
//                chatting.senderGroupMember.group.groupFileSize,
//                chatting.senderGroupMember.groupMemberId,
//                chatting.chattingContent
//        )).from(chatting).join(groupMember).on(chatting.group.group)
//    }


}