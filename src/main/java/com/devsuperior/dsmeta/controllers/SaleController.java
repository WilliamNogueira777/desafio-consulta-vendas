package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SellerMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SaleMinDTO>> getReport(@RequestParam(value = "maxDate", required = false) String maxDateStr,
													  @RequestParam(value = "minDate", required = false) String minDateStr,
													  @RequestParam(value = "name", required = false) String sellerName,
													  Pageable pageable) {
		Page<SaleMinDTO> result = service.searchReport(maxDateStr, minDateStr, sellerName, pageable);
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<List<SellerMinDTO>> getSummary(@RequestParam(value = "maxDate", required = false) String maxDateStr,
														 @RequestParam(value = "minDate", required = false) String minDateStr) {
		List<SellerMinDTO> result = service.searchSummary(maxDateStr, minDateStr);
		return ResponseEntity.ok(result);
	}
}
