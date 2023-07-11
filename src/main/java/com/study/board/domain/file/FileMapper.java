package com.study.board.domain.file;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    /**
     * 파일 정보 저장
     * @param files - 파일 정보 리스트
     */
    void saveFiles(List<FileRequest> files);

    /**
     * 파일 상세정보 조회
     * @param fno - PK
     * @return 파일 상세정보
     */
    FileResponse findByFno(Long fno);

    /**
     * 파일 리스트 조회
     * @param bno - 게시글 번호 (FK)
     * @return 파일 리스트
     */
    List<FileResponse> findAllFileByBno(Long bno);

    /**
     * 파일 리스트 조회
     * @param ids - PK 리스트
     * @return 파일 리스트
     */
    List<FileResponse> findAllByIds(List<Long> ids);

    /**
     * 파일 삭제
     * @param ids - PK 리스트
     */
    void deleteAllByIds(List<Long> ids);
}
