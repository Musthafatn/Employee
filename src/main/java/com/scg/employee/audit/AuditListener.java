package com.scg.employee.audit;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.scg.employee.dao.entity.Audit;

public class AuditListener {

	@PrePersist
	public void setAuditFieldsOnInsert(final Auditable auditable) {

		final Audit audit = new Audit();
		auditable.setAudit(audit);
		audit.setCreatedBy(10L);
		audit.setCreatedTimestamp(LocalDateTime.now());
		audit.setRecordVersionNo(1);

	}

	@PreUpdate
	public void setAuditFieldsOnUpdate(final Auditable auditable) {

		final Audit audit = auditable.getAudit();
		audit.setLastUpdatedBy(10L);
		audit.setLastUpdatedTimestamp(LocalDateTime.now());
		audit.setRecordVersionNo(audit.getRecordVersionNo() + 1);
	}

}
