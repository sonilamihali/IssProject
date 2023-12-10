package org.sda;

import lombok.Data;

import java.util.List;
@Data
public class IssSpaceship {
    private int number;
    private List<IssPerson> people;
}
