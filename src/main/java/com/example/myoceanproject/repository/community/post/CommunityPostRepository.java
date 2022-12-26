package com.example.myoceanproject.repository.community.post;

import com.example.myoceanproject.entity.CommunityPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long> {

    // 최신 게시글 1개 출력
    public CommunityPost findTop1ByOrderByCommunityPostIdDesc();
    @Query("select p.communityPostId from CommunityPost p where p.user.userId=:userId")
    public Long findpostByuserid(@Param("userId") Long userid);

    // 유저 아이디로 해당 아이디로 작성한 게시글 총 개수 출력
    public int countAllByUser_UserId(Long userId);

}
