package com.timelocked;

/**
 * Pure interlock policy, shared with offline tests. Stage 4 is the only walk-through door state.
 */
public final class DockingRules {
  public static boolean firstEndpoint(long first, long second) {
    return first <= second;
  }

  public static int afterEqualization(boolean paired, boolean sealed, boolean supported) {
    return paired && sealed && supported ? 4 : 2;
  }

  public static boolean canRelease(int stage, boolean occupied) {
    return (stage == 1 || stage == 2) && !occupied;
  }

  public static boolean canClose(int stage, boolean doorwayOccupied) {
    return stage == 4 && !doorwayOccupied;
  }

  private DockingRules() {}
}
