package com.netcracker.admissiontest.userSession.repository;

import com.netcracker.admissiontest.userSession.entity.UserSession;
import org.springframework.data.repository.CrudRepository;

public interface UserSessionRepository extends CrudRepository<UserSession, Long> {
}
