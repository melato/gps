package org.melato.gps;

import java.io.Serializable;

public class Point2D implements Serializable {
  private static final long serialVersionUID = 1L;
  public float  lat;
  public float  lon;

  public float getLat() {
    return lat;
  }
  public void setLat(float lat) {
    this.lat = lat;
  }
  public float getLon() {
    return lon;
  }
  public void setLon(float lon) {
    this.lon = lon;
  }
  
  @Override
  public boolean equals(Object x) {
    if ( x instanceof PointTime ) {
      PointTime p = (PointTime) x;
      return lat == p.lat && lon == p.lon;
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    return new Float(lat).hashCode() + new Float(lon).hashCode();   
  }
  
  @Override
  public String toString() {
    return lat + ";" + lon;
  }
    
  public Point2D() {    
  }
  
  public Point2D(float lat, float lon) {
    super();
    this.lat = lat;
    this.lon = lon;
  }
  
  public Point2D(Point2D p) {
    this.lat = p.lat;
    this.lon = p.lon;
  }
}
