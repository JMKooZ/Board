package com.study.board.controller.file;

import com.study.board.common.file.FileUtils;
import com.study.board.domain.file.FileResponse;
import com.study.board.service.file.FileService;
import java.net.URLEncoder;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;
    private final FileUtils fileUtils;

    @GetMapping("/posts/{bno}/files")
    public List<FileResponse> findAllFileByBno(@PathVariable final Long bno){
        return fileService.findAllFileByBno(bno);
    }

    // 첨부파일 다운로드
    @GetMapping("/posts/{bno}/files/{fno}/download")
    public ResponseEntity<Resource> downloadFile(@PathVariable final Long bno, @PathVariable final Long fno){
        FileResponse file = fileService.findByFno(fno);
        Resource resource = fileUtils.readFileAsResource(file);
        try {
            // 파일 이름 깨지는 것을 방지하기 위해 URLEncoder 사용
            String filename = URLEncoder.encode(file.getOriginalName(), "UTF-8");
            return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\""+filename +"\";")
                .header(HttpHeaders.CONTENT_LENGTH, file.getSize()+"")
                .body(resource);

        } catch (Exception e) {
            throw new RuntimeException("filename encoding failed: "+file.getOriginalName());
        }
    }
}
