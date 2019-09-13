package sk.lukasanda.matboj.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sk.lukasanda.matboj.entities.School
import sk.lukasanda.matboj.entities.Team

@Repository
interface SchoolRepository: JpaRepository<School, Long>

@Repository
interface TeamRepository: JpaRepository<Team, Long>