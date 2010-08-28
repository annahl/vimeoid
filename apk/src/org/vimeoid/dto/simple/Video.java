/**
 * 
 */
package org.vimeoid.dto.simple;

import java.util.Arrays;

import org.vimeoid.Extractable;

import android.content.ContentValues;

/**
 * <dl>
 * <dt>Project:</dt> <dd>vimeoid</dd>
 * <dt>Package:</dt> <dd>org.vimeoid.dto.simple</dd>
 * </dl>
 *
 * <code>Video video information</code>
 *
 * <p>Description</p>
 *
 * @author Ulric Wilfred <shaman.sir@gmail.com>
 * @date Aug 19, 2010 8:55:56 PM 
 *
 */
//URLs are: http://vimeo.com/m/play_redirect?quality=mobile&clip_id=14294054
public class Video implements Extractable {
    
    /* public static final Uri CONTENT_URI = Uri.parse("content://" + VimeoSimpleApiProvider.AUTHORITY +
                                                                   "/videos"); */

    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.vimeo.video";
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.vimeo.video";    
    
    public int id;
    public String url;
    public String title;
    public String description;
    
    public int width;
    public int height;
    public int duration; /* in seconds */
    
    public int likesCount;
    public int playsCount;
    public int commentsCount;
    
    public String[] tags;    

    public /*long*/ String uploadedOn;
    public String uploaderName;
    public String uploaderProfileUrl;
    
    public String smallThumbnailUrl;
    public String mediumThumbnailUrl;
    public String largeThumbnailUrl;
    
    public String smallUploaderPortraitUrl;
    public String mediumUploaderPortraitUrl;
    public String largeUploaderPortraitUrl;
    
    public final static class FieldsKeys {
        
        public static final String _ID = "_id";
        public static final String TITLE = "title";
        public static final String AUTHOR = "author";
        public static final String DESCRIPTION = "description";
        public static final String TAGS = "tags";
        public static final String DURATION = "duration";
        
    }
    
    public final static String[] SHORT_EXTRACT_PROJECTION = {
        FieldsKeys._ID, FieldsKeys.TITLE, FieldsKeys.AUTHOR,
        FieldsKeys.DESCRIPTION, FieldsKeys.DURATION, FieldsKeys.TAGS
    };
    
    @Override
    public ContentValues extract() {
        final ContentValues result = new ContentValues();
        result.put(FieldsKeys._ID, this.id);
        result.put(FieldsKeys.TITLE, this.title);
        result.put(FieldsKeys.AUTHOR, this.uploaderName);
        result.put(FieldsKeys.DESCRIPTION, this.description);
        result.put(FieldsKeys.DURATION, this.duration);
        result.put(FieldsKeys.TAGS, Arrays.toString(this.tags));
        return result;
    }

}
