package validation.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class JavaUser {
    @NotEmpty
    @NotNull
    @Pattern(regexp = "[a-z]*", message = "Only lower case first name")
    private String name;

    private List<
            @NotNull
            @NotEmpty
            @Pattern(regexp = "\\d{10}", message = "Only 10 digits")
                    String> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
