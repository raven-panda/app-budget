package fr.ravenpanda.hyperbudget.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date date;
	private DefaultCategoryEnum category;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
	private Date createdAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
	private Date updatedAt;

}
