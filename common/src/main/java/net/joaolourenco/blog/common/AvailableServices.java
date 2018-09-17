package net.joaolourenco.blog.common;

public enum AvailableServices {

    AuthenticationService("authentication-service");

    private final String serviceName;

    AvailableServices(String serviceName) {
        this.serviceName = serviceName;
    }

    public boolean equals(String otherName) {
        return serviceName.equals(otherName);
    }

    public String toString() {
        return this.serviceName;
    }

}