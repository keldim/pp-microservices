package com.chrisyoo.notification;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;


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
    @Column(name = "ski_api_data", length = Length.LOB_DEFAULT)
    private String skiApiData;
//    private String message;
//    private LocalDateTime sentAt;
}
