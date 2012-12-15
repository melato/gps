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


/** A faster distance computation that is accurate near a particular reference point.
 * It is 6 times faster than GlobalDistance
 * A rough measurement shows it to be accurate within about 10 cm for distances ~ 10 Km for latitude 38.
 * @author Alex Athanasopoulos
 */
public class LocalDistance implements Metric {
  private float latScale;
  private float lonScale;
  
  public LocalDistance(Point2D reference) {
    latScale = Earth.metersPerDegreeLatitude();
    lonScale = Earth.metersPerDegreeLongitude(reference.getLat());
  }

  @Override
  public float distance(Point2D p1, Point2D p2) {
    float x = (p2.getLon() - p1.getLon()) * lonScale;
    float y = (p2.getLat() - p1.getLat()) * latScale;    
    return (float) Math.sqrt(x*x + y*y);
  }

}
