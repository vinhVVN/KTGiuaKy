package vn.iotstar.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Shares")
public class Share implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShareId")
    private int shareId;

    @Column(name = "Emails", columnDefinition = "nvarchar(500)")
    private String emails;

    @Column(name = "SharedDate")
    @Temporal(TemporalType.DATE)
    private Date sharedDate;

    @ManyToOne
    @JoinColumn(name = "Username")
    private User user;

    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video video;
}