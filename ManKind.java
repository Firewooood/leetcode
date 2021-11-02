public class ManKind {
    int sex;
    int salary;
    
    public ManKind(int sex, int salary) {
        this.sex = sex;
        this.salary = salary;
    }
     public int getSex() {
         System.out.println(sex);
         return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public int getSalary() {
        System.out.println(salary);
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    void employeed() {
        if (salary == 0)
            System.out.println("no job");
        else
            System.out.println("job");
    }
    
    //自定义方法
    void manOrWoman() {
        if (this.sex == 1)
            System.out.println("man");
        if (this.sex == 0)
            System.out.println("woman");
    }
    
   
}