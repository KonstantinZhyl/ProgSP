public class PayedStudent extends Student {
    public PayedStudent(String fio, SEX sex, int age, String faculty, String speciality, String group) {
        this.fio = fio;
        this.age = age;
        this.sex = sex;
        this.faculty = faculty;
        this.speciality = speciality;
        this.group = group;
    }

    public PayedStudent(String faculty, String speciality, String group) {
        this.fio = "Unknown";
        this.age = 18;
        this.sex = SEX.Woman;
        this.faculty = faculty;
        this.speciality = speciality;
        this.group = group;
    }

    public PayedStudent() {
        this.fio = "Unknown";
        this.age = 18;
        this.sex = SEX.Woman;
        this.faculty = "ФИТУ";
        this.speciality = "АСОИ";
        this.group = "M3239";
    }

    public void learningForm(double x) {
        if (x <= 8) {
            System.out.println("Скидки не предусмотрено");
        }
        if ((x > 8) && (x <= 9)) {
            System.out.println("Скидка - 30%");
        }
        if (x > 9) {
            System.out.println("Скидка - 50%");
        }

    }

    public void print() {
        System.out.println("Студент " + fio + " платной формы, факультета '" +
                faculty + "' специальности '" + speciality + "'");
    }
}
