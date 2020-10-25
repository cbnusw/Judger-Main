package com.qt.domain.homework.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.io.Resource;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class FileInfo {
    @NotNull
    private String contentDisposition;

    @NotNull
    private String contentLength;

    @NotNull
    private Resource resource;

    @Builder
    public FileInfo(@NotNull String contentDisposition, @NotNull String contentLength, @NotNull Resource resource) {
        this.contentDisposition = contentDisposition;
        this.contentLength = contentLength;
        this.resource = resource;
    }
}