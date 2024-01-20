package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.Mark;


@Getter
@Setter
@ToString
@Builder
public class Cell {
    private int x;
    private int y;
    private Mark sign;
}
