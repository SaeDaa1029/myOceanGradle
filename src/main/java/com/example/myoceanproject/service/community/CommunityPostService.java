package com.example.myoceanproject.service.community;

import com.example.myoceanproject.aspect.annotation.PostAlarm;
import com.example.myoceanproject.domain.CommunityPostDTO;
import com.example.myoceanproject.domain.Criteria;
import com.example.myoceanproject.entity.CommunityPost;
import com.example.myoceanproject.repository.UserRepository;
import com.example.myoceanproject.repository.community.post.CommunityPostRepository;
import com.example.myoceanproject.repository.community.post.CommunityPostRepositoryImpl;
import com.example.myoceanproject.type.CommunityCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service @Qualifier("community") @Primary
@RequiredArgsConstructor
@Slf4j
public class CommunityPostService implements CommunityService {

    private final CommunityPostRepositoryImpl postRepositoryImpl;

    private final CommunityPostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    // 게시글 출력 : 키워드 여부에 따라 페이징과 카테고리 + (criteria) 메소드 다르게 사용
    public Page<CommunityPostDTO> showCounseling(Pageable pageable, CommunityCategory communityCategory, Criteria criteria) {
        return criteria.getKeyword().equals("null") ? postRepositoryImpl.findAllByCategory(pageable, communityCategory) : postRepositoryImpl.findAllByCategory(pageable, communityCategory, criteria);
    }

    // 게시글 출력 : 키워드 여부에 따라 페이징처리 + (criteria) 메소드 다르게 사용
    public Page<CommunityPostDTO> showPost(Pageable pageable, Criteria criteria) {
        return criteria.getKeyword().equals("null") ? postRepositoryImpl.findAll(pageable) : postRepositoryImpl.findAll(pageable, criteria);
    }

    // 게시글 삭제 : 유저 아이디 값으로 게시글을 찾고, 해당 게시글을 삭제
    public void remove(Long communityPostId) {
        CommunityPost post = postRepository.findById(communityPostId).get();
        postRepositoryImpl.deleteByPost(post);
        postRepository.delete(post);
    }

    //  게시글 등록
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(CommunityPostDTO communityPostDTO) {
        // DTO 엔티티화 하여 post 저장
        CommunityPost communityPost = communityPostDTO.toEntity();
        // 유저 아이디로 유저를 찾아 post에 저장
        communityPost.setUser(userRepository.findById(communityPostDTO.getUserId()).get());
        // post 저장
        postRepository.save(communityPost);
    }

    @Override
    public List<CommunityPostDTO> showCommunity() {
        return null;
    }

//    게시글 출력
    @Override
    public List<CommunityPostDTO> findAllByList(Long userId) {
        // 유저 아이디로 communityPostDTO 전체 출력
        List<CommunityPostDTO> communityPostDTO = postRepositoryImpl.findAllByList(userId);
        return communityPostDTO;
    }

    // 전체 게시글 출력 : 로그인 하지 않은 유저용
    public List<CommunityPostDTO> findAllByList() {
        List<CommunityPostDTO> communityPostDTO = postRepositoryImpl.findAllByListWithoutLogin();
        return communityPostDTO;
    }

    // 카테고리 여러개 필터 적용
    public List<CommunityPostDTO> findBoardByCategory(List<String> communityCategories){
        List<CommunityPostDTO> communityPostDTO = postRepositoryImpl.filterCommunityBoard(communityCategories);
        return communityPostDTO;
    }

    //  비회원 전용 : 카테고리 필터 사용
    public List<CommunityPostDTO> findBoardByCategory(int page, List<String> communityCategories){
        List<CommunityPostDTO> communityPostDTO = postRepositoryImpl.filterCommunityBoard(page, communityCategories);
        return communityPostDTO;
    }

    //  비회원 전용 : 카테고리 없을 때
    public List<CommunityPostDTO> findBoardByCategory(int page){
        List<CommunityPostDTO> communityPostDTO = postRepositoryImpl.filterCommunityBoard(page);
        return communityPostDTO;
    }

    //  회원 전용 : 페이징처리 + 카테고리 필터 + 로그인 회원 전용
    public List<CommunityPostDTO> findBoardByCategory(int page, List<String> communityCategories, Long userId){
        List<CommunityPostDTO> communityPostDTO = postRepositoryImpl.filterCommunityBoard(page, communityCategories, userId);
        return communityPostDTO;
    }

    //  회원 전용(카테고리 없을 때) : 페이징 + 로그인 회원 전용
    public List<CommunityPostDTO> findBoardByCategory(int page, Long userId){
        List<CommunityPostDTO> communityPostDTO = postRepositoryImpl.filterCommunityBoard(page, userId);
        return communityPostDTO;
    }

    // 전체 리스트 출력 : 카테고리 필터 + 로그인 회원 전용
    public List<CommunityPostDTO> findBoardByCategory(List<String> communityCategories, Long userId){
        List<CommunityPostDTO> communityPostDTO = postRepositoryImpl.filterCommunityBoard(communityCategories, userId);
        return communityPostDTO;
    }

    // 커뮤니티 작성 아이디 값으로 해당 게시글 정보 출력
    @Override
    public CommunityPostDTO find(Long communityPostId) {
        CommunityPostDTO communityPostDTO = postRepositoryImpl.findByCommunityId(communityPostId);
        return communityPostDTO;
    }

    @Override
    public void update(CommunityPostDTO communityPostDTO) {;}

    // 게시글 삭제 : 아이디를 통해 게시글 정보를 받아와 해당 게시글 삭제
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long communityPostId) {
        postRepository.deleteById(communityPostId);
    }

    //  무한스크롤
    @Override
    public List<CommunityPostDTO> selectScrollBoards(int page) {
        List<CommunityPostDTO> communityPostDTO = postRepositoryImpl.selectScrollBoards(page);
        return communityPostDTO;
    }

    // 무한스크롤, 로그인용
    @Override
    public List<CommunityPostDTO> selectScrollBoards(int page, Long userId) {
        List<CommunityPostDTO> communityPostDTO = postRepositoryImpl.selectScrollBoards(page, userId);
        return communityPostDTO;
    }
}

