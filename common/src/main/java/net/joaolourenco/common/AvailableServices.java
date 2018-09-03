package net.joaolourenco.common;

public enum AvailableServices {

    AccountsService("accounts-service");

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
