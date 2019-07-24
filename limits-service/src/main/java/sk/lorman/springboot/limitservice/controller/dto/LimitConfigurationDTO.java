package sk.lorman.springboot.limitservice.controller.dto;

public class LimitConfigurationDTO {
    private final Integer minimum;
    private final Integer maximum;

    public LimitConfigurationDTO(Integer minimum, Integer maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }
}
