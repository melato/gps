package org.melato.gps;

import java.io.Serializable;
import java.util.Date;

public class PointTime extends Point2D implements Serializable {
  private static final long serialVersionUID = 1L;
  public long   time;
  public long getTime() {
    return time;
  }
  
  public boolean hasTime() {
    return time != 0;
  }
  
  public Date getDate() {
    if ( time == 0 )
      return null;
    return new Date(time);
  }

  /** Return the time difference between two points, in seconds. */
  public static float timeDifference(PointTime p1, PointTime p2) {
    return ((float) (p2.time - p1.time)) / 1000;
  }
  
  /** Return the time difference between two points, in milliseconds. */
  public static long timeDifferenceMillis(PointTime p1, PointTime p2) {
    return p2.time - p1.time;
  }
  
  public void setTime(long time) {
    this.time = time;
  }
  public void setTime(Date time) {
    this.time = time.getTime();
  }

  public PointTime() {    
  }
  
  public PointTime(float lat, float lon) {
    super();
    this.lat = lat;
    this.lon = lon;
  }
  public PointTime(Point2D p) {
    super(p);
  }
  public PointTime(PointTime p) {
    this.lat = p.lat;
    this.lon = p.lon;
    this.time = p.time;
  }
  

}
