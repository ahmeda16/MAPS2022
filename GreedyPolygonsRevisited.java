import java.util.Scanner;
import java.awt.geom.*;
import java.awt.Polygon;


public class GreedyPolygonsRevisited {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int verts = in.nextInt();
        int distance = in.nextInt();
        int grabs = in.nextInt();

        int[] xcoords = new int[verts];
        int[] ycoords = new int[verts];
        

        for (int i = 0; i < verts; i++) {
            xcoords[i] = in.nextInt();
            ycoords[i] = in.nextInt();
        }
        
        // find centroid
        double centX = 0;
        double centY = 0;
        for (int i = 0; i < verts; i++) {
            centX += xcoords[i];
            centY += ycoords[i];
        }
        centX /= verts;
        centY /= verts;

        double[] tangle = new double[verts];
        // add tan angle to centroid for each point
        for (int i = 0; i < verts; i++) {
            tangle[i] = Math.atan2(ycoords[i] - centY, xcoords[i] - centX);
        }

        Polygon poly = new Polygon(xcoords, ycoords, verts);
        GeneralPath genp = new GeneralPath(poly);
        Area area = new Area(genp);
        System.out.println(">>>> " + area.isPolygonal());
        //System.out.println((xcoords[2] + xcoords[1]) * (ycoords[2] + ycoords[1]));
                                                  
        double polyArea = 0;
        double perimeter = 0;
        for (int i = 0; i < verts; i++) {
            int j = (verts + i - 1) % verts;
            //polyArea += xcoords[j] * ycoords[i] - ycoords[j] * xcoords[i];
            polyArea +=  (xcoords[j] + xcoords[i]) * (ycoords[j] + ycoords[i]);
            System.out.println((xcoords[j] + xcoords[i]) * (ycoords[j] + ycoords[i]));

            perimeter += Math.sqrt(
                Math.pow(xcoords[i] - xcoords[j], 2) + 
                Math.pow(ycoords[i] - ycoords[j], 2));
        }
        polyArea = Math.abs(polyArea / 2);

        // Polygon poly = new Polygon(xcoords, ycoords, verts);

        // System.out.println(poly.getVertext(0));

        double circleArea = Math.PI * Math.pow(distance * grabs, 2);
        double grabArea = perimeter * distance * grabs;

        //System.out.println(polyArea + circleArea + grabArea);
        System.out.println("\n" + polyArea);
        System.out.println(circleArea);
        System.out.println(grabArea);
    }
}
