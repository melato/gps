package org.melato.gps;

public class Earth {
  /** Earth's circumference in meters */
	public static final float CIRCUMFERENCE = 40044000;

  private static double square(double x) {
    return x * x;
  }

  /**
   * Haversine formula
   * http://en.wikipedia.org/wiki/Great-circle_distance
   * */
  public static float distance(Point p1, Point p2) {
    double lat1 = Math.toRadians(p1.lat);
    double lat2 = Math.toRadians(p2.lat);
    double lon1 = Math.toRadians(p1.lon);
    double lon2 = Math.toRadians(p2.lon);
    double d = square(Math.sin((lat1-lat2)/2)) + Math.cos(lat1)*Math.cos(lat2)*square(Math.sin((lon1-lon2)/2));
    d = 2 * Math.asin(Math.sqrt(d));
    /*
    double d = Math.sin(lat1)*Math.sin(lat2) +
        Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon1-lon2);
    double d = Math.acos(d);
     */
    return (float) (d * CIRCUMFERENCE / (2 * Math.PI));
  }

	/** Compute the latitude difference in degrees for a given distance on the same meridian.
	 * @param distance in meters
	 * @return latitude difference in degrees
	 */
	public static float latitudeForDistance(float distance) {
	  return (float) (distance / CIRCUMFERENCE * 360);
	}
	
	public static float metersPerDegreeLatitude() {
    return CIRCUMFERENCE / 360;
	}
	
  public static float metersPerDegreeLongitude(float latitude) {
    return (float) ((CIRCUMFERENCE / 360) * Math.cos(Math.toRadians(latitude)));    
  }
	
  /** Compute the longitude difference in degrees for a given small distance on a given latitude.
   * @param distance in meters
   * @param latitude in degrees
   * @return longitude difference in degrees
   */
	public static float longitudeForDistance(float distance, float lat) {
    return (float) ((distance / CIRCUMFERENCE * 360)/ Math.cos(Math.toRadians(lat)));    
  }
  
  /**
   * Compute the  bearing between two points in degrees.  Does not use elevation.
   * The bearing is the angle you have to travel from p1 east of North in order to reach p2 on a great circle.
   * @return
   */
  public static float bearing( Point p1, Point p2 ) {
    double lat1 = Math.toRadians(p1.lat);
    double lat2 = Math.toRadians(p2.lat);
    double lon1 = Math.toRadians(p1.lon);
    double lon2 = Math.toRadians(p2.lon);
    double t = Math.atan2( Math.sin(lon2-lon1)*Math.cos(lat2),
        Math.cos(lat1)*Math.sin(lat2)-Math.sin(lat1)*Math.cos(lat2)*Math.cos(lon2-lon1));
    return (float) Math.toDegrees(t);
  }
  
	/**
	 * Compute the speed between two GPS measurements, in metric units (m/s).
	 * @return
	 */
	public static float speed( Point p1, Point p2 ) {
		float time = Point.timeDifference(p1, p2);
		if ( time == 0 )
			return 0;
		return (float) (distance(p1, p2) / time );
	}
	
	
	
}
