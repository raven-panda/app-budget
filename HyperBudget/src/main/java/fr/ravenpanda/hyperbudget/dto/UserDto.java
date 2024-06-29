package fr.ravenpanda.hyperbudget.dto;

import fr.ravenpanda.hyperbudget.common.list.PeriodTypeEnum;
import fr.ravenpanda.hyperbudget.common.list.PreferredThemeEnum;
import fr.ravenpanda.hyperbudget.common.list.RoleEnum;
import fr.ravenpanda.hyperbudget.model.Expense;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class UserDto {

	private Integer id;
	private RoleEnum role;
	private String email;
	private String username;
	private String password;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private PreferredThemeEnum theme;
	private PeriodTypeEnum periodType;
	private Boolean isEditWarnEnabled;
	private List<ExpenseDto> expenses;

}
