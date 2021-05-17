package ru.job4j.stream;

public class Employee {
    private String specialization;
    private String grade;
    private int cabinet;
    private char gender;
    private String education;
    private boolean assist;

    static class Builder {
        private String specialization;
        private String grade;
        private int cabinet;
        private char gender;
        private String education;
        private boolean assist;

        Builder buildSpecialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        Builder buildGrade(String grade) {
            this.grade = grade;
            return this;
        }

        Builder buildCabinet(int cabinet) {
            this.cabinet = cabinet;
            return this;
        }

        Builder buildGender(char gender) {
            this.gender = gender;
            return this;
        }

        Builder buildEducation(String education) {
            this.education = education;
            return this;
        }

        Builder buildAssist(boolean assist) {
            this.assist = assist;
            return this;
        }

        Employee build() {
                Employee employee = new Employee();
            employee.specialization = specialization;
            employee.grade = grade;
            employee.cabinet = cabinet;
            employee.gender = gender;
            employee.education = education;
            employee.assist = assist;
                return employee;
            }
        }
    }
