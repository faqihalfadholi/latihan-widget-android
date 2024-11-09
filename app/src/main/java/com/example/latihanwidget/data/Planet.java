package com.example.latihanwidget.data;

public class Planet {
        private String Planetname;
        private int Imageplanet;

        public Planet(String planetname, int imageplanet) {
            this.Planetname = planetname;
            this.Imageplanet = imageplanet;
        }

        public int getImageplanet() {
            return Imageplanet;
        }

        public void setImageplanet(int imageplanet) {
            Imageplanet = imageplanet;
        }


        public String getPlanetname() {
            return Planetname;
        }

        public void setPlanetname(String planetname) {
            Planetname = planetname;
        }

}
