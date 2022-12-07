package com.example.myoceanproject.domain;

import com.example.myoceanproject.entity.Quest;
import com.example.myoceanproject.type.QuestType;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Embedded;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;

@Component
@Data
@NoArgsConstructor
public class QuestDTO {

    private Long questId;
    private String questCategory;
    private String questName;
    private String questContent;
    private String questDeadLine;
    private int questPoint;

    private QuestType questType;
    private String questFilePath;
    private String questFileName;

    private String questFileUuid;
    private Long questFileSize;

    private List<QuestDTO> questList;
    private int endPage;

    private String createDate;

    @QueryProjection
    public QuestDTO(Long questId, String questCategory, String questName, String questContent,QuestType questType, String questDeadLine, int questPoint, String questFilePath, String questFileName, String questFileUuid, Long questFileSize, LocalDateTime createDate) {
        this.questId = questId;
        this.questCategory = questCategory;
        this.questName = questName;
        this.questContent = questContent;
        this.questType = questType;
        this.questDeadLine = questDeadLine;
        this.questPoint = questPoint;
        this.questFilePath = questFilePath;
        this.questFileName = questFileName;
        this.questFileUuid = questFileUuid;
        this.questFileSize = questFileSize;
        this.createDate = createDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public Quest toEntity() {
        return Quest.builder()
                .questCategory(questCategory)
                .questName(questName)
                .questType(questType)
                .questDeadLine(questDeadLine)
                .questContent(questContent)
                .questPoint(questPoint)
                .questFileName(questFileName)
                .questFilePath(questFilePath)
                .questFileUuid(questFileUuid)
                .questFileSize(questFileSize)
                .build();
    }
}
