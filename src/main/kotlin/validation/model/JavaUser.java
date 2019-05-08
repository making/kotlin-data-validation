package validation.model;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.core.ConstraintViolations;
import am.ik.yavi.core.Validator;
import am.ik.yavi.fn.Either;

import java.util.List;

public class JavaUser {

    private String name;

    private List<String> phones;

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

    static final Validator<JavaUser> validator = ValidatorBuilder.of(JavaUser.class)
        .constraint(JavaUser::getName, "name",
            c -> c.notEmpty()
                .notNull()
                .pattern("[a-z]*").message("Only lower case first name"))
        .forEach(JavaUser::getPhones, "phones",
            b -> b.constraint(String::toString, "value",
                c -> c.notNull()
                    .notEmpty()
                    .pattern("\\d{10}").message("Only 10 digits")))
        .build();

    public Either<ConstraintViolations, JavaUser> validate() {
        return validator.validateToEither(this);
    }
}
