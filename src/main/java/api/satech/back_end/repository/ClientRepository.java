package api.satech.back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import api.satech.back_end.entites.Client;

// @Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	Client findByEmail(String email);
}