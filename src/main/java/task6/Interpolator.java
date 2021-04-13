package task6;

import java.util.ArrayList;
import java.util.List;

public class Interpolator {
     List<Point> points = new ArrayList<>();

     float getY(float x) {
          float y = 0;
          int n = points.size();
          for (int count = 0; count < n; count++) {
               float numerator = 1;
               float denominator = 1;

               for (int count2 = 0; count2 < n; count2++) {
                    if (count2 != count) {
                         numerator = numerator * (x - points.get(count2).x);
                         denominator = denominator * (points.get(count).x - points.get(count2).x);
                    }
               }
               y = y + (numerator / denominator) * points.get(count).y;
          }
          return y;
     }

     void setPoints(List<Point> points) {
          this.points = points;
     }

}
