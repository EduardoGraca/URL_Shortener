package com.example.url_shortener.Repository;
import com.example.url_shortener.DAO.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByUniqueIdentifier(String uuid);
    void deleteByUniqueIdentifier(String uuid);
}
