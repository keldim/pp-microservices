package com.chrisyoo.notification;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Notification {
    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence"
    )
    private Integer notificationId;
    private String uuid;
    private String message;
//    private LocalDateTime sentAt;

    // how to store data from third party api into database?
    // parse first?
    // do I have to create variables for all the nested json objects?
}
