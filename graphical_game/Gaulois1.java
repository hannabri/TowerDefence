package TowerDefence.graphical_game;

public class Gaulois1 {
    // location of the Gaulois
    private int location_x;
    private int location_y;

    // points of life
    private int pdv;

    // Le dommage qu'elle cause
    private int dommage;

    // Le coût de la plante
    private int cout;

    private int reach;

    public Gaulois1 (int x, int y) {
        this.location_x = x;
        this.location_y = y;

        setPdv(150);
        setCout(10);
        setDommage(20);
        setReach(1);

    }

        public boolean estMort() {
            if (this.pdv <= 0) {
                return true;
            }
            return false;
        }

        public void setPdv(int vie) {
            this.pdv = vie;
        }

        public void setDommage(int d){
            this.dommage = d;
        }

        public void setCout(int argent) {
            this.cout = argent;
        }

        public void setReach(int r) {
            this.reach = r;
        }

        // Est-ce qu'il nous faut un getter pour la position?
        public int getX() {
            return location_x;
        }

        public int getY() {
            return location_y;
        }

        public int getPdv () {
            return pdv;
        }

        public int getDommage() {
            return dommage;
        }

        public int getCout() {
            return cout;
        }

        public int getReach() {
            return reach;
        }

        // La plante est attaquée par un zombie
        public void recoitAttaque (int d) {
            this.pdv =  this.pdv - d;


    }

        public void setLocation(int gridX, int gridY) {
            this.location_x = gridX;
            this.location_y = gridY;
        }
}


