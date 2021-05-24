package com.scg.employee.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "address", url = "http://localhost:8081/address")
public interface AddressProxy {

	@GetMapping("/id/{id}")
	String getAddressByEmpId(@RequestParam("id") int id);

}
