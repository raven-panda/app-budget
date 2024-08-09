package fr.ravenpanda.hyperbudget.dto;

import fr.ravenpanda.hyperbudget.common.list.PeriodTypeEnum;
import fr.ravenpanda.hyperbudget.common.list.PreferredThemeEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class UserDto {

	private Integer id;
	private String role;
	private String email;
	private String username;
	private String password;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private PreferredThemeEnum theme;
	private PeriodTypeEnum periodType;
	private Boolean isEditWarnEnabled;
	private BigDecimal totalExpensesAmount;
	private List<ExpenseDto> expenses;

}
