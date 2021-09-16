import javax.swing.text.html.parser.Parser;

public class NBody {
    public static double readRadius(String path) {
        In in = new In(path);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        int num = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[num];
        for(int i=0; i<num; i++) {
            Planet p = new Planet(in.readDouble(),
                                  in.readDouble(),
                                  in.readDouble(),
                                  in.readDouble(),
                                  in.readDouble(),
                                  in.readString());
            planets[i] = p;
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius;
        double time = 0;

        In in = new In(filename);
        in.readInt();
        radius = in.readDouble();
        Planet[] planets = readPlanets(filename);

        /* Draw Start */
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.enableDoubleBuffering();
        StdDraw.picture(0, 0, "./images/starfield.jpg");
        for(Planet p: planets) {
            p.draw();
        }
        StdDraw.show();

        while (time < T) {
            StdDraw.clear();
            double[] xForces = {0, 0, 0, 0, 0};
            double[] yForces = {0, 0, 0, 0, 0};
            for(int i=0; i<5; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            StdDraw.picture(0,0, "./images/starfield.jpg");
            for(int i=0; i<5; i++) {
                Planet p = planets[i];
                p.update(dt, xForces[i], yForces[i]);
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        /* Print out the info of planets when timeout */
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
