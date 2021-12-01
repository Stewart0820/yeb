package com.stewart.server.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Stewart
 * @create 2021/12/1
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain =true)
public class ChatMsg {

    private String from;
    private String to;
    private String content;
    private LocalDateTime date;
    private String formNickName;
}
