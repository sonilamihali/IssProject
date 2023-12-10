package org.sda;

import lombok.Data;

import java.util.List;
@Data
public class IssPersonResponse {
    private  int number;
    List<IssPerson> person;
}
