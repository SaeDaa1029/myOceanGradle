package com.example.myoceanproject.repository.community.post;

import com.example.myoceanproject.domain.CommunityPostDTO;
import com.example.myoceanproject.domain.Criteria;
import com.example.myoceanproject.entity.CommunityPost;
import com.example.myoceanproject.type.CommunityCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommunityPostCustomRepository {

    // 페이징 처리를 위해 communityPostDTO 전체 가져오기
    public Page<CommunityPostDTO> findAll(Pageable pageable);

    // 페이징 처리를 위한 communityPostDTO 전체 가져오기 + 검색어 추출 가능
    public Page<CommunityPostDTO> findAll(Pageable pageable, Criteria criteria);

    // 페이징 처리 + 카테고리
    public Page<CommunityPostDTO> findAllByCategory(Pageable pageable, CommunityCategory communityCategory);

    // 페이징 처리 + 카테고리 + 검색어
    public Page<CommunityPostDTO> findAllByCategory(Pageable pageable, CommunityCategory communityCategory, Criteria criteria);

    // 게시글 삭제
    public void deleteByPost(CommunityPost post);

    // 아이디에 부합하는 유저의 커뮤니티 게시글 수 세기
    public Integer countPostByUser(Long userId);

    // 유저 아이디를 통해 전체 communityPost를 가져옴
    public List<CommunityPostDTO> findAllByList(Long userId);

    // 관리자페이지에서 사용
    public CommunityPostDTO findAllByDashboard();

    // 카테고리 필터 여러개 적용해서 부합하는 항목만 뽑아내기
    public List<CommunityPostDTO> filterCommunityBoard(List<String> communityCategories);

    // 페이징처리를 포함한 카테고리 필터 적용
    public List<CommunityPostDTO> filterCommunityBoard(int page, List<String> communityCategories);

    // 카테고리 필터 적용 + 아이디 값을 받아 각 게시글의 좋아요를 눌렀는지를 체크
    public List<CommunityPostDTO> filterCommunityBoard(List<String> communityCategories, Long userId);

    // 페이징 처리 + 카테고리 필터 적용 + 좋아요 체크
    public List<CommunityPostDTO> filterCommunityBoard(int page, List<String> communityCategories, Long id);
}
