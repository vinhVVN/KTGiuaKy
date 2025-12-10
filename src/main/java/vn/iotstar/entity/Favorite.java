package vn.iotstar.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Favorites")
public class Favorite implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FavoriteId")
    private int favoriteId;

    @Column(name = "LikedDate")
    @Temporal(TemporalType.DATE)
    private Date likedDate;

    @ManyToOne
    @JoinColumn(name = "Username") 
    private User user;

    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video video;
}