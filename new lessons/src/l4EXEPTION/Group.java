package l4EXEPTION;

import java.util.*;
import java.util.stream.Collectors;

public class Group implements Voenkom {
    private Student[] group = new Student[10];


    public Group() {
        super();
    }


    public Student consoleCreateStudent() {
        Scanner sc = new Scanner(System.in);
        return new Student(sc);
    }

    public Student[] getGroup() {
        return group;
    }

    public void setGroup(Student[] group) {
        this.group = group;
    }

    public void push(Student human, int i) {
        if (group[i] == null) {
            group[i] = human;
            System.out.println("Student " + human.getInfo() + " added in group");

//       } if (group[i] != null){
//           System.out.println(i+" Place is full");
//           for (i=0; i< group.length; i++){
//               if (group[i] == null){
//                   group[i] = human;
//                   System.out.println("Student: "+group[i].getInfo()+" added in "+i+" place");
//                   break;
//               }
//               }
//         }
        }

    }

    public void delete(int i) {
        if (group[i] != null) {
            String humanName = group[i].getName();
            group[i] = null;
            System.out.println("Student " + humanName + " delete for group");
        }
    }

    public String toString() {
        String humanName = " ";
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null) {
                humanName += group[i].getName() + " " + group[i].getSurname() + ".\n ";
            }
        }
        return "In group lern: " + humanName;
    }

    public void searce() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (Student st : group) {
            if (st.getSurname().equals(s)) {
                System.out.println("Студент: " + st.getName() + " " + st.getSurname() + " найден!");
            }
        }
    }

    public void sortByName() {
        Arrays.sort(group, (sA, sB) -> {
            if (sA == null) {
                return -1;
            }
            if (sB == null) {
                return 1;
            }
            if (sA.getName().compareTo(sB.getName()) < 0) {
                return -1;
            }
            if (sA.getName().compareTo(sB.getName()) > 0) {
                return 1;
            }

            return 0;
        });
    }

    public int sortAge() {

        for (int i = 0; i < group.length; i++) {
            if (group[i] == null) {
                continue;
            }
            if (group[i].getAge() > 18) {
                System.out.println(group[i].getInfo() + "\n");
            }
        }
        return 0;
    }

    public int sortAage() {
        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();
        for (int i = 0; i < group.length; i++) {
            if (group[i] == null) {
                continue;
            }
            if (group[i].getAge() == in) {
                System.out.println(group[i].getInfo() + "\n");
            }
        }
        return 0;
    }

    @Override
    public Student[] voenCom() {
        Student[] loxi = new Student[10];
        int counter = 0;
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null && group[i].getAge() >= 18 && group[i].getSex() == Sex.MAN) {
                loxi[counter] = group[i];
                counter += 1;
            }
        }
        return loxi;
    }
    public  void filterAbc(){
        Scanner scanner1 = new Scanner(System.in);
        String i = scanner1.nextLine();
        ArrayList<String> stringArrayList = new ArrayList<>();
        for(Student student:group){
            stringArrayList.add(student.getName());
        };
        Map<Object, List<String>> arrayCharList = stringArrayList.stream()

                .collect(Collectors.groupingBy((p) -> p.charAt(0) == i.charAt(0)));

        System.out.println(arrayCharList.get(true));
    }
}