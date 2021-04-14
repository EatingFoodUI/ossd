package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.Video;
import com.lyl.springboot.ossd.repository.VideoRepository;
import com.lyl.springboot.ossd.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public void save(Video video) {
        videoRepository.save(video);
    }

    @Override
    public void deleteById(String videoId) {
        videoRepository.deleteById(videoId);
    }

    @Override
    public Video findByVideoId(String VideoId) {
        return videoRepository.findByVideoId(VideoId);
    }

    @Override
    public Video findByVideoName(String VideoName) {
        return videoRepository.findByVideoName(VideoName);
    }

    @Override
    public Page<Video> findByVideoAuthor(String VideoAuthor, Pageable pageable) {
        return videoRepository.findByVideoAuthor(VideoAuthor, pageable);
    }

    @Override
    public int modifyVideoNameByVideoId(String VideoName, String VideoId) {
        return videoRepository.modifyVideoNameByVideoId(VideoName, VideoId);
    }

    @Override
    public int modifyVideoDesByVideoId(String VideoDes, String VideoId) {
        return videoRepository.modifyVideoDesByVideoId(VideoDes, VideoId);
    }

    @Override
    public int modifyVideoAddByVideoId(String VideoAdd, String VideoId) {
        return videoRepository.modifyVideoAddByVideoId(VideoAdd, VideoId);
    }
}
