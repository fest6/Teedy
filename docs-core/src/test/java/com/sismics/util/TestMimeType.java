package com.sismics.util;

import com.sismics.util.mime.MimeType;
import com.sismics.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestMimeType extends BaseTest {

    @Test
    public void testImagePng() {
        Assert.assertEquals("image/png", MimeType.IMAGE_PNG);
    }
    
    @Test
    public void testImageJpeg() {
        Assert.assertEquals("image/jpeg", MimeType.IMAGE_JPEG);
    }
    
    @Test
    public void testImageGif() {
        Assert.assertEquals("image/gif", MimeType.IMAGE_GIF);
    }
    
    @Test
    public void testApplicationZip() {
        Assert.assertEquals("application/zip", MimeType.APPLICATION_ZIP);
    }
    
    @Test
    public void testApplicationPdf() {
        Assert.assertEquals("application/pdf", MimeType.APPLICATION_PDF);
    }
    
    @Test
    public void testOpenDocumentText() {
        Assert.assertEquals("application/vnd.oasis.opendocument.text", MimeType.OPEN_DOCUMENT_TEXT);
    }
    
    @Test
    public void testOfficeDocument() {
        Assert.assertEquals("application/vnd.openxmlformats-officedocument.wordprocessingml.document", MimeType.OFFICE_DOCUMENT);
    }
    
    @Test
    public void testOfficePresentation() {
        Assert.assertEquals("application/vnd.openxmlformats-officedocument.presentationml.presentation", MimeType.OFFICE_PRESENTATION);
    }
    
    @Test
    public void testOfficeSheet() {
        Assert.assertEquals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", MimeType.OFFICE_SHEET);
    }
    
    @Test
    public void testTextPlain() {
        Assert.assertEquals("text/plain", MimeType.TEXT_PLAIN);
    }
    
    @Test
    public void testTextCsv() {
        Assert.assertEquals("text/csv", MimeType.TEXT_CSV);
    }
    
    @Test
    public void testVideoWebm() {
        Assert.assertEquals("video/webm", MimeType.VIDEO_WEBM);
    }
    
    @Test
    public void testVideoMp4() {
        Assert.assertEquals("video/mp4", MimeType.VIDEO_MP4);
    }
    
    @Test
    public void testDefault() {
        Assert.assertEquals("application/octet-stream", MimeType.DEFAULT);
    }
}
