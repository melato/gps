package org.melato.gps;



/**
 * Listens to PointTime updates.
 * Like LocationListener but uses PointTime.
 * */
public interface PointTimeListener {
  void setLocation(PointTime point);
}
