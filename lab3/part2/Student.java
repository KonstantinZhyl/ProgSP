/**
 * Created by ozzy on 03.10.2018.
 */
abstract class Student implements Learner, Object{
    String fio;
    SEX sex;
    int age;
    String faculty, speciality, group;

//    public Student(String fio, SEX sex, int age, String faculty, String speciality, String group) {
//        super(fio, sex, age);
//        this.faculty = faculty;
//        this.speciality = speciality;
//        this.group = group;
//    }
//
//    public Student(String faculty, String speciality, String group) {
//        super();
//        this.faculty = faculty;
//        this.speciality = speciality;
//        this.group = group;
//    }
//
//    public Student() {
//        super();
//        this.faculty = "ФРЭ";
//        this.speciality = "";
//        this.group = "M3239";
//    }


    @Override
    public String getFio() {
        return fio;
    }

    @Override
    public SEX getSex() {
        return sex;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String eduInstitution() {
        String ans = fio;
        if (sex == SEX.Man) {
            ans += " студент ";
        }
        else {
            ans += " студентка ";
        }
        ans += "возраст: ";
        ans += Integer.toString(age);
        ans += ", " + faculty + " " + speciality;
        ans += ", группа: " + group;
        return ans;
    }

    abstract public void learningForm(double x);
    abstract public void print();
}
