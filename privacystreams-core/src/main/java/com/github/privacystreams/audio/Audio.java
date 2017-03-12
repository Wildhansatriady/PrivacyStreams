package com.github.privacystreams.audio;

import android.net.Uri;

import com.github.privacystreams.core.Function;
import com.github.privacystreams.core.Item;
import com.github.privacystreams.core.MultiItemStream;
import com.github.privacystreams.core.SingleItemStream;
import com.github.privacystreams.core.providers.MultiItemStreamProvider;
import com.github.privacystreams.core.providers.SingleItemStreamProvider;
import com.github.privacystreams.utils.annotations.PSItem;
import com.github.privacystreams.utils.annotations.PSItemField;

/**
 * An Audio item represents an audio record
 */
@PSItem
public class Audio extends Item {

    /**
     * The timestamp of when current item is generated.
     */
    @PSItemField(type = Long.class)
    public static final String TIMESTAMP = "timestamp";

    /**
     * The URI of the audio file.
     */
    @PSItemField(type = String.class)
    public static final String URI = "uri";

    Audio(long timestamp, Uri file_uri) {
        this.setFieldValue(TIMESTAMP, timestamp);
        this.setFieldValue(URI, file_uri.toString());
    }

    /**
     * Get a item provider that provides a audio item,
     * the audio item represents a recorded audio with certain length of time
     * @param duration the time duration of audio
     * @return the provider
     */
    public static Function<Void, SingleItemStream> record(long duration) {
        return new AudioRecorder(duration);
    }

    /**
     * Get a stream provider that provides a audio item,
     * each audio item represents a recorded audio with certain length of time.
     * Audio is recorded every certain time.
     *
     * @param duration_per_record the time duration per audio record
     * @param interval the interval between each audio record
     * @return the provider
     */
    public static Function<Void, MultiItemStream> recordPeriodically(long duration_per_record, long interval) {
        return new AudioPeriodicRecorder(duration_per_record, interval);
    }
}
