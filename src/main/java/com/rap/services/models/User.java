package com.rap.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    private String userId;
    private String password;
    private UserName userName;
    private String role;
    private String insertedBy;
    private String updatedBy;
    private long updatedDate;
    private long insertedDate;
    private SocialProfile socialProfile;
    private Contact contact;

}
