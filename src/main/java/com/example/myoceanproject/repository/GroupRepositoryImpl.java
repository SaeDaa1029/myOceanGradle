package com.example.myoceanproject.repository;

import com.example.myoceanproject.domain.*;
import com.example.myoceanproject.entity.GroupMember;
import com.example.myoceanproject.entity.QGroup;
import com.example.myoceanproject.entity.QGroupMember;
import com.example.myoceanproject.entity.QGroupSchedule;
import com.example.myoceanproject.type.GroupStatus;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static com.example.myoceanproject.entity.QGroup.group;
import static com.example.myoceanproject.entity.QGroupSchedule.groupSchedule;
import static com.example.myoceanproject.entity.QGroupMember.groupMember;

@Repository
@RequiredArgsConstructor
public class GroupRepositoryImpl implements GroupCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<GroupDTO> findAll(){
        return queryFactory.select(new QGroupDTO(
                group.groupId,
                group.user.userId,
                group.user.userFileName,
                group.user.userFilePath,
                group.user.userFileSize,
                group.user.userFileUuid,
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
                group.groupMemberLimit.minMember,
                group.createDate,
                group.updatedDate,
                group.reason
        )).from(group).orderBy(group.groupId.desc()).fetch();
    }

    @Override
    public Page<GroupDTO> findAll(Pageable pageable, Criteria criteria){
        List<GroupDTO> groups = queryFactory.select(new QGroupDTO(
                group.groupId,
                group.user.userId,
                group.user.userFileName,
                group.user.userFilePath,
                group.user.userFileSize,
                group.user.userFileUuid,
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
                group.groupMemberLimit.minMember,
                group.createDate,
                group.updatedDate,
                group.reason
        ))
                .from(group)
                .orderBy(group.groupId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory.selectFrom(group).fetch().size();

        return new PageImpl<>(groups, pageable, total);
    }

    @Override
    public Page<GroupDTO> findAll(Pageable pageable){
        List<GroupDTO> groups = queryFactory.select(new QGroupDTO(
                        group.groupId,
                        group.user.userId,
                        group.user.userFileName,
                        group.user.userFilePath,
                        group.user.userFileSize,
                        group.user.userFileUuid,
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
                        group.groupMemberLimit.minMember,
                        group.createDate,
                        group.updatedDate,
                        group.reason
                ))
                .from(group)
                .orderBy(group.groupId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory.selectFrom(group).fetch().size();

        return new PageImpl<>(groups, pageable, total);
    }

    @Override
    public List<GroupScheduleDTO> findAllSchedule(Long groupId){
        return queryFactory.select(new QGroupScheduleDTO(
                groupSchedule.groupScheduleId,
                groupSchedule.group.groupId,
                groupSchedule.groupScheduleDate,
                groupSchedule.groupScheduleStartTime,
                groupSchedule.groupScheduleEndTime
                )).from(groupSchedule).where(groupSchedule.group.groupId.eq(groupId)).orderBy(groupSchedule.groupScheduleStartTime.asc()).fetch();
    }

    @Override
    public List<GroupDTO> findGroupTop5ByGroupId(Long groupId) {
        return queryFactory.select(new QGroupDTO(
                group.groupId,
                group.user.userId,
                group.user.userFileName,
                group.user.userFilePath,
                group.user.userFileSize,
                group.user.userFileUuid,
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
                group.groupMemberLimit.minMember,
                group.createDate,
                group.updatedDate,
                group.reason
        )).from(group).orderBy(group.groupId.desc()).limit(5L).fetch();
    }

    @Override
    public GroupDTO findGroupByGroupId(Long groupId) {
        return queryFactory.select(new QGroupDTO(
                group.groupId,
                group.user.userId,
                group.user.userFileName,
                group.user.userFilePath,
                group.user.userFileSize,
                group.user.userFileUuid,
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
                group.groupMemberLimit.minMember,
                group.createDate,
                group.updatedDate,
                group.reason
        )).from(group).where(group.groupId.eq(groupId)).fetchOne();
    }

    public Page<GroupDTO> findAllManage(Pageable pageable){
        List<GroupDTO> groups = queryFactory.select(new QGroupDTO(
                group.groupId,
                group.user.userId,
                group.user.userFileName,
                group.user.userFilePath,
                group.user.userFileSize,
                group.user.userFileUuid,
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
                group.groupMemberLimit.minMember,
                group.createDate,
                group.updatedDate,
                group.reason
        ))
        .from(group)
        .orderBy(group.createDate.desc())
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize()).fetch();

        long total = queryFactory.selectFrom(group)
                .fetch().size();

        return new PageImpl<>(groups, pageable, total);
    }
    public Page<GroupDTO> findAllManage(Pageable pageable, Criteria criteria){
        List<GroupDTO> groups = queryFactory.select(new QGroupDTO(
                        group.groupId,
                        group.user.userId,
                        group.user.userFileName,
                        group.user.userFilePath,
                        group.user.userFileSize,
                        group.user.userFileUuid,
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
                        group.groupMemberLimit.minMember,
                        group.createDate,
                        group.updatedDate,
                        group.reason
                ))
                .from(group)
                .where(group.groupName.contains(criteria.getKeyword()))
                .orderBy(group.createDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize()).fetch();

        long total = queryFactory.selectFrom(group)
                .where(group.groupName.contains(criteria.getKeyword()))
                .fetch().size();

        return new PageImpl<>(groups, pageable, total);
    }
    public Page<GroupDTO> findAllByStatus(Pageable pageable, GroupStatus groupStatus){
        List<GroupDTO> groups = queryFactory.select(new QGroupDTO(
                        group.groupId,
                        group.user.userId,
                        group.user.userFileName,
                        group.user.userFilePath,
                        group.user.userFileSize,
                        group.user.userFileUuid,
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
                        group.groupMemberLimit.minMember,
                        group.createDate,
                        group.updatedDate,
                        group.reason
                ))
                .from(group)
                .where(group.groupStatus.eq(groupStatus))
                .orderBy(group.createDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize()).fetch();

        long total = queryFactory.selectFrom(group)
                .where(group.groupStatus.eq(groupStatus))
                .fetch().size();

        return new PageImpl<>(groups, pageable, total);
    }
    public Page<GroupDTO> findAllByStatus(Pageable pageable, GroupStatus groupStatus, Criteria criteria){
        List<GroupDTO> groups = queryFactory.select(new QGroupDTO(
                        group.groupId,
                        group.user.userId,
                        group.user.userFileName,
                        group.user.userFilePath,
                        group.user.userFileSize,
                        group.user.userFileUuid,
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
                        group.groupMemberLimit.minMember,
                        group.createDate,
                        group.updatedDate,
                        group.reason
                ))
                .from(group)
                .where(group.groupStatus.eq(groupStatus).and(group.groupName.contains(criteria.getKeyword())))
                .orderBy(group.createDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize()).fetch();

        long total = queryFactory.selectFrom(group)
                .where(group.groupStatus.eq(groupStatus).and(group.groupName.contains(criteria.getKeyword())))
                .fetch().size();

        return new PageImpl<>(groups, pageable, total);

    }

    public Integer countGroupUser(Long userId){
        return Math.toIntExact(queryFactory.select(groupMember.user.userId.count())
                .from(groupMember)
                .where(groupMember.user.userId.eq(userId)).fetchOne());
    }

    public void deleteGroupMemberByUserId(Long userId, Long groupId){
        queryFactory.delete(groupMember)
                .where(groupMember.user.userId.eq(userId)
                        .and(groupMember.group.groupId.eq(groupId))).execute();
    }


}