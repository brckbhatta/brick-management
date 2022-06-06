package com.bhatta.management.service;

import java.util.List;
import com.bhatta.management.entity.FirmMaster;

public interface FirmMasterService  {

	FirmMaster saveFirmDetails(FirmMaster firmMaster);

	List<FirmMaster> getAll();

}
