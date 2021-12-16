package com.niko.lesson_one_homework.task_one;

public class UserDto {

    private final Long id;

    private final String name, phone, email, address;

    private final Integer age;
    
    public UserDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.phone = builder.phone;
        this.email = builder.email;
        this.age = builder.age;
        this.address = builder.address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public static Builder builder(String name, String phone) {
        return new Builder(name, phone);
    }

    public static class Builder {

        private Long id;

        private final String name, phone;

        private String email, address;

        private Integer age;

        public Builder(String name, String phone) {

            if (name == null || phone == null) {
                throw new IllegalArgumentException("Either name or phone cannot be null!");
            }

            this.name = name;
            this.phone = phone;
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }
}
