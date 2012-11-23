package org.melato.gps;


public class GpsPoint extends PointTime {
  /** GPX uses the term elevation, rather than altitude. */
  public float elevation = Float.NaN;
  public float speed = Float.NaN;
  public float bearing = Float.NaN;
  
  public float getElevation() {
    return elevation;
  }
  public void setElevation(float elevation) {
    this.elevation = elevation;
  }
  
  public void setAltitude(float elevation) {
    setElevation(elevation);
  }
  
  public float getAltitude() {
    return getElevation();
  }
  
  public float getSpeed() {
    return speed;
  }
  public void setSpeed(float speed) {
    this.speed = speed;
  }
    
  public float getBearing() {
    return bearing;
  }
  public void setBearing(float bearing) {
    this.bearing = bearing;
  }

  public GpsPoint() {    
  }
  public GpsPoint(float lat, float lon) {
    super(lat, lon);
  }
  public GpsPoint(Point2D p) {
    super(p);
  }
  public GpsPoint(PointTime p) {
    super(p);
  }
  
  public GpsPoint(GpsPoint p) {
    super(p);
    elevation = p.elevation;
    speed = p.speed;
    bearing = p.bearing;
  }

}
