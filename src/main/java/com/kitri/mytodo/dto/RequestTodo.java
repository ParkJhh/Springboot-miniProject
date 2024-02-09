package com.kitri.mytodo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestTodo {
    Long id;
    String content;
    boolean done;
    Long memberid;
}
