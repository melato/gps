/*-------------------------------------------------------------------------
 * Copyright (c) 2012, Alex Athanasopoulos.  All Rights Reserved.
 * alex@melato.org
 *-------------------------------------------------------------------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *-------------------------------------------------------------------------
 */
package org.melato.gps;

import java.io.Serializable;
import java.util.Date;

/** A point in GPX spacetime (latitude, longitude, elevation, time) */
public class Point implements Serializable {
  private static final long serialVersionUID = 1L;
  public float	lat;
	public float	lon;
	/** GPX uses the term elevation, rather than altitude. */
	public float elevation = Float.NaN;
	public long		time;
	public float speed = Float.NaN;
	public float bearing = Float.NaN;
	
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
	public static float timeDifference(Point p1, Point p2) {
		return ((float) (p2.time - p1.time)) / 1000;
	}
	
  /** Return the time difference between two points, in milliseconds. */
  public static long timeDifferenceMillis(Point p1, Point p2) {
    return p2.time - p1.time;
  }
  
  public void setTime(long time) {
    this.time = time;
  }
	public void setTime(Date time) {
		this.time = time.getTime();
	}
	public Point(){}
	public Point(float lat, float lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}
	public Point(float lat, float lon, float elevation, long time) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.elevation = elevation;
		this.time = time;				
	}
	public Point(Point p) {
	  this.lat = p.lat;
	  this.lon = p.lon;
	  this.elevation = p.elevation;
	  this.time = p.time;
	  this.speed = p.speed;
	  this.bearing = p.bearing;
	}
	
	@Override
	public boolean equals(Object x) {
		if ( x instanceof Point ) {
			Point p = (Point) x;
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
		
}
