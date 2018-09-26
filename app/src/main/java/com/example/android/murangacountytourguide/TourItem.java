package com.example.android.murangacountytourguide;

/**
 * {@link TourItem} represents a list of locations located in Muranga County
 * It contains a title, event description, location and image
 */
public class TourItem {
    /**
     * Title of the tourItem
     */
    private String title;
    /**
     * Description of the tourItem
     */
    private String eventDesc;
    /**
     * Location of the tourItem
     */
    private String location;
    /**
     * Image of the tourItem
     */
    private int image = NO_IMAGE_PROVIDED;
    /**
     * Constant value that represents no image was provided
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new TourItem object that contains an image
     */
    public TourItem(String title, String eventDesc, String location, int image) {
        this.title = title;
        this.eventDesc = eventDesc;
        this.location = location;
        this.image = image;
    }

    /**
     * Create a new TourItem object that does not have an image
     */
    public TourItem(String title, String location, String eventDesc) {
        this.title = title;
        this.location = location;
        this.eventDesc = eventDesc;
    }

    /**
     * Get title of the tour item.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Set title of the tour item.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get description of the tour item.
     */
    public String getEventDesc() {
        return eventDesc;
    }
    /**
     * Set description of the tour item.
     */
    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    /**
     * Get image of the tour item.
     */
    public int getImage() {
        return image;
    }
    /**
     * Set image of the tour item.
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * Returns whether or not there is an image for this item.
     */
    public boolean hasImage() {
        return image != NO_IMAGE_PROVIDED;
    }

    /**
     * Get location of the tour item.
     */
    public String getLocation() {
        return location;
    }
    /**
     * Set location of the tour item.
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
