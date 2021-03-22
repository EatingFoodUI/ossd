package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VideoRepository extends JpaRepository<Video, String> {
    Video findByVideoId(String VideoId);

    Video findByVideoName(String VideoName);

    Page<Video> findByVideoAuthor(String VideoAuthor, Pageable pageable);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Video set VideoName=?1 where VideoId=?2")
    int modifyVideoNameByVideoId(String VideoName,String VideoId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Video set VideoDes=?1 where VideoId=?2")
    int modifyVideoDesByVideoId(String VideoDes,String VideoId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Video set VideoAdd=?1 where VideoId=?2")
    int modifyVideoAddByVideoId(String VideoAdd,String VideoId);
}
