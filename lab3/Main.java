/**
 * Created by ozzy on 03.10.2018.
 */
public class Main {
    public static void main(String[] args) {
        Learner l = new Learner("Alexey Alexeevich Pinchuk", SEX.Man, 21);
        WriteInfo.info(l);
        System.out.println(l.eduInstitution());
        System.out.println();

        Pupil p = new Pupil("Dydyshko Andrey Vladimirovich", SEX.Man, 19, 'Я', 1);
        WriteInfo.info(p);
        System.out.println(p.eduInstitution());
        System.out.println();

        Student s = new Student("Zhylinskiy Konstantin Sergeevich", SEX.Man, 21, "ИЭФ", "ИСиТ(э)", "672303");
        WriteInfo.info(s);
        System.out.println(s.eduInstitution());
        System.out.println();

        PostGrad a = new PostGrad("Alexey Alexeevich Pinchuk", SEX.Man, 21, "Что-то очень умное", "Алехина Алина Энодиевна");
        WriteInfo.info(a);
        System.out.println(a.eduInstitution());
        System.out.println();
    }
}
