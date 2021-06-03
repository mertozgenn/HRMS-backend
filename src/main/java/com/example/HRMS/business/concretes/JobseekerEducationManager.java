package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.JobseekerEducationService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.JobseekerEducationDao;
import com.example.HRMS.entities.concretes.JobseekerEducation;
import com.example.HRMS.entities.concretes.School;
import com.example.HRMS.entities.concretes.SchoolDepartment;
import com.example.HRMS.entities.dtos.JobseekerEducationToAddDto;

@Service
public class JobseekerEducationManager implements JobseekerEducationService {

	private JobseekerEducationDao jobseekerEducationDao;
	
	public JobseekerEducationManager(JobseekerEducationDao jobseekerEducationDao) {
		this.jobseekerEducationDao = jobseekerEducationDao;
	}

	@Override
	public DataResult<List<JobseekerEducation>> getByUserId(int userId) {
		return new SuccessDataResult<List<JobseekerEducation>>(this.jobseekerEducationDao.getByUserId(userId));
	}

	@Override
	public Result add(JobseekerEducationToAddDto jobseekerEducationToAdd) {
		JobseekerEducation jobseekerEducation = new JobseekerEducation();
		
		School school = new School();
		school.setId(jobseekerEducationToAdd.getSchoolId());
		jobseekerEducation.setSchool(school);
		
		SchoolDepartment schoolDepartment = new SchoolDepartment();
		schoolDepartment.setId(jobseekerEducationToAdd.getSchoolDepartmentId());
		jobseekerEducation.setSchoolDeparment(schoolDepartment);
		
		jobseekerEducation.setGraduationYear(jobseekerEducation.getGraduationYear());
		jobseekerEducation.setStartingYear(jobseekerEducationToAdd.getStartingYear());
		jobseekerEducation.setUserId(jobseekerEducationToAdd.getUserId());
		
		this.jobseekerEducationDao.save(jobseekerEducation);
		return new SuccessResult(Messages.added);
	}

	@Override
	public DataResult<List<JobseekerEducation>> getByUserIdSortedByGraduationYearDesc(int userId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "graduationYear");
		return new SuccessDataResult<List<JobseekerEducation>>(this.jobseekerEducationDao.getByUserId(userId, sort));
	}

}
