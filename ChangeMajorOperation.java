package User;

@FunctionalInterface
public interface ChangeMajorOperation {
    void changeMajor(Student student, String newMajor);
}
