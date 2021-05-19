package com.scg.employee.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.scg.employee.dao.entity.Audit;
import com.scg.employee.vo.AuditVO;

@Component
@Mapper(componentModel = "spring")
public interface AuditMapper {

	AuditVO toAuditVO(Audit audit);

	Audit toAudit(AuditVO auditVO);

}
