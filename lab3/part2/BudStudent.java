public class BudStudent extends Student {
    public BudStudent(String fio, SEX sex, int age, String faculty, String speciality, String group) {
        this.fio = fio;
        this.age = age;
        this.sex = sex;
        this.faculty = faculty;
        this.speciality = speciality;
        this.group = group;
    }

    public BudStudent(String faculty, String speciality, String group) {
        this.fio = "Unknown";
        this.age = 18;
        this.sex = SEX.Woman;
        this.faculty = faculty;
        this.speciality = speciality;
        this.group = group;
    }

    public BudStudent() {
        this.fio = "Unknown";
        this.age = 18;
        this.sex = SEX.Woman;
        this.faculty = "ФРЭ";
        this.speciality = "";
        this.group = "M3239";
    }

    public void learningForm(double x) {
        if (x <= 5) {
            System.out.println("Стипендия только в мечтах");
        }
        if (x > 9) {
            System.out.println("Стипендия - 105 БУНов");
            return;
        }
        if (x > 8) {
            System.out.println("Стипендия - 86 БУНов");
            return;
        }
        if (x > 6) {
            System.out.println("Стипендия - 70 БУНов");
            return;
        }
        if (x > 5) {
            System.out.println("Стипендия - 60 БУНов");
        }
    }

    public void print() {
        System.out.println("Студент " + fio + " бюджетной формы обучения, факультета '" +
                faculty + "' специальности '" + speciality + "'");
    }
}
