package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.WorkExperienceService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.WorkExperienceDao;
import com.example.HRMS.entities.concretes.Position;
import com.example.HRMS.entities.concretes.WorkExperience;
import com.example.HRMS.entities.concretes.Workplace;
import com.example.HRMS.entities.dtos.WorkExperienceToAddDto;

@Service
public class WorkExperienceManager implements WorkExperienceService {

	private WorkExperienceDao workExperienceDao;
	
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public DataResult<List<WorkExperience>> getByUserId(int userId) {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.getByUserId(userId));
	}

	@Override
	public Result add(WorkExperienceToAddDto workExperienceToAdd) {
		WorkExperience workExperience = new WorkExperience();
		
		Workplace workplace = new Workplace();
		workplace.setId(workExperienceToAdd.getWorkplaceId());
		workExperience.setWorkplace(workplace);
		
		Position position = new Position();
		position.setId(workExperienceToAdd.getPositionId());
		workExperience.setPosition(position);
		
		workExperience.setUserId(workExperienceToAdd.getUserId());
		workExperience.setQuitYear(workExperienceToAdd.getQuitYear());
		workExperience.setStartingYear(workExperienceToAdd.getStartingYear());
		
		this.workExperienceDao.save(workExperience);
		return new SuccessResult(Messages.added);
	}

	@Override
	public DataResult<List<WorkExperience>> getByUserIdSortedByQuitYearDesc(int userId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "quitYear");
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.getByUserId(userId, sort));
	}
}
