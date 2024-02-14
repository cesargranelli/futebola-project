package com.sevenine.lineup.infrastructure.repository.document;

import com.sevenine.lineup.business.enumerated.StatusRoundEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document("rounds")
public class RoundDocument {
    @Id
    private String id;
    private String uuid;
    private Integer number;
    private String name;
    @Field(name = "begin_date_time")
    private String beginDateTime;
    @Field(name = "end_date_time")
    private String endDateTime;
    private StatusRoundEnum status;
}
