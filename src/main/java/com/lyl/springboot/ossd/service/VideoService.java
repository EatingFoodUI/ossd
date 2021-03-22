package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VideoService {

    void save(Video video);

    void deleteById(String videoId);

    Video findByVideoId(String VideoId);

    Video findByVideoName(String VideoName);

    Page<Video> findByVideoAuthor(String VideoAuthor, Pageable pageable);

    int modifyVideoNameByVideoId(String VideoName,String VideoId);

    int modifyVideoDesByVideoId(String VideoDes,String VideoId);

    int modifyVideoAddByVideoId(String VideoAdd,String VideoId);
}
