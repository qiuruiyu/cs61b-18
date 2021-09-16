public class Planet {
    public double xxPos, yyPos;
    public double xxVel, yyVel;
    public double mass;
    public String imgFileName;

    /** Constructor of Planet */
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    /** Constructor of Planet */
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /** Calculate the distance between two planets */
    public double calcDistance(Planet p) {
        return Math.sqrt(Math.pow(this.xxPos - p.xxPos, 2) +
                         Math.pow(this.yyPos - p.yyPos, 2));
    }

    /** Calculated the direct force between two planets */
    public double calcForceExertedBy(Planet p) {
        double G = 6.67e-11;
        double F = G * this.mass * p.mass / Math.pow(this.calcDistance(p), 2);
        return F;
    }

    /** Calculate the X Force between two planets */
    public double calcForceExertedByX(Planet p) {
        double F = this.calcForceExertedBy(p);
        double Fx = F * (p.xxPos - this.xxPos) / this.calcDistance(p);
        return Fx;
    }

    /** Calculate the Y Force between two planets */
    public double calcForceExertedByY(Planet p) {
        double F = this.calcForceExertedBy(p);
        double Fy = F * (p.yyPos - this.yyPos) / this.calcDistance(p);
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double Fx = 0.0;
        for (Planet p: planets) {
            if (!(this.xxPos == p.xxPos)) {
                Fx += this.calcForceExertedByX(p);
            }
      }
        return Fx;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double Fy = 0;
        for (Planet p: planets) {
            if (!(this.yyPos == p.yyPos)) {
                Fy += this.calcForceExertedByY(p);
            }
        }
        return Fy;
    }

    /** update the planet condition with given force and time */
    public void update(double dt, double Fx, double Fy) {
        double ax = Fx / this.mass;
        double ay = Fy / this.mass;
        this.xxVel += dt * ax;
        this.yyVel += dt * ay;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    /** draw the planet */
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "./images/"+this.imgFileName);
    }


}
