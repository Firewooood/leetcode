public class Kids extends ManKind {
    int yearsOld;

    public Kids(int sex, int salary, int yearsOld) {
        super(sex, salary);
        this.yearsOld = yearsOld;
    }

    void printAge() {
        System.out.println(yearsOld);
    }
}
