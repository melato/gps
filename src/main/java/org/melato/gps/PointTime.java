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
  
  @Override
  public String toString() {
    return time + " " + super.toString();
  }
}
