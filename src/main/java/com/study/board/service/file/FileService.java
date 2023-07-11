package com.study.board.service.file;

import com.study.board.domain.file.FileMapper;
import com.study.board.domain.file.FileRequest;
import com.study.board.domain.file.FileResponse;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileMapper fileMapper;

    @Transactional
    public void saveFiles(final Long bno, final List<FileRequest> files){
        if (CollectionUtils.isEmpty(files)){
            return;
        }

        for (FileRequest file : files){
            file.setBno(bno);
        }

        fileMapper.saveFiles(files);
    }

    /**
     * 파일 상세정보 조회
     * @param fno - PK
     * @return 파일 상세정보
     */
    public FileResponse findByFno(Long fno){
        return fileMapper.findByFno(fno);
    }


    /**
     * 파일 리스트 조회
     * @param bno - 게시글 번호 (FK)
     * @return 파일 리스트
     */
    public List<FileResponse> findAllFileByBno(final Long bno) {
        return fileMapper.findAllFileByBno(bno);
    }

    /**
     * 파일 리스트 조회
     * @param ids - PK 리스트
     * @return 파일 리스트
     */
    public List<FileResponse> findAllFileByIds(final List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return fileMapper.findAllByIds(ids);
    }

    /**
     * 파일 삭제 (from Database)
     * @param ids - PK 리스트
     */
    @Transactional
    public void deleteAllFileByIds(final List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        fileMapper.deleteAllByIds(ids);
    }
}
