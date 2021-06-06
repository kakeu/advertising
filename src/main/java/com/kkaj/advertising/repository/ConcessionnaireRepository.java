package com.kkaj.advertising.repository;

import com.kkaj.advertising.entities.Concessionnaire;
import com.kkaj.advertising.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcessionnaireRepository extends JpaRepository<Concessionnaire,Long> {

}
