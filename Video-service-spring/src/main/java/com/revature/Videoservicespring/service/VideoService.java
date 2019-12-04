package com.revature.Videoservicespring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Videoservicespring.exception.ServiceException;
import com.revature.Videoservicespring.model.Video;
import com.revature.Videoservicespring.repository.VideoRepository;
import com.revature.Videoservicespring.util.MessageConstants;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository; 
	
	@Transactional
	public boolean addVideos(Video video) throws ServiceException {
		boolean result=false;
		String name=video.getVideoName();
		String displayName=video.getDisplayName();
		String vimeo_video_url=video.getVimeoVideoUrl();
		String tags=video.getTags();
		String description=video.getDescription();
		String transcript=video.getTranscript();
		int level_id=video.getLevel_id();
		int category_id=video.getCategory_id();
		//video.setStatus(true);
		//video=videoRepository.save(video);
		video=videoRepository.insertVideos(name, displayName, vimeo_video_url, tags, description, transcript, level_id, category_id);
		if(video==null) {
			throw new ServiceException(MessageConstants.video_exist);
		}
		else {
		 result=true;
		
		}
		return result;
	}
}
