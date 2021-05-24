package com.scg.employee.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditVO {

	private Long createdBy;

	private LocalDateTime createdTimestamp;

	private Long lastUpdatedBy;

	private LocalDateTime lastUpdatedTimestamp;

	private Integer recordVersionNo;

}
