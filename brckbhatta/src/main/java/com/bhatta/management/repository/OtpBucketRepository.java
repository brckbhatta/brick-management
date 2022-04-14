package com.bhatta.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bhatta.management.entity.OtpBucket;

@Repository
public interface OtpBucketRepository extends JpaRepository<OtpBucket, Long> {

	OtpBucket findByOtp(String otp);

}
