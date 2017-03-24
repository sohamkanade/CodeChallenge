package com.home.api;

import java.util.ArrayList;
import java.util.List;

public class ErpRecords {

	private List<ErpRecord> records;

	public List<ErpRecord> getRecords() {
		if(null == records) {
			records = new ArrayList<>();
		}
		return records;
	}

}
