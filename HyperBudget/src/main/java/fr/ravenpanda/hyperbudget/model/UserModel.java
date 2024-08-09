package fr.ravenpanda.hyperbudget.model;

import fr.ravenpanda.hyperbudget.common.list.PeriodTypeEnum;
import fr.ravenpanda.hyperbudget.common.list.PreferredThemeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "rp_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = UserRole.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole role;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(nullable = false, columnDefinition = "enum('LIGHT', 'DARK')")
    @Enumerated(EnumType.STRING)
    private PreferredThemeEnum theme;

    @Column(nullable = false, columnDefinition = "enum('MONTHLY', 'YEARLY')")
    @Enumerated(EnumType.STRING)
    private PeriodTypeEnum periodType;

    @Column(name = "edit_warn", nullable = false, insertable = false)
    private Boolean isEditWarnEnabled;

    @OneToMany(mappedBy = "user", targetEntity = Expense.class, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Expense> expenses;
}
