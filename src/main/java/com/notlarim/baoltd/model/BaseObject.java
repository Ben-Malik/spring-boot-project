package com.notlarim.notlarimltd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseObject {

    private Date createdAt;

    private Date UpdatedAt;

}
