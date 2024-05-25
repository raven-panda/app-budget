package fr.ravenpanda.hyperbudget.user;

import fr.ravenpanda.hyperbudget.user_preference.UserPreferenceEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity(name = "user")
@Data
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "created_at", columnDefinition = "DATETIME")
    @DateTimeFormat
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME")
    @DateTimeFormat
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne(
        targetEntity = UserPreferenceEntity.class,
        fetch = FetchType.LAZY,
        optional = false,
        cascade = CascadeType.ALL
    )
    @JoinColumn(name = "user_preference_id", referencedColumnName = "id")
    private UserPreferenceEntity userPreference;
}
