package com.revature.Videoservicespring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.Videoservicespring.model.Video;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer>{

	
	
	EntityManager entityManager = null;

	@Transactional
	@Query
	(value="INSERT INTO videos (name, display_name, vimeo_video_url, tags, description, transcript, level_id, category_id) VALUES (:name,:display_name,:vimeo_video_url,:tags,:description,:transcript,:level_id,:category_id)",nativeQuery = true)
	Video insertVideos(@Param("name") String name,@Param("display_name") String display_name,@Param("vimeo_video_url") String vimeo_video_url,@Param("tags") String tags,@Param("description") String description,@Param("transcript") String transcript,@Param("level_id") int level_id,@Param("category_id") int category_id );

	//	public  boolean insertVideo(Video video) {
//		
//		boolean result = false;
//	   Object result1= entityManager.createNativeQuery("INSERT INTO videos (name, display_name, vimeo_video_url, tags, description, transcript, level_id, category_id) VALUES (?,?,?,?,?,?,?,?)")
//	      .setParameter(1, video.getVideoName())
//	      .setParameter(2, video.getDisplayName())
//	      .setParameter(3, video.getVimeoVideoUrl())
//	      .setParameter(4, video.getTags())
//	      .setParameter(5, video.getDescription())
//	      .setParameter(6, video.getTranscript())
//	      .setParameter(7, video.getLevel_id())
//	      .setParameter(8, video.getCategory_id())
//	      .executeUpdate();
//	   if(result1!=null) {
//		   result=true;
//	   }
//	return result;
//		
//	}
	
	@Query
	(value="select id,name,display_name,vimeo_video_url,tags from videos",nativeQuery = true)
	List<Video>findAllVideos();
	
}
