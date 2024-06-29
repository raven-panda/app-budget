package fr.ravenpanda.hyperbudget.dto;

import fr.ravenpanda.hyperbudget.common.list.DefaultCategoryEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class ExpenseDto {

	private Integer id;
	private Integer userId;
	private String name;
	private BigDecimal amount;
	private Date date;
	private DefaultCategoryEnum category;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
