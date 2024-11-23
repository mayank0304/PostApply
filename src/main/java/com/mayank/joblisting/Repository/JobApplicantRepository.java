package com.mayank.joblisting.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mayank.joblisting.model.JobApplication;

public interface JobApplicantRepository extends MongoRepository<JobApplication, String > {

}
