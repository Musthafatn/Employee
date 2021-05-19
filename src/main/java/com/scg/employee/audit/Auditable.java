package com.scg.employee.audit;

import com.scg.employee.dao.entity.Audit;

public interface Auditable {

	Audit getAudit();

	void setAudit(Audit audit);

}
