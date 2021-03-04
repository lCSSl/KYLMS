package com.kaiyu56.common.core.exception.file;

/**
 * 文件名大小限制异常类
 *
 * @author css
 */
public class FileSizeLimitExceededException extends FileException {
    private static final long serialVersionUID = 1L;

    public FileSizeLimitExceededException(long defaultMaxSize) {
        super("upload.exceed.maxSize", new Object[]{defaultMaxSize});
    }
}
