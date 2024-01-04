package com.tempdecal.java.design.patterns.Creational;

public class Builder {
    public static class Computer {

        public static void main(String[] args) {
            //Using builder to get the object in a single line of code and
            //without any inconsistent state or arguments management issues
            Computer comp = new Computer.ComputerBuilder(
                    "500 GB", "2 GB").setBluetoothEnabled(true)
                    .setGraphicsCardEnabled(true).setResolution("1080P").build();
        }

        //required parameters
        private String HDD;
        private String RAM;

        //optional parameters
        private String resolution;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;


        public String getHDD() {
            return HDD;
        }

        public String getRAM() {
            return RAM;
        }

        public String getResolution() {
            return resolution;
        }

        public boolean isGraphicsCardEnabled() {
            return isGraphicsCardEnabled;
        }

        public boolean isBluetoothEnabled() {
            return isBluetoothEnabled;
        }

        private Computer(ComputerBuilder builder) {
            this.HDD = builder.HDD;
            this.RAM = builder.RAM;
            this.resolution = builder.resolution;
            this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
            this.isBluetoothEnabled = builder.isBluetoothEnabled;
        }

        //Builder Class
        public static class ComputerBuilder {

            // required parameters
            private String HDD;
            private String RAM;

            // optional parameters
            private String resolution;
            private boolean isGraphicsCardEnabled;
            private boolean isBluetoothEnabled;

            public ComputerBuilder(String hdd, String ram) {
                this.HDD = hdd;
                this.RAM = ram;
            }

            public ComputerBuilder setResolution(String resolution) {
                this.resolution = resolution;
                return this;
            }

            public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
                this.isGraphicsCardEnabled = isGraphicsCardEnabled;
                return this;
            }

            public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
                this.isBluetoothEnabled = isBluetoothEnabled;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }
}
